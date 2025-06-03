package com.todo.notifications.service;

import com.todo.notifications.dto.NotificationDTO;
import com.todo.notifications.dto.NotificationPOJO;
import com.todo.notifications.model.Notification;
import com.todo.notifications.repository.NotificationRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


class NotificationServiceTest {

  @Mock
  private NotificationRepository repository;

  @InjectMocks
  private NotificationServiceImpl service;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void createNotification_shouldSaveNotification() {
    NotificationDTO dto = new NotificationDTO();
    dto.setMessage("Test notification");
    dto.setCompleted(false);

    service.createNotification(dto);

    verify(repository, times(1)).save(any(Notification.class));
  }

  @Test
  void getAll_shouldReturnListOfPOJO() {
    Notification n = new Notification();
    n.setId(1L);
    n.setMessage("Test");
    n.setCompleted(false);
    n.setDate(LocalDateTime.now());

    when(repository.findAll()).thenReturn(List.of(n));

    List<NotificationPOJO> result = service.getAll();
    assertEquals(1, result.size());
    assertEquals("Test", result.get(0).getMessage());
  }

  @Test
  void getPending_shouldReturnOnlyPending() {
    Notification n1 = new Notification();
    n1.setId(1L);
    n1.setMessage("Pendiente");
    n1.setCompleted(false);
    n1.setDate(LocalDateTime.now());

    when(repository.findByCompletedFalse()).thenReturn(List.of(n1));

    List<NotificationPOJO> result = service.getPending();
    assertEquals(1, result.size());
    assertFalse(result.get(0).isCompleted());
  }

}
