package org.example.repo_exercise.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.repo_exercise.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    User findUsersByEmail(String email);
    @Query("select  a from  User a where a.age>=?1   ")
    List<User> checkAge(Integer age1);

    List<User> findUsersByRole(String role);

    @Query("select  u from User u where u.userName=?1 and u.password=?2")
   User checkUserNamePass(String name,String pass);


}
