package com.guvi.hospitalManagement.Service;

import com.guvi.hospitalManagement.Entity.User;

public interface UserService {

    public User saveUser(User user);

    public void removeSessionMessage();
}
