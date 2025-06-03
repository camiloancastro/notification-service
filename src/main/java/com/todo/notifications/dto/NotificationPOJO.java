package com.todo.notifications.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationPOJO {
  private Long id;
  private Long taskId;
  private String message;
  private LocalDateTime date;
  private boolean completed;


  public NotificationPOJO(Long id, Long taskId,
      String message, LocalDateTime date, boolean completed) {
    this.id = id;
    this.taskId = taskId;
    this.message = message;
    this.date = date;
    this.completed = completed;
  }

}
