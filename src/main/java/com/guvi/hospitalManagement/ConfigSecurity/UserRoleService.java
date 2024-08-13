package com.guvi.hospitalManagement.ConfigSecurity;

import com.guvi.hospitalManagement.Entity.User;
import com.guvi.hospitalManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserRoleService implements UserDetailsService {

    //injecting the repo layer
    @Autowired
    private UserRepository repository;
    //use this method to load the user details
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findByemail(username);
        return userInfo.map(UserRole::new)
                .orElseThrow(()->new UsernameNotFoundException("user not available " + username));
    }
}
