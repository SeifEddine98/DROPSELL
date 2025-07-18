package SERVICE;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestBody;

import DAO.UserRepository;
import ENTITIES.User;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(@RequestBody User user) {

        return userRepository.save(user);
    }
}