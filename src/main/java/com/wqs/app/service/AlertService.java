package com.wqs.app.service;

import java.util.List;
import com.wqs.app.entity.Alert;

public interface AlertService {

    List<Alert> getAllAlerts();

    void createAlert(String message, String location, String quality);
    
    List<Alert> getUnreadAlerts();
    
    String markAsRead(Long id);

    String deleteAlert(Long id);


}
