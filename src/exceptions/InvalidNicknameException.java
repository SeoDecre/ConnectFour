package exceptions;

public class InvalidNicknameException extends Exception {
    public InvalidNicknameException(String nickname) {
        super("'" + nickname + "' is invalid");
    }
}
