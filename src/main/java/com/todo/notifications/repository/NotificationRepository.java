package com.todo.notifications.repository;

import com.todo.notifications.model.Notification;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
  List<Notification> findByCompletedFalse();
}
