package com.huseyinaydin.sha.springbootmicroservice3gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huseyinaydin.sha.springbootmicroservice3gateway.model.User;
import com.huseyinaydin.sha.springbootmicroservice3gateway.service.IUserService;

/**
 * @author Hüseyin Aydın
 * @date 18.04.2021
 * @time 12:18
 */
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findBUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username:" + username));

        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword());
    }
}
