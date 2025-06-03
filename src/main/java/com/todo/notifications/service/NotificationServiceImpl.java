package com.todo.notifications.service;

import com.todo.notifications.dto.NotificationDTO;
import com.todo.notifications.dto.NotificationPOJO;
import com.todo.notifications.model.Notification;
import com.todo.notifications.repository.NotificationRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements INotificationService{

  private final NotificationRepository repository;

  @Override
  public void createNotification(NotificationDTO dto) {
    Notification n = new Notification();
    n.setTaskId(dto.getTaskId());
    n.setMessage(dto.getMessage());
    n.setCompleted(dto.isCompleted());
    n.setDate(LocalDateTime.now());
    repository.save(n);
  }

  @Override
  public List<NotificationPOJO> getAll() {
    return repository.findAll().stream()
        .map(n -> new NotificationPOJO(
            n.getId(),
            n.getTaskId(),
            n.getMessage(),
            n.getDate(),
            n.isCompleted()))
        .collect(Collectors.toList());
  }

  @Override
  public List<NotificationPOJO> getPending() {
    return repository.findByCompletedFalse().stream()
        .map(n -> new NotificationPOJO(
            n.getId(),
            n.getTaskId(),
            n.getMessage(),
            n.getDate(),
            n.isCompleted()))
        .collect(Collectors.toList());
  }
}
