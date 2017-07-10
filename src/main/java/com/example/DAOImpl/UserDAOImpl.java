package com.example.DAOImpl;

import com.example.DAOService.UserDAO;
import com.example.data.UserDetail;
import com.example.data.UserRoles;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl implements UserDAO {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    

    public UserDetail findUserByEmail(String email) {
        return userRepository.findByEmailAddress(email);
    }

    public void saveUser(UserDetail user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        UserRoles userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<UserRoles>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}
