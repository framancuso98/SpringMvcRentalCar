package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.security.dao.UserDAO;
import com.spring.security.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService{
  @Autowired
  UserService userService;
  
  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userService.findUserByName(name);
      UserBuilder builder = null;
      if (user != null) {
        
        builder = org.springframework.security.core.userdetails.User.withUsername(name);
        //builder.disabled(!user.isEnabled());
        builder.password(user.getPassword());
        String authorities = user.getAuthority().getAuthority();
        builder.authorities(authorities);
      } else {
        throw new UsernameNotFoundException("User not found.");
      }
      return builder.build();
  }
}