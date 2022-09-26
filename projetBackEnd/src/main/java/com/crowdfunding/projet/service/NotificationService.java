package com.crowdfunding.projet.service;


import com.crowdfunding.projet.entity.Notification;
import com.crowdfunding.projet.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;


    //service pour changer le statut en lu
    public Notification changeNotifStatusToRead(Long id_notification) {
        var notif = notificationRepository.findById(id_notification)
                .orElseThrow(() -> new RuntimeException("not found!"));
        notif.setRead(true);
        return notificationRepository.save(notif);
    }

    //create notification
    public void SaveNotification(Notification notification){notificationRepository.save(notification); }




}
