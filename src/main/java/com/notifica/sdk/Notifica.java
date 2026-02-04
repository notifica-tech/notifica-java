package com.notifica.sdk;

import com.notifica.sdk.resources.*;

/**
 * Official Java SDK for the Notifica notification platform.
 *
 * <p>Main entry point for the SDK. Create an instance with your API key:
 *
 * <pre>{@code
 * // Simple usage
 * Notifica notifica = new Notifica("nk_live_...");
 *
 * // Or with custom configuration
 * Notifica notifica = new Notifica(NotificaConfig.builder()
 *     .apiKey("nk_live_...")
 *     .baseUrl("https://api.usenotifica.com.br/v1")
 *     .timeout(Duration.ofSeconds(30))
 *     .maxRetries(3)
 *     .build());
 *
 * // Send a notification
 * Notification notification = notifica.notifications().send(
 *     new SendNotificationParams()
 *         .setChannel("whatsapp")
 *         .setTo("+5511999999999")
 *         .setTemplate("welcome")
 *         .setData(Map.of("name", "João")));
 *
 * // Async usage
 * notifica.notifications().sendAsync(params)
 *     .thenAccept(n -> System.out.println(n.getId()));
 * }</pre>
 */
public class Notifica {

    private final Notifications notifications;
    private final Templates templates;
    private final Workflows workflows;
    private final Subscribers subscribers;
    private final Channels channels;
    private final Domains domains;
    private final Webhooks webhooks;
    private final ApiKeys apiKeys;
    private final Analytics analytics;
    private final Sms sms;
    private final Billing billing;
    private final InboxEmbed inboxEmbed;
    private final Inbox inbox;

    /**
     * Creates a new Notifica client instance.
     *
     * @param apiKey your API key (nk_live_..., nk_test_..., pk_live_..., or pk_test_...)
     * @throws IllegalArgumentException if apiKey is null or empty
     */
    public Notifica(String apiKey) {
        this(NotificaConfig.builder().apiKey(apiKey).build());
    }

    /**
     * Creates a new Notifica client instance with custom configuration.
     *
     * @param config the configuration for this client
     * @throws IllegalArgumentException if config is null or API key is missing
     */
    public Notifica(NotificaConfig config) {
        this(new NotificaClient(config));
    }
    
    /**
     * Creates a new Notifica instance with a custom NotificaClient.
     * Public for testing with mocked clients.
     *
     * @param client the NotificaClient to use
     */
    public Notifica(NotificaClient client) {
        this.notifications = new Notifications(client);
        this.templates = new Templates(client);
        this.workflows = new Workflows(client);
        this.subscribers = new Subscribers(client);
        this.channels = new Channels(client);
        this.domains = new Domains(client);
        this.webhooks = new Webhooks(client);
        this.apiKeys = new ApiKeys(client);
        this.analytics = new Analytics(client);
        this.sms = new Sms(client);
        this.billing = new Billing(client);
        this.inboxEmbed = new InboxEmbed(client);
        this.inbox = new Inbox(client);
    }

    /**
     * Notifications resource - send and manage notifications.
     */
    public Notifications notifications() {
        return notifications;
    }

    /**
     * Templates resource - create and manage message templates.
     */
    public Templates templates() {
        return templates;
    }

    /**
     * Workflows resource - create and trigger automated workflows.
     */
    public Workflows workflows() {
        return workflows;
    }

    /**
     * Subscribers resource - manage notification subscribers.
     */
    public Subscribers subscribers() {
        return subscribers;
    }

    /**
     * Channels resource - configure notification channels.
     */
    public Channels channels() {
        return channels;
    }

    /**
     * Domains resource - manage sending domains.
     */
    public Domains domains() {
        return domains;
    }

    /**
     * Webhooks resource - configure webhooks for events.
     */
    public Webhooks webhooks() {
        return webhooks;
    }

    /**
     * ApiKeys resource - manage API keys.
     */
    public ApiKeys apiKeys() {
        return apiKeys;
    }

    /**
     * Analytics resource - view analytics and metrics.
     */
    public Analytics analytics() {
        return analytics;
    }

    /**
     * Sms resource - manage SMS providers, compliance, and consents.
     */
    public Sms sms() {
        return sms;
    }

    /**
     * Billing resource - manage billing plans, subscription, invoices, and payment methods.
     */
    public Billing billing() {
        return billing;
    }

    /**
     * InboxEmbed resource - configure inbox embed widget settings.
     */
    public InboxEmbed inboxEmbed() {
        return inboxEmbed;
    }

    /**
     * Inbox resource - public inbox operations for frontend integration.
     */
    public Inbox inbox() {
        return inbox;
    }
}
