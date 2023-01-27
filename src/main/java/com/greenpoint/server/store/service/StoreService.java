package com.greenpoint.server.store.service;

import com.greenpoint.server.exception.GlobalException;
import com.greenpoint.server.store.model.Store;
import com.greenpoint.server.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;


    @Transactional(readOnly = true)
    public Store findById(Long storeId) {
        Store ret = storeRepository.findById(storeId).get();
        return ret;
    }
}
