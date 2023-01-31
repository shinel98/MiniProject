package com.greenpoint.server.history.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryCntResponse;
import com.greenpoint.server.history.model.HistoryResponse;
import com.greenpoint.server.history.repository.HistoryRepository;
import com.greenpoint.server.level.model.Level;
import com.greenpoint.server.level.service.LevelService;
import com.greenpoint.server.storeLevel.model.StoreLevel;
import com.greenpoint.server.storeLevel.service.StoreLevelService;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map.Entry;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private LevelService levelService;

    @Autowired
    private StoreLevelService storeLevelService;

    @PersistenceContext
    private EntityManager em;




    @Transactional
    public Long create(History history, Customer customer){
        History res = historyRepository.save(history);

        int grade = customer.getLevel().getGrade();
        customer.usepoint(history.getUsedPoint());
        int newgrade = customer.addpoint(history.getSavedPoint());
        if(newgrade > grade){
            Level level = levelService.findByGrade(newgrade);
            customer.upgrade(level);
        }
        res.pointCheck(customer);

        int before = res.getStore().getStoreLevel().getGrade();
        int after = res.getStore().pointUp(history.getSavedPoint());
        if(after > before) {
            StoreLevel level = storeLevelService.findByGrade(after);
            history.getStore().gradeChange(level);
        }
        return res.getId();
    }


    @Transactional
    public List<HistoryResponse> findAllById(Long customerId) {
        List<History> histories = historyRepository.findAllById(customerId);
        return histories.stream().map(HistoryResponse::from).collect(Collectors.toList());
    }

    @Transactional
    public int[] findDailyHistory(Long customerId) throws ParseException {
        String maxDate = historyRepository.findMaxDate(customerId);
        String minDate = historyRepository.findMinDate(customerId);
        List<String> existDate = historyRepository.findExistDate(customerId);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date max_date = formatter.parse(maxDate);
        System.out.println("max_date = " + max_date);
        Date min_date = formatter.parse(minDate);
        System.out.println("min_date = " + min_date);
        long diffSec = (max_date.getTime() - min_date.getTime()) / 1000;
        long diffDays = diffSec / (24*60*60); // 일자수 차이
        System.out.println("diffDays = " + diffDays);

        Map<Date, Integer> existDateList = new HashMap<>();
        for(String value : existDate){
            String[] temp = value.split(",");
            Date temp_date = formatter.parse(temp[0]);
            Integer point = Integer.valueOf(temp[1]);
            existDateList.put(temp_date, point);
        }
        for (Entry<Date, Integer> entrySet : existDateList.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(min_date); // 시간 설정
        int[] arr = new int[(int)diffDays+1];

        if(existDateList.containsKey(min_date)) {
            arr[0] = existDateList.get(min_date);
        }
        for(int i=1; i<diffDays+1; i++){
            cal1.add(Calendar.DATE, 1); // 일 연산
            Date de = new Date(cal1.getTimeInMillis());

            if(existDateList.containsKey(de)) {
                System.out.println("들어옴");
                System.out.println("i: " + i);
                System.out.println("existDateList: " + existDateList.get(de));
                arr[i] = existDateList.get(de);
                continue;
            }
            arr[i] = 0;
        }


        return arr;
    }

    @Transactional
    public List<HistoryResponse> findThreeByCID(Long cid) {
        List<History> histories = em.createQuery("select h from History h where h.customerId = " + cid + " and h.savedPoint != " + 0 + " order by h.created_at desc").setMaxResults(3).getResultList();
        return histories.stream().map(HistoryResponse::from).collect(Collectors.toList());
    }


//    @Transactional
//    public List<Integer> findDailyHistory(Long customerId) {
//        List<Integer> histories = historyRepository.findDailyHistory(customerId);
//        System.out.println("histories = " + histories);
//        return histories;
//    }

}
