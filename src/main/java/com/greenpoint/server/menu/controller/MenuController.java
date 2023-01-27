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


    @GetMapping("/menu/{id}")
    public ResponseEntity<List<Menu>> findByStoreId(@PathVariable Long id){
        List<Menu> res = menuService.findByStoreId(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/menu/{id}")
    public ResponseEntity<Menu> create(@PathVariable Long id, @RequestBody MenuRequest request){
        Menu res = menuService.create(Menu.from(id, request));
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/menu/{id}")
    public ResponseEntity<Menu> update(@PathVariable Long id, @RequestBody MenuRequest request){
        Menu res = menuService.update(id, request);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/menu/{id}")
    public void delete(@PathVariable Long id){
        menuService.delete(id);
    }


}
