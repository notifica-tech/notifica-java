package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BulkImportResult {

    private int imported;
    private List<Subscriber> subscribers;

    public BulkImportResult() {}

    public int getImported() { return imported; }
    public void setImported(int imported) { this.imported = imported; }

    public List<Subscriber> getSubscribers() { return subscribers; }
    public void setSubscribers(List<Subscriber> subscribers) { this.subscribers = subscribers; }
}
