package com.greenpoint.server.history.service;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.service.CustomerService;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private CustomerService customerService;

    @Transactional
    public Long create(History history){
        History res = historyRepository.save(history);
        Customer customer = customerService.findById(history.getCustomerId());
        customer.addpoint(history.getSavedPoint());
        customer.usepoint(history.getUsedPoint());
        return res.getId();
    }


}
