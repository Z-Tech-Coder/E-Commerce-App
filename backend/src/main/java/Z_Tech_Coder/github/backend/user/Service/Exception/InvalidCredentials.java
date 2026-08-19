package Z_Tech_Coder.github.backend.user.Service.Exception;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String message) {
        System.out.println("Invalid credentials Exception Fired");
        super(message);
    }
}
