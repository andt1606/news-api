package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.security.services.UserDetailsImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {

    public static UserDetailsImpl getPrincipal() {
        return (UserDetailsImpl) (SecurityContextHolder
                .getContext()).getAuthentication().getPrincipal();
    }
}
