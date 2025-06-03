package com.todo.notifications.controller;

import com.todo.notifications.dto.NotificationDTO;
import com.todo.notifications.dto.NotificationPOJO;
import com.todo.notifications.service.INotificationService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {

  private final INotificationService service;

  // Solo debe ser ejecutado por el microservicio de todo-app
  @PostMapping
  public void create(@RequestBody NotificationDTO dto) {
    log.info(dto.toString());
    service.createNotification(dto);
  }

  @GetMapping
  public List<NotificationPOJO> getAll() {
    return service.getAll();
  }

  @GetMapping("/pending")
  public List<NotificationPOJO> getPending() {
    return service.getPending();
  }

}
