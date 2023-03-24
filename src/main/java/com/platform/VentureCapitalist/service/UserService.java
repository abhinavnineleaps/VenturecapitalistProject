package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)
    {
        return userRepository.save(user);
    }
//    public

}
