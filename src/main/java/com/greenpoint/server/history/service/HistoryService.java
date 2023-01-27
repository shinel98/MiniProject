package com.greenpoint.server.history.service;

import com.greenpoint.server.customer.model.Customer;
import com.greenpoint.server.customer.service.CustomerService;
import com.greenpoint.server.history.model.History;
import com.greenpoint.server.history.model.HistoryResponse;
import com.greenpoint.server.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;



    @Transactional
    public Long create(History history, Customer customer){
        History res = historyRepository.save(history);
        customer.addpoint(history.getSavedPoint());
        customer.usepoint(history.getUsedPoint());
        return res.getId();
    }

    @Transactional
    public List<HistoryResponse> findAllById(Long customerId) {
        List<History> histories = historyRepository.findAllById(customerId);
        return histories.stream().map(HistoryResponse::from).collect(Collectors.toList());
    }
}
