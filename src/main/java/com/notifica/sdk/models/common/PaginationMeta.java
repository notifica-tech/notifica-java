package com.notifica.sdk.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationMeta {

    private String cursor;

    @JsonProperty("has_more")
    private boolean hasMore;

    public PaginationMeta() {}

    public PaginationMeta(String cursor, boolean hasMore) {
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
