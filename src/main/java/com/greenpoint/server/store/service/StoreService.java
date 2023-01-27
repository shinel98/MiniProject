package com.greenpoint.server.store.service;

import com.greenpoint.server.exception.GlobalException;
import com.greenpoint.server.store.model.Store;
import com.greenpoint.server.store.model.StoreRequest;
import com.greenpoint.server.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;


    @Transactional(readOnly = true)
    public Store findStoreById(Long storeId) {
        Store ret = storeRepository.findById(storeId).get();
        return ret;
    }

    @Transactional(readOnly = true)
    public List<Store> findAll() {
        List<Store> ret = storeRepository.findAll();
        return ret;
    }

    @Transactional
    public Store create(Store store) {
        Store ret = storeRepository.save(store);
        return ret;
    }

    @Transactional
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }

    @Transactional
    public Store update(Long id, StoreRequest request) {
        Store ret = this.findOne(id);
        ret.update(request);
        return ret;
    }

    private Store findOne(Long id) {
        return storeRepository.findById(id).get();
    }
}
