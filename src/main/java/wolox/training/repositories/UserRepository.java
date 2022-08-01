package wolox.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wolox.training.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    /**
     * this method obtain a user by your name
     * @param name : Name of user (String)
     *
     */
    User getUsersByName(String name);
}
