package com.ring.service;

import com.ring.persistence.repository.UserRepository;
import com.ring.security.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.ring.persistence.model.User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return new AuthorizedUser(user.getUserId(), user.getUsername(), user.getPassword(),
                user.getEnabled(), asList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        }));
    }


}
