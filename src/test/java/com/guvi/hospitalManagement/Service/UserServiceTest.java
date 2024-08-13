package com.guvi.hospitalManagement.Service;


import com.guvi.hospitalManagement.Entity.User;
import com.guvi.hospitalManagement.Exception.UserAlreadyExistsException;
import com.guvi.hospitalManagement.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepo;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImp userService;

    @Test
    public void testSaveUser_UserAlreadyExists() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepo.findByemail(user.getEmail())).thenReturn(Optional.of(user));

        assertThrows(UserAlreadyExistsException.class, () -> userService.saveUser(user));
    }

    @Test
    public void testSaveUser_Success() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userRepo.findByemail(user.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");

        User savedUser = new User();
        savedUser.setEmail("test@example.com");
        savedUser.setPassword("encodedPassword");
        savedUser.setRoles("USER");

        when(userRepo.save(any(User.class))).thenReturn(savedUser);

        User result = userService.saveUser(user);

        assertEquals("encodedPassword", result.getPassword());
        assertEquals("USER", result.getRoles());
    }
}
