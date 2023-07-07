package kr.kro.intellijung.board.user.application;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
