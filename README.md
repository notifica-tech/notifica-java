# Notifica Java SDK

Official Java SDK for the [Notifica](https://usenotifica.com.br) notification platform.

[![Maven Central](https://img.shields.io/maven-central/v/com.notifica/notifica-java.svg)](https://search.maven.org/artifact/com.notifica/notifica-java)
[![Java Version](https://img.shields.io/badge/Java-11%2B-blue.svg)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## Features

- 🔧 **Easy Integration** — Simple, fluent API design
- ⚡ **Async Support** — All methods available as sync and async (CompletableFuture)
- 🔄 **Automatic Retries** — Built-in exponential backoff for transient failures
- 🔑 **Idempotency** — Automatic idempotency key generation for safe retries
- 📊 **Type-Safe** — Full Jackson POJO mapping for all API responses
- 🛡️ **Error Handling** — Comprehensive exception hierarchy (ApiException, ValidationException, RateLimitException)

## Requirements

- Java 11 or higher
- Gradle or Maven for dependency management

## Installation

### Gradle

```kotlin
dependencies {
    implementation("com.notifica:notifica-java:0.1.0")
}
```

### Maven

```xml
<dependency>
    <groupId>com.notifica</groupId>
    <artifactId>notifica-java</artifactId>
    <version>0.1.0</version>
</dependency>
```

## Quick Start

```java
import com.notifica.sdk.Notifica;
import com.notifica.sdk.models.*;
import java.util.Map;

// Initialize with your API key
Notifica notifica = new Notifica("nk_live_your_api_key_here");

// Send a notification
Notification notification = notifica.notifications().send(
    new SendNotificationParams()
        .setChannel("whatsapp")
        .setTo("+5511999999999")
        .setTemplate("welcome")
        .setData(Map.of("name", "João"))
);

System.out.println("Sent: " + notification.getId());
```

## Configuration

```java
import com.notifica.sdk.Notifica;
import com.notifica.sdk.NotificaConfig;
import java.time.Duration;

NotificaConfig config = NotificaConfig.builder()
    .apiKey("nk_live_your_api_key_here")
    .baseUrl("https://app.usenotifica.com.br/v1")  // Optional: default
    .timeout(Duration.ofSeconds(30))              // Optional: default 30s
    .maxRetries(3)                                // Optional: default 3
    .autoIdempotency(true)                        // Optional: default true
    .build();

Notifica notifica = new Notifica(config);
```

## Usage Examples

### Notifications

```java
// Send notification
Notification notification = notifica.notifications().send(
    new SendNotificationParams()
        .setChannel("email")
        .setTo("user@example.com")
        .setTemplate("welcome")
        .setData(Map.of("name", "John"))
);

// Send with metadata
Notification notification = notifica.notifications().send(
    new SendNotificationParams()
        .setChannel("sms")
        .setTo("+5511999999999")
        .setTemplate("otp")
        .setMetadata(Map.of("source", "mobile_app")),
    RequestOptions.withIdempotencyKey("order-123-otp")
);

// List notifications with pagination
PaginatedResponse<Notification> page = notifica.notifications().list(
    Map.of("channel", "email", "status", "delivered", "limit", 50)
);

// Get notification details
Notification details = notifica.notifications().get("notif_123");

// List delivery attempts
List<MessageAttempt> attempts = notifica.notifications().listAttempts("notif_123");
```

### Async Operations

All methods have async variants returning `CompletableFuture`:

```java
import java.util.concurrent.CompletableFuture;

// Send notification asynchronously
CompletableFuture<Notification> future = notifica.notifications().sendAsync(
    new SendNotificationParams()
        .setChannel("whatsapp")
        .setTo("+5511999999999")
        .setTemplate("welcome")
);

future.thenAccept(notification -> {
    System.out.println("Sent: " + notification.getId());
});

// Or use join() for blocking
Notification notification = future.join();
```

### Templates

```java
// Create template
Template template = notifica.templates().create(
    new CreateTemplateParams()
        .setName("welcome")
        .setChannel("email")
        .setSubject("Welcome {{name}}!")
        .setBody("Hello {{name}}, welcome to our platform!")
);

// List templates
PaginatedResponse<Template> templates = notifica.templates().list();

// Get template
Template template = notifica.templates().get("welcome");

// Update template
Template updated = notifica.templates().update(
    "welcome",
    new UpdateTemplateParams()
        .setSubject("Welcome to {{company}}!")
);

// Delete template
notifica.templates().delete("old-template");
```

### Subscribers

```java
// Create subscriber
Subscriber subscriber = notifica.subscribers().create(
    new CreateSubscriberParams()
        .setExternalId("user-123")
        .setEmail("user@example.com")
        .setPhone("+5511999999999")
);

// List subscribers
PaginatedResponse<Subscriber> subscribers = notifica.subscribers().list();

// Get subscriber
Subscriber subscriber = notifica.subscribers().get("sub_123");

// Update subscriber
Subscriber updated = notifica.subscribers().update(
    "sub_123",
    new UpdateSubscriberParams()
        .setEmail("new@example.com")
);

// Delete subscriber
notifica.subscribers().delete("sub_123");

// Get preferences
SubscriberPreferences prefs = notifica.subscribers().getPreferences("sub_123");

// Update preferences
SubscriberPreferences updated = notifica.subscribers().updatePreferences(
    "sub_123",
    new UpdatePreferencesParams()
        .setPreferences(Map.of("email", true, "sms", false))
);
```

### Workflows

```java
// Create workflow
Workflow workflow = notifica.workflows().create(
    new CreateWorkflowParams()
        .setName("onboarding")
        .setTrigger("subscriber.created")
        .setSteps(List.of(
            Map.of("channel", "email", "template", "welcome", "delay", 0),
            Map.of("channel", "email", "template", "tips", "delay", 86400)
        ))
);

// List workflows
PaginatedResponse<Workflow> workflows = notifica.workflows().list();

// Get workflow
Workflow workflow = notifica.workflows().get("wf_123");

// Update workflow
Workflow updated = notifica.workflows().update(
    "wf_123",
    new UpdateWorkflowParams()
        .setEnabled(false)
);

// Delete workflow
notifica.workflows().delete("wf_123");

// Trigger workflow
WorkflowRun run = notifica.workflows().trigger(
    "wf_123",
    new TriggerWorkflowParams()
        .setSubscriberId("sub_123")
        .setData(Map.of("name", "John"))
);
```

### Channels

```java
// List configured channels
List<ChannelConfiguration> channels = notifica.channels().list();

// Create channel
ChannelConfiguration channel = notifica.channels().create(
    new CreateChannelParams()
        .setChannel("whatsapp")
        .setProvider("twilio")
        .setConfig(Map.of(
            "account_sid", "AC...",
            "auth_token", "..."
        ))
);

// Get channel
ChannelConfiguration channel = notifica.channels().get("chan_123");

// Update channel
ChannelConfiguration updated = notifica.channels().update(
    "chan_123",
    new UpdateChannelParams()
        .setEnabled(true)
);

// Delete channel
notifica.channels().delete("chan_123");

// Test channel
TestChannelResult result = notifica.channels().test("chan_123");
```

### Webhooks

```java
// Create webhook
Webhook webhook = notifica.webhooks().create(
    new CreateWebhookParams()
        .setUrl("https://example.com/webhook")
        .setEvents(List.of("notification.delivered", "notification.failed"))
        .setSecret("whsec_...")
);

// List webhooks
PaginatedResponse<Webhook> webhooks = notifica.webhooks().list();

// Get webhook
Webhook webhook = notifica.webhooks().get("wh_123");

// Update webhook
Webhook updated = notifica.webhooks().update(
    "wh_123",
    new UpdateWebhookParams()
        .setEvents(List.of("notification.delivered"))
);

// Delete webhook
notifica.webhooks().delete("wh_123");

// List deliveries
List<WebhookDelivery> deliveries = notifica.webhooks().listDeliveries("wh_123");
```

### Analytics

```java
// Get analytics overview
AnalyticsOverview overview = notifica.analytics().overview();

// Get channel analytics
List<ChannelAnalytics> channelStats = notifica.analytics().byChannel(
    Map.of("start_date", "2025-01-01", "end_date", "2025-01-31")
);

// Get timeseries data
List<TimeseriesPoint> timeseries = notifica.analytics().timeseries();

// Get top templates
List<TemplateAnalytics> topTemplates = notifica.analytics().topTemplates();
```

### SMS & Compliance

```java
// Create SMS provider
SmsProvider provider = notifica.sms().providers().create(
    new CreateSmsProviderParams()
        .setName("Twilio Production")
        .setProvider("twilio")
        .setConfig(Map.of(
            "account_sid", "AC...",
            "auth_token", "..."
        ))
);

// List providers
List<SmsProvider> providers = notifica.sms().providers().list();

// Set default provider
SmsProvider updated = notifica.sms().providers().setDefault("provider_123");

// Check compliance status
SmsComplianceSettings compliance = notifica.sms().compliance().get();

// Update compliance settings
SmsComplianceSettings updated = notifica.sms().compliance().update(
    new UpdateSmsComplianceParams()
        .setOptInRequired(true)
        .setOptInMessage("Reply YES to receive updates")
);

// Get consent status
SmsConsent consent = notifica.sms().consents().get("+5511999999999");

// Update consent
SmsConsent updated = notifica.sms().consents().update(
    "+5511999999999",
    new CreateSmsConsentParams()
        .setStatus("opted_in")
        .setSource("web_form")
);

// Bulk import consents
BulkImportSmsConsentResult result = notifica.sms().consents().bulkImport(
    List.of(
        Map.of("phone", "+5511999999999", "status", "opted_in"),
        Map.of("phone", "+5511888888888", "status", "opted_out")
    )
);
```

### Billing

```java
// List plans
List<BillingPlan> plans = notifica.billing().plans().list();

// Get current subscription
Subscription subscription = notifica.billing().subscription().get();

// Subscribe to plan
Subscription subscription = notifica.billing().subscription().subscribe(
    Map.of("plan", "pro", "billing_cycle", "monthly")
);

// Change plan
Subscription updated = notifica.billing().subscription().changePlan(
    Map.of("plan", "enterprise")
);

// Cancel subscription
Subscription cancelled = notifica.billing().subscription().cancel(
    Map.of("at_period_end", true)
);

// Reactivate subscription
Subscription reactivated = notifica.billing().subscription().reactivate();

// Calculate proration
CalculateProrationResult proration = notifica.billing().subscription().calculateProration(
    Map.of("plan", "enterprise", "billing_cycle", "yearly")
);

// List invoices
PaginatedResponse<Invoice> invoices = notifica.billing().invoices().list();

// Get invoice
Invoice invoice = notifica.billing().invoices().get("inv_123");

// List payment methods
List<PaymentMethod> methods = notifica.billing().paymentMethods().list();

// Add payment method
PaymentMethod method = notifica.billing().paymentMethods().add(
    Map.of("type", "card", "token", "tok_...")
);

// Set default payment method
PaymentMethod default = notifica.billing().paymentMethods().setDefault("pm_123");

// Remove payment method
notifica.billing().paymentMethods().remove("pm_123");
```

### API Keys

```java
// Create API key
ApiKey key = notifica.apiKeys().create(
    new CreateApiKeyParams()
        .setName("Production Server")
        .setPermissions(List.of("notifications:write", "templates:read"))
);

System.out.println("Key: " + key.getKey()); // Only shown once!

// List API keys
List<ApiKey> keys = notifica.apiKeys().list();

// Revoke API key
notifica.apiKeys().revoke("key_123");
```

### Domains

```java
// Create domain
Domain domain = notifica.domains().create(
    new CreateDomainParams()
        .setDomain("notifications.example.com")
        .setRegion("us-east-1")
);

// List domains
PaginatedResponse<Domain> domains = notifica.domains().list();

// Get domain
Domain domain = notifica.domains().get("dom_123");

// Delete domain
notifica.domains().delete("dom_123");

// Get domain health
DomainHealth health = notifica.domains().health("dom_123");
```

### Inbox (for frontend integration)

```java
// List inbox notifications
PaginatedResponse<InboxNotification> notifications = notifica.inbox()
    .listNotifications("subscriber_123");

// Get unread count
int count = notifica.inbox().getUnreadCount("subscriber_123");

// Mark as read
MarkInboxReadResult result = notifica.inbox().markRead("inbox_notif_123");

// Mark all as read
MarkInboxReadAllResult result = notifica.inbox().markAllRead("subscriber_123");
```

### Inbox Embed

```java
// Get embed settings
InboxEmbedSettings settings = notifica.inboxEmbed().get();

// Update embed settings
InboxEmbedSettings updated = notifica.inboxEmbed().update(
    new UpdateInboxEmbedSettingsParams()
        .setTheme("dark")
        .setPosition("bottom-right")
        .setPrimaryColor("#007bff")
);

// Rotate embed key
RotateEmbedKeyResult result = notifica.inboxEmbed().rotateKey();
```

## Error Handling

The SDK throws typed exceptions for different error scenarios:

```java
try {
    Notification notification = notifica.notifications().send(params);
} catch (ValidationException e) {
    // 422 validation errors
    Map<String, List<String>> details = e.getDetails();
    System.err.println("Validation failed: " + details);
} catch (RateLimitException e) {
    // 429 rate limit exceeded
    Integer retryAfter = e.getRetryAfter();
    System.err.println("Rate limited. Retry after: " + retryAfter + "s");
} catch (ApiException e) {
    // Other API errors (4xx, 5xx)
    System.err.println("API error: " + e.getStatus() + " - " + e.getMessage());
} catch (NotificaException e) {
    // Network or other errors
    System.err.println("Error: " + e.getMessage());
}
```

## Advanced Usage

### Custom Request Options

```java
import com.notifica.sdk.models.common.RequestOptions;
import java.time.Duration;

// Per-request options override client defaults
RequestOptions options = RequestOptions.withIdempotencyKey("unique-key-123");

Notification notification = notifica.notifications().send(params, options);
```

### Handling Pagination

```java
PaginatedResponse<Notification> page = notifica.notifications().list();

// Access data
List<Notification> notifications = page.getData();

// Check if more pages exist
if (page.getMeta().isHasMore()) {
    String nextCursor = page.getMeta().getCursor();
    
    // Fetch next page
    PaginatedResponse<Notification> nextPage = notifica.notifications().list(
        Map.of("cursor", nextCursor, "limit", 50)
    );
}
```

## Building from Source

```bash
./gradlew build
```

Run tests:

```bash
./gradlew test
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

- Documentation: https://docs.usenotifica.com.br
- API Reference: https://docs.usenotifica.com.br/api
- Issues: https://github.com/notifica-tech/notifica-java/issues
