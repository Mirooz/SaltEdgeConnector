# Salt Edge API Client

A Java client library for the Salt Edge API (v6), built with Spring WebFlux for reactive operations.

## Features

- Full support for Salt Edge API v6
- Reactive programming with Project Reactor
- Type-safe response handling
- Comprehensive provider, customer, account, and transaction operations

## Requirements

- Java 17 or higher
- Spring Framework 6.1.3
- Project Reactor

## Installation

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.saltedge</groupId>
    <artifactId>salt-edge-connector</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Configuration

Configure your Salt Edge API credentials in your application properties:

```properties
saltedge.api.base-url=https://www.saltedge.com/api/v6
saltedge.api.app-id=your-app-id
saltedge.api.secret=your-secret
```

## Usage

### Initialize the client

```java
@Autowired
private SaltEdgeClient saltEdgeClient;
```

### Examples

Get all providers:
```java
Flux<Provider> providers = saltEdgeClient.getAllProviders();
```

Create a customer:
```java
Mono<Customer> customer = saltEdgeClient.createCustomer("customer-identifier");
```

Get transactions for an account:
```java
Flux<Transaction> transactions = saltEdgeClient.getTransactionsByAccount(
    "account-id",
    LocalDate.now().minusDays(30),
    LocalDate.now()
);
```

## Response Handling

The client uses wrapper classes to handle Salt Edge API responses:

- `SaltEdgeResponse<T>` for list responses
- `SaltEdgeSingleResponse<T>` for single object responses

These wrappers handle the standard Salt Edge response format including metadata.

## Error Handling

The client uses reactive error handling. Errors are propagated through the reactive streams and can be handled using standard Project Reactor operators.
