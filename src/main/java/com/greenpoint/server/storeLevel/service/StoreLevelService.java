package com.greenpoint.server.storeLevel.service;

import com.greenpoint.server.storeLevel.model.StoreLevel;
import com.greenpoint.server.storeLevel.repository.StoreLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreLevelService {

    @Autowired
    private StoreLevelRepository storeLevelRepository;


    @Transactional
    public StoreLevel findByGrade(int after) {
        StoreLevel storeLevel = storeLevelRepository.findByGrade(after);
        return storeLevel;
    }
}
