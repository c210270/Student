package ccmc.ac.jp.student.reppository;

import ccmc.ac.jp.student.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Long> {

    @Query(value = "select user_name,name,age,grade from user where user_name =:userName", nativeQuery = true)
    List<User> userDetail(@Param("userName") String userName);

    Optional<User> findByUserName(String userName);

    User deleteUserByUserName(String userName);


}
