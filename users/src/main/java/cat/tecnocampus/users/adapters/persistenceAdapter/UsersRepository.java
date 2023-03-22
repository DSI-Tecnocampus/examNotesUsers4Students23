package cat.tecnocampus.users.adapters.persistenceAdapter;

import cat.tecnocampus.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<UserEntity, String> {

    @Query("""
        select new cat.tecnocampus.users.domain.User(
            u.username, u.name, u.secondName, u.email)
        from user_lab u
    """)
    List<User> findAllUsers();

    @Query("""
        select new cat.tecnocampus.users.domain.User(
            u.username, u.name, u.secondName, u.email)
        from user_lab u
        where u.username = :userName
    """)
    User findUserByUsername(@Param("userName") String userName);
}
