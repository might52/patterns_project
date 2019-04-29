package entity.Impl.Command;

public class UnregisteredCommandException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Command is not found at Command Manager";
    }

}
