package org.example.repo_exercise.Service;

import lombok.AllArgsConstructor;
import org.example.repo_exercise.API.ApiException;
import org.example.repo_exercise.Model.User;
import org.example.repo_exercise.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id,User user){
        User u=userRepository.findUserById(id);
        if (u==null){
            throw new ApiException("not found id");
        }
        u.setAge(user.getAge());
        u.setUserName(user.getUserName());
        u.setEmail(user.getEmail());
        u.setAge(user.getAge());
        u.setRole(user.getRole());
        u.setPassword(user.getPassword());
        userRepository.save(u);
    }
    public void deleteUser(Integer id){
        User u=userRepository.findUserById(id);
        if (u==null){
            throw new ApiException("not found id");
        }
        userRepository.delete(u);
    }

    public User searchByEmail(String email){
        User u=userRepository.findUsersByEmail(email);
        if (u==null){
            throw new ApiException("not found email");
        }
        return u;
    }


    public List<User> searchRole(String role){
        List<User> list_role=userRepository.findUsersByRole(role);
        if (list_role.isEmpty()){
            throw new ApiException("not found");
        }

        return list_role;

    }
    public List<User> searchAge(Integer age1){
        List<User> list_age=userRepository.checkAge(age1);
        if (list_age.isEmpty()){
            throw new ApiException("not found");
        }
        return list_age;
    }

    public User checkPasswordUsername(String user_name,String pass){
        User u=userRepository.checkUserNamePass(user_name,pass);
        if (u==null){
            throw new ApiException("Not found ");
        }
        return u;
    }
}
