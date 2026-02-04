package com.notifica.sdk.resources;

import com.notifica.sdk.Notifica;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.NotificaConfig;
import com.notifica.sdk.TestHelpers;
import com.notifica.sdk.models.MessageAttempt;
import com.notifica.sdk.models.Notification;
import com.notifica.sdk.models.SendNotificationParams;
import com.notifica.sdk.models.common.PaginatedResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class NotificationsTest {

    private HttpClient mockHttpClient;
    private Notifica notifica;
    
    @BeforeEach
    void setUp() {
        mockHttpClient = mock(HttpClient.class);
        NotificaConfig config = NotificaConfig.builder()
                .apiKey("test-key")
                .build()
                ;
        NotificaClient client = new NotificaClient(config, mockHttpClient);
        notifica = new Notifica(client);
    }
    
    @Test
    void testSendNotification() throws Exception {
        // Mock response
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "notif-001",
                "channel", "whatsapp",
                "recipient", "+5511999999999",
                "status", "pending",
                "created_at", "2025-02-03T10:00:00Z"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(202, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        // Execute
        SendNotificationParams params = new SendNotificationParams()
                .setChannel("whatsapp")
                .setTo("+5511999999999")
                .setTemplate("welcome")
                .setData(Map.of("name", "João"))
                ;
        
        Notification result = notifica.notifications().send(params);
        
        // Verify
        assertNotNull(result);
        assertEquals("notif-001", result.getId());
        assertEquals("whatsapp", result.getChannel());
        assertEquals("pending", result.getStatus());
        
        // Verify request
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        HttpRequest request = requestCaptor.getValue();
        assertEquals("POST", request.method());
        assertTrue(request.uri().toString().contains("/notifications"));
        assertTrue(request.headers().firstValue("Authorization").orElse("").contains("test-key"));
    }
    
    @Test
    void testSendAsync() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "notif-002",
                "channel", "email",
                "recipient", "test@example.com",
                "status", "pending",
                "created_at", "2025-02-03T10:00:00Z"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(202, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        SendNotificationParams params = new SendNotificationParams()
                .setChannel("email")
                .setTo("test@example.com")
                .setTemplate("welcome")
                ;
        
        Notification result = notifica.notifications().sendAsync(params).join();
        
        assertNotNull(result);
        assertEquals("notif-002", result.getId());
        assertEquals("email", result.getChannel());
    }
    
    @Test
    void testListNotifications() throws Exception {
        String responseBody = TestHelpers.paginatedEnvelope(
                List.of(Map.of(
                        "id", "notif-001",
                        "channel", "email",
                        "recipient", "test@example.com",
                        "status", "delivered",
                        "created_at", "2025-02-03T10:00:00Z"
                )),
                "cursor-123",
                true
        );
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        Map<String, Object> params = new HashMap<>();
        params.put("channel", "email");
        params.put("status", "delivered");
        params.put("limit", 50);
        
        PaginatedResponse<Notification> result = notifica.notifications().list(params);
        
        assertNotNull(result);
        assertNotNull(result.getData());
        assertEquals(1, result.getData().size());
        assertEquals("notif-001", result.getData().get(0).getId());
        assertTrue(result.getMeta().isHasMore());
        assertEquals("cursor-123", result.getMeta().getCursor());
        
        // Verify query parameters
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        String uri = requestCaptor.getValue().uri().toString();
        assertTrue(uri.contains("channel=email"));
        assertTrue(uri.contains("status=delivered"));
        assertTrue(uri.contains("limit=50"));
    }
    
    @Test
    void testGetNotification() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "notif-42",
                "channel", "whatsapp",
                "recipient", "+5511999999999",
                "status", "delivered",
                "created_at", "2025-02-03T10:00:00Z"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        Notification result = notifica.notifications().get("notif-42");
        
        assertNotNull(result);
        assertEquals("notif-42", result.getId());
        assertEquals("delivered", result.getStatus());
        
        // Verify path
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        assertTrue(requestCaptor.getValue().uri().toString().contains("/notifications/notif-42"));
    }
    
    @Test
    void testListAttempts() throws Exception {
        String responseBody = TestHelpers.dataMap(List.of(
                Map.of(
                        "id", "attempt-1",
                        "channel", "whatsapp",
                        "status", "delivered",
                        "attempted_at", "2025-02-03T10:00:00Z"
                )
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        List<MessageAttempt> result = notifica.notifications().listAttempts("notif-001");
        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("attempt-1", result.get(0).getId());
        
        // Verify path
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        assertTrue(requestCaptor.getValue().uri().toString().contains("/notifications/notif-001/attempts"));
    }
    
    @Test
    void testWithIdempotencyKey() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "notif-001",
                "channel", "sms",
                "recipient", "+5511999",
                "status", "pending",
                "created_at", "2025-02-03T10:00:00Z"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(202, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        SendNotificationParams params = new SendNotificationParams()
                .setChannel("sms")
                .setTo("+5511999")
                ;
        
        notifica.notifications().send(params, com.notifica.sdk.models.common.RequestOptions.withIdempotencyKey("idem-123"));
        
        // Verify idempotency key header
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        HttpRequest request = requestCaptor.getValue();
        assertEquals("idem-123", request.headers().firstValue("Idempotency-Key").orElse(null));
    }
}
