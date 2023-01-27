package com.greenpoint.server.history.service;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryCntResponse;
import com.greenpoint.server.history.model.HistoryResponse;
import com.greenpoint.server.history.repository.HistoryRepository;
import com.greenpoint.server.level.model.Level;
import com.greenpoint.server.level.service.LevelService;
import com.greenpoint.server.storeLevel.model.StoreLevel;
import com.greenpoint.server.storeLevel.service.StoreLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

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
