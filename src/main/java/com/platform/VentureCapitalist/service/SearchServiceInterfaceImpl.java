package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.model.User;
import com.platform.VentureCapitalist.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchServiceInterfaceImpl implements SearchServiceInterface {

    private UserRepository userRepository;
    public SearchServiceInterfaceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> searchUser(String query) {
        List<User> user = userRepository.searchUser(query);
        return user;
    }

}
