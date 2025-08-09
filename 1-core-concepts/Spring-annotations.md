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
```

Step 2 — Implementation 1: Laptop

```java
package com.pooja.demoApp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    @Override
    public void build() {
        System.out.println("Building code on Laptop");
    }
}
```

Step 3 — Implementation 2: Desktop

```java
package com.pooja.demoApp;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    @Override
    public void build() {
        System.out.println("Building code on Desktop");
    }
}
```

2. The Problem Without @Primary / @Qualifier
If you just do this:
```java
package com.pooja.demoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired
    Computer comp;  // Which one? Laptop or Desktop?

    public void build() {
        comp.build();
    }
}
```

Spring will throw:
NoUniqueBeanDefinitionException: expected single matching bean but found 2: laptop,desktop

Why?
Both Laptop and Desktop implement Computer, so Spring doesn’t know which one to inject.

3. Solution 1 — @Primary
If you want Laptop to be the default:
```java
package com.pooja.demoApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Laptop implements Computer {
    @Override
    public void build() {
        System.out.println("Building code on Laptop");
    }
}

```

4. Solution 2 — @Qualifier
If you want explicit control:
```java
package com.pooja.demoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired
    @Qualifier("desktop")  // Bean name = class name with lowercase first letter
    Computer comp;

    public void build() {
        comp.build();
    }
}
```

Main App
```java

package com.pooja.demoApp;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoAppApplication.class, args);

        Dev obj = context.getBean(Dev.class);
        obj.build();
    }
}
```

