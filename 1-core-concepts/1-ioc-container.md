# Inversion of Control (IoC)

## Definition
Spring's container that manages Java objects (beans).

## Example
```java
@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
}
```
