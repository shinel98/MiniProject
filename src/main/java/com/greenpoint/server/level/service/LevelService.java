package com.greenpoint.server.level.service;

import com.greenpoint.server.level.model.Level;
import com.greenpoint.server.level.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Transactional
    public Level create(Level level){
        Level ret = levelRepository.save(level);
        return ret;
    }

    public Level findByGrade(int newgrade) {
        Level ret = levelRepository.findByGrade(newgrade);
        return ret;
    }
}
