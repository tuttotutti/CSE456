package vn.edu.eiu.cse456.fecse456studentiddemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User searchUserByUsernameIgnoreCase(String username);
    //query to save the user
    //query to search the user for login
}
