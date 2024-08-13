package com.guvi.hospitalManagement.Service;

import com.guvi.hospitalManagement.Entity.User;
import com.guvi.hospitalManagement.Exception.UserAlreadyExistsException;
import com.guvi.hospitalManagement.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepo;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        // Check if a user with the same email already exists
        Optional<User> existingUser = userRepo.findByemail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("EmailId  already registered");
        }
        String password=passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setRoles("USER");
        User newuser = userRepo.save(user);

        return newuser;

    }


    @Override
    public void removeSessionMessage() {
        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
                .getSession();

        session.removeAttribute("msg");
    }

}



