package com.notifica.sdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.ArgumentMatcher;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestHelpers {
    
    private static final ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Create a mock HTTP response with the given status and body.
     */
    @SuppressWarnings("unchecked")
    public static <T> HttpResponse<T> mockResponse(int status, String body) {
        HttpResponse<T> response = (HttpResponse<T>) mock(HttpResponse.class);
        when(response.statusCode()).thenReturn(status);
        when(response.body()).thenReturn((T) body);
        when(response.headers()).thenReturn(java.net.http.HttpHeaders.of(
                Map.of(),
                (a, b) -> true
        ));
        return response;
    }
    
    /**
     * Wrap data in a SingleResponse envelope.
     */
    public static String envelope(Object data) {
        try {
            return mapper.writeValueAsString(Map.of("data", data));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Wrap data in a paginated response envelope.
     */
    public static String paginatedEnvelope(List<?> data, String cursor, boolean hasMore) {
        try {
            return mapper.writeValueAsString(Map.of(
                    "data", data,
                    "meta", Map.of(
                            "cursor", cursor,
                            "has_more", hasMore
                    )
            ));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Wrap data in a Map with "data" key.
     */
    public static String dataMap(Object data) {
        try {
            return mapper.writeValueAsString(Map.of("data", data));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Matcher for HttpRequest with specific method.
     */
    public static class HttpRequestMethodMatcher implements ArgumentMatcher<HttpRequest> {
        private final String method;
        
        public HttpRequestMethodMatcher(String method) {
            this.method = method;
        }
        
        @Override
        public boolean matches(HttpRequest request) {
            return request != null && request.method().equals(method);
        }
        
        @Override
        public String toString() {
            return "HttpRequest with method " + method;
        }
    }
    
    /**
     * Matcher for HttpRequest with specific URI path.
     */
    public static class HttpRequestPathMatcher implements ArgumentMatcher<HttpRequest> {
        private final String path;
        
        public HttpRequestPathMatcher(String path) {
            this.path = path;
        }
        
        @Override
        public boolean matches(HttpRequest request) {
            return request != null && request.uri().getPath().contains(path);
        }
        
        @Override
        public String toString() {
            return "HttpRequest with path containing " + path;
        }
    }
}
