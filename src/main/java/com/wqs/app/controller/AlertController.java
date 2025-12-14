package com.wqs.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.wqs.app.entity.Alert;
import com.wqs.app.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService service;

    public AlertController(AlertService service) {
        this.service = service;
    }

    @GetMapping
    public List<Alert> getAll() {
        return service.getAllAlerts();
    }
    
    @GetMapping("/unread")
    public List<Alert> getUnread() {
        return service.getUnreadAlerts();
    }

    @PutMapping("/{id}/read")
    public String markAsRead(@PathVariable Long id) {
        return service.markAsRead(id);
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteAlert(id);
    }


}
