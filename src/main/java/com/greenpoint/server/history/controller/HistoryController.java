package com.greenpoint.server.history.controller;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.service.CustomerService;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryRequest;
import com.greenpoint.server.history.model.HistoryResponse;
import com.greenpoint.server.history.service.HistoryService;
import com.greenpoint.server.store.model.Store;
import com.greenpoint.server.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private StoreService storeService;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/history/{id}")
    public ResponseEntity<List<HistoryResponse>> findAllById(@PathVariable Long customerId){
        List<HistoryResponse> res = historyService.findAllById(customerId);
        return ResponseEntity.ok(res);
    }


    @PostMapping(value="/history")
    public ResponseEntity<Long> addHistory(@RequestBody HistoryRequest request){
        Customer customer = customerService.findWithId(request.getCustomerId());
        Store store = storeService.findStoreById(request.getStoreId());
        Long res = historyService.create(History.from(store, request), customer);
        return ResponseEntity.ok(res);
    }

}
