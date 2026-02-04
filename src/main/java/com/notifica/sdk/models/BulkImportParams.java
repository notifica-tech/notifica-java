package com.notifica.sdk.models;

import java.util.List;

public class BulkImportParams {

    private List<CreateSubscriberParams> subscribers;

    public BulkImportParams() {}

    public List<CreateSubscriberParams> getSubscribers() { return subscribers; }
    public BulkImportParams setSubscribers(List<CreateSubscriberParams> subscribers) { this.subscribers = subscribers; return this; }
}
