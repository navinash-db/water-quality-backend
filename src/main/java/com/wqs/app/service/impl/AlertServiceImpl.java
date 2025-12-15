package com.wqs.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wqs.app.entity.Alert;
import com.wqs.app.repository.AlertRepository;
import com.wqs.app.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRepository repo;

    public AlertServiceImpl(AlertRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Alert> getAllAlerts() {
        return repo.findAll();
    }

    @Override
    public void createAlert(String message, String location, String quality) {
        Alert alert = new Alert();
        alert.setMessage(message);
        alert.setLocation(location);
        alert.setQuality(quality);
        repo.save(alert);
    }
    
    @Override
    public List<Alert> getUnreadAlerts() {
        return repo.findByReadStatusFalse();
    }

    @Override
    public String markAsRead(Long id) {

        Alert alert = repo.findById(id).orElse(null);

        if (alert == null) {
            return "Alert not found";
        }

        alert.setReadStatus(true);
        repo.save(alert);

        return "Alert marked as read";
    }
    
    @Override
    public String deleteAlert(Long id) {

        if (!repo.existsById(id)) {
            return "Alert not found";
        }

        repo.deleteById(id);
        return "Alert deleted successfully";
    }


}
