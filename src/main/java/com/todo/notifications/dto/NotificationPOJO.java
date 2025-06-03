package com.todo.notifications.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationPOJO {
  private Long id;
  private String message;
  private LocalDateTime date;
  private boolean completed;

  public NotificationPOJO(Long id, String message, LocalDateTime date, boolean completed) {
    this.id = id;
    this.message = message;
    this.date = date;
    this.completed = completed;
  }

}
