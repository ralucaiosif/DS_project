package com.example.easynotes.repositories;

import com.example.easynotes.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findById(int id);

    void delete(User user);


}
