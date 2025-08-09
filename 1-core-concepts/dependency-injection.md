# 📘 Spring Framework Notes – Dependency Injection (V.IMP)

---

### ❓ Q1. What is Dependency Injection (DI)?

> A **dependency** is just another object that your class needs to work with.  
**Dependency Injection (DI)** means:  
> Instead of a class creating its own dependencies, **someone else** (Spring, in our case) creates and provides them.

#### ⚙️ Key Points:
- **Removes tight coupling** between classes
- **Makes code testable** (easy to mock dependencies)
- **Promotes Single Responsibility Principle**

---

### ❓ Q2. What are the types of DI in Spring?

Spring provides **three ways** to inject dependencies:

#### 🧩 Types of DI:
1. **Constructor Injection (✅ Recommended)**  
   - Dependencies provided via class constructor  
   - Immutable (can use `final` fields)  

2. **Setter Injection**  
   - Dependencies set via setter methods  
   - Useful for optional dependencies  

3. **Field Injection (⚠️ Avoid)**  
   - Direct field injection with `@Autowired`  
   - Harder to test  

#### ✅ Example:

// 1. Constructor Injection (✅ Recommended)
```java
@Component
public class Dev {
    private final Laptop laptop;
    
    // Spring automatically injects Laptop instance
    public Dev(Laptop laptop) {
        this.laptop = laptop;
    }

    public void buildProject() {
        laptop.compile();
        System.out.println("Project built successfully!");
    }
}
```

// 2. Setter Injection
```java
@Component
public class Dev {
    private Laptop laptop;
    
    @Autowired
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void buildProject() {
        if (laptop != null) {
            laptop.compile();
        }
    }
}
```

// 3. Field Injection (⚠️ Not Recommended)
```java
@Component
public class Dev {
    @Autowired
    private Laptop laptop;  // Direct field injection

    public void buildProject() {
        laptop.compile();
    }
}
```


```java
// Dependency Class (Common for all examples)
@Component
public class Laptop {
    public void compile() {
        System.out.println("Compiling code...");
        System.out.println("Fixed all bugs!");
    }
}
```
