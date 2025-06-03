package com.todo.notifications.service;

import com.todo.notifications.dto.NotificationDTO;
import com.todo.notifications.dto.NotificationPOJO;
import java.util.List;

public interface INotificationService {

  void createNotification(NotificationDTO dto);

  List<NotificationPOJO> getAll();

  List<NotificationPOJO> getPending();

}
