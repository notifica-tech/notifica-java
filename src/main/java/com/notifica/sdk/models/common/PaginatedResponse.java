package com.notifica.sdk.models.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Paginated API response containing a list of items and pagination metadata.
 *
 * @param <T> the type of items in the response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginatedResponse<T> {

    private List<T> data;
    private PaginationMeta meta;

    public PaginatedResponse() {}

    public PaginatedResponse(List<T> data, PaginationMeta meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PaginationMeta getMeta() {
        return meta;
    }

    public void setMeta(PaginationMeta meta) {
        this.meta = meta;
    }
}
