package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.model.EntrepreneurDetails;
import com.platform.VentureCapitalist.model.StartupDetails;
import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.model.UserAttribute;
import com.platform.VentureCapitalist.repository.UserAttributeRepo;
import com.platform.VentureCapitalist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAttributeRepo userAttributeRepo;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

//    public UserAttribute addUserId(UserAttribute userAttribute) {
//        User user = userRepository.findById(userAttribute.getUser().getUniqueId()).get();
//        userAttribute.setUser(user);
//        return userAttributeRepo.save(userAttribute);
//    }

}
