package com.greenpoint.server.store.controller;

import com.greenpoint.server.store.model.Store;
import com.greenpoint.server.store.model.StoreRequest;
import com.greenpoint.server.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value="/store")
    public ResponseEntity<List<Store>> findAll(){
        List<Store> res = storeService.findAll();
        return ResponseEntity.ok(res);
    }
    @GetMapping(value="/store/{id}")
    public ResponseEntity<Store> findById(@PathVariable Long id){
        Store res = storeService.findById(id);
        return ResponseEntity.ok(res);
    }

//    @GetMapping(value="/store/three/{id}")
//    public ResponseEntity<List<Store>> findThreeById(@PathVariable Long id){
//        List<Store> res = storeService.findThreeById(id);
//        return ResponseEntity.ok(res);
//    }

    @PostMapping(value="/store")
    public ResponseEntity<Store> create(@RequestBody StoreRequest request){
        Store res = storeService.create(Store.from(request));
        return ResponseEntity.ok(res);
    }
    @PatchMapping(value="/store/{sid}")
    public ResponseEntity<Store> update(@PathVariable Long sid, @RequestBody StoreRequest request){
        Store res = storeService.update(sid, request);
        return ResponseEntity.ok(res);
    }
    @DeleteMapping(value="/store/{sid}")
    public void delete(@PathVariable Long sid){
        storeService.delete(sid);
    }

}
