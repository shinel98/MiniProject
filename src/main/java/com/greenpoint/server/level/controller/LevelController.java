package com.greenpoint.server.level.controller;

import com.greenpoint.server.level.model.Level;
import com.greenpoint.server.level.model.LevelRequest;
import com.greenpoint.server.level.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api")
public class LevelController {

    @Autowired
    private LevelService levelService;

    @PostMapping(value="/level")
    public ResponseEntity<Level> create(@RequestBody LevelRequest request){
        Level res = levelService.create(Level.from(request));
        return ResponseEntity.ok(res);
    }

}
