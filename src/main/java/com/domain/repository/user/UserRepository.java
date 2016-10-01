package com.domain.repository.user;

import com.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nishina on 2016/10/01.
 */
public interface UserRepository extends JpaRepository<User, String>{
}
