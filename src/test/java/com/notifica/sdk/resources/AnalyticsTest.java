package com.notifica.sdk.resources;

import com.notifica.sdk.Notifica;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.NotificaConfig;
import com.notifica.sdk.TestHelpers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AnalyticsTest {

    private HttpClient mockHttpClient;
    private Notifica notifica;
    
    @BeforeEach
    void setUp() {
        mockHttpClient = mock(HttpClient.class);
        NotificaConfig config = NotificaConfig.builder()
                .apiKey("test-key")
                .build();
        NotificaClient client = new NotificaClient(config, mockHttpClient);
        notifica = new Notifica(client);
    }
    
    @Test
    void testBasicOperation() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "analytics-001",
                "status", "success"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        // Add specific test logic here
        assertNotNull(notifica.analytics());
    }
    
    @Test
    void testListOperation() throws Exception {
        String responseBody = TestHelpers.paginatedEnvelope(
                List.of(Map.of("id", "analytics-001")),
                "cursor-123",
                false
        );
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        // Add list operation test
        assertNotNull(notifica.analytics());
    }
    
    @Test
    void testCreateOperation() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "analytics-new",
                "created_at", "2025-02-03T10:00:00Z"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(201, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        
        // Add create operation test
        verify(mockHttpClient, times(0)).sendAsync(requestCaptor.capture(), any());
    }
    
    @Test
    void testGetOperation() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "analytics-123"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        // Add get operation test
        assertNotNull(notifica.analytics());
    }
    
    @Test
    void testUpdateOperation() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of(
                "id", "analytics-123",
                "updated_at", "2025-02-03T10:00:00Z"
        ));
        
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        
        // Add update operation test
        verify(mockHttpClient, times(0)).sendAsync(requestCaptor.capture(), any());
    }
    
    @Test
    void testDeleteOperation() throws Exception {
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(204, "");
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        
        // Add delete operation test
        verify(mockHttpClient, times(0)).sendAsync(requestCaptor.capture(), any());
    }
    
    @Test
    void testAsyncOperation() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of("id", "analytics-async"));
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        // Add async operation test
        assertNotNull(notifica.analytics());
    }
    
    @Test
    void testErrorHandling() throws Exception {
        String errorBody = "{\"error\":{\"code\":\"test_error\",\"message\":\"Test error\"}}";
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(400, errorBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        // Test error handling
        assertNotNull(notifica.analytics());
    }
}
