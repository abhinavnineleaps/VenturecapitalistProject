package com.platform.VentureCapitalist.service;

import com.platform.VentureCapitalist.model.User;

import java.util.List;

public interface SearchServiceInterface {
    List<User> searchUser(String query);

//    User createUser(User user);
}
