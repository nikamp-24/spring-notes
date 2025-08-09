# Spring Boot Annotations: @Primary, @Autowired, and @Qualifier

This example demonstrates how to resolve **multiple bean injection conflicts** in Spring Boot using:

- **`@Primary`** → Sets the default bean.
- **`@Autowired`** → Automatically injects dependencies.
- **`@Qualifier`** → Explicitly chooses the bean to inject.

---

## 1. Base Setup

We have:

- **Interface:** `Computer`
- **Implementations:** `Laptop`, `Desktop`
- **User class:** `Dev` (developer) that needs a `Computer`
- **Main Spring Boot App:** To run the code

---

### Step 1 — Interface
```java
package com.pooja.demoApp;

public interface Computer {
    void build();
}
