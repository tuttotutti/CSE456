package vn.edu.eiu.cse456.fecse456studentiddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.fecse456studentiddemo.model.User;
import vn.edu.eiu.cse456.fecse456studentiddemo.repo.UserRepo;

@Service
public class UserService {
    //Inject Repo
    @Autowired
    private UserRepo userRepo;

    //method saving the user
    public void save(User user) {
        userRepo.save(user);
    }

    //method logging
    public User findByUsername(String username) {
        return userRepo.searchUserByUsernameIgnoreCase(username);
    }

}
