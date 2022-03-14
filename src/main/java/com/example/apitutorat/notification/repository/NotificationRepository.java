package com.example.apitutorat.notification.repository;

import com.example.apitutorat.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
