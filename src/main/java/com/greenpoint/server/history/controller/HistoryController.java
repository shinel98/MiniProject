package com.greenpoint.server.history.controller;

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


//    @GetMapping(value = "/history/{token}")
//    public ResponseEntity<List<HistoryResponse>> findAllHistoryByCustomer(){
//
//
//    }


    @PostMapping(value="/history")
    public ResponseEntity<Long> addHistory(@RequestBody HistoryRequest request){
        Store store = storeService.findById(request.getStoreId());
        Long res = historyService.create(History.from(store, request));
        return ResponseEntity.ok(res);
    }

}
