package Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Service;

import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Models.User;
import Crud_SpringBoot_JPA_MSQL.Crud_SpringBoot_JPA_MSQL.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long Id){
        return userRepository.findById(Id);
    }

    public User createdUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> updatedUser(Long Id, User userDetails){

        return userRepository.findById(Id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setEmail(userDetails.getEmail());
                    return userRepository.save(user);
                });
    }

    public boolean deletedUser(Long Id){
        return userRepository.findById(Id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                }).orElse(false);
    }
}
