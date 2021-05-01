package com.appsdeveloperblog.app.ws.userservice.impl;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService
{
    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl()
    {

    }

    @Autowired
    public UserServiceImpl(Utils utils)
    {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails)
    {
        UserRest user = new UserRest();
        user.setEmail(userDetails.getEmail());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        user.setUserId(userId);

        if(users == null)
        {
            users = new HashMap<>();

        } users.put(userId, user);

        return user;
    }
}
