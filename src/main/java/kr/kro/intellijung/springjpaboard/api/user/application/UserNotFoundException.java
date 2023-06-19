package kr.kro.intellijung.springjpaboard.api.user.application;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
