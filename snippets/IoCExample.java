// Spring IoC Example
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = ...;
        UserService service = context.getBean(UserService.class);
    }
}
