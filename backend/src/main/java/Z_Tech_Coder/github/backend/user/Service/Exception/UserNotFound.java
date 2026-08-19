package Z_Tech_Coder.github.backend.user.Service.Exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
        System.out.println("UserNotFound exception fired: " + message);
    }
}
