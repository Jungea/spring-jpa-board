package kr.kro.intellijung.springjpaboard.api.user;

import kr.kro.intellijung.springjpaboard.api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
