package com.greenpoint.server.history.controller;
import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.service.CustomerService;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryRequest;
import com.greenpoint.server.history.model.HistoryResponse;
import com.greenpoint.server.history.service.HistoryService;
import com.greenpoint.server.store.model.Store;
import com.greenpoint.server.store.service.StoreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/history/{cid}")
    public ResponseEntity<List<HistoryResponse>> findAllById(@PathVariable Long cid){
        List<HistoryResponse> res = historyService.findAllById(cid);
        return ResponseEntity.ok(res);
    }

    @PostMapping(value="/history")
    public ResponseEntity<Long> addHistory(@RequestBody HistoryRequest request){
        Customer customer = customerService.findById(request.getCustomerId());
        Store store = storeService.findById(request.getStoreId());
        Long res = historyService.create(History.from(store, request), customer);
        return ResponseEntity.ok(res);
    }
    @GetMapping(value="/dailyHistory")
    public int[] readDailyHistory(@RequestParam("customerId") Long customerId) throws ParseException {
        int[] arr = historyService.findDailyHistory(customerId);
        return arr;
    }

    @GetMapping(value="/history/three/{cid}")
    public ResponseEntity<List<HistoryResponse>> findThreeByCID(@PathVariable Long cid){
        List<HistoryResponse> res = historyService.findThreeByCID(cid);
        return ResponseEntity.ok(res);
    }


//    @GetMapping(value="/dailyHistory")
//    public List<Integer> readDailyHistory(@RequestParam("customerId") Long customerId){
//        List<Integer> histories = historyService.findDailyHistory(customerId);
//        return histories;
//    }


}
