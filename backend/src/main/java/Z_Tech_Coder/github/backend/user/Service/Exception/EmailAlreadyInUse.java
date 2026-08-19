package Z_Tech_Coder.github.backend.user.Service.Exception;

public class EmailAlreadyInUse extends RuntimeException {
    public EmailAlreadyInUse(String message) {
        System.out.println("Email Already In Use Exception Fired");
        super(message);
    }
}
