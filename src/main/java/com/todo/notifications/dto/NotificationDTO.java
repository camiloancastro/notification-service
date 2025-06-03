package com.todo.notifications.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class NotificationDTO {
  private Long taskId;
  private String message;
  private boolean completed;
}