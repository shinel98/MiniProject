package com.greenpoint.server.menu.service;

import com.greenpoint.server.menu.model.Menu;
import com.greenpoint.server.menu.model.MenuRequest;
import com.greenpoint.server.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;


    @Transactional
    public void delete(Long menuid) {
         menuRepository.deleteById(menuid);
    }

    @Transactional
    public Menu update(Long menuid, MenuRequest request) {
        Menu menu = menuRepository.findById(menuid).get();
        menu.update(request);
        return menu;
    }

    @Transactional
    public Menu create(Menu from) {
        Menu ret = menuRepository.save(from);
        return ret;
    }

    @Transactional(readOnly = true)
    public List<Menu> findByStoreId(Long storeid) {
        List<Menu> ret = menuRepository.findByStoreId(storeid);
        return ret;
    }
}
