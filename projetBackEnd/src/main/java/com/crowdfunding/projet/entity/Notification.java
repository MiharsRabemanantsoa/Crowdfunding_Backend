package com.crowdfunding.projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notification", nullable = false)
    private Long id_notification;

    @ManyToOne
    private Projet projet;

    @Column
    private boolean read = false;

    @Column
    private  String corps;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false,columnDefinition = "DATE")
    private Calendar daterecu;

    @ManyToOne
    @JoinColumn(name = "user_notif_id_user")
    private Users userNotif;

}
