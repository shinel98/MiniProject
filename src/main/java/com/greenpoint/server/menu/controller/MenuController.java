package com.greenpoint.server.menu.controller;

import com.greenpoint.server.menu.model.Menu;
import com.greenpoint.server.menu.model.MenuRequest;
import com.greenpoint.server.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/menu/{sid}")
    public ResponseEntity<List<Menu>> findByStoreId(@PathVariable Long sid){
        List<Menu> res = menuService.findByStoreId(sid);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/menu/{sid}")
    public ResponseEntity<Menu> create(@PathVariable Long sid, @RequestBody MenuRequest request){
        Menu res = menuService.create(Menu.from(sid, request));
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/menu/{mid}")
    public ResponseEntity<Menu> update(@PathVariable Long mid, @RequestBody MenuRequest request){
        Menu res = menuService.update(mid, request);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/menu/{mid}")
    public void delete(@PathVariable Long mid){
        menuService.delete(mid);
    }


}
