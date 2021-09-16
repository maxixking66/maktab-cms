package ir.maktab56.maktabcms.service.impl;

import ir.maktab56.maktabcms.domain.User;
import ir.maktab56.maktabcms.service.AuthenticationProvider;
import ir.maktab56.maktabcms.service.UserService;
import ir.maktab56.maktabcms.util.SecurityContext;

public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UserService userService;

    public AuthenticationProviderImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void authenticate(String username, String password) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                SecurityContext.setCurrentUser(user);
            } else {
                throw new RuntimeException("wrong password!!!");
            }
        } else {
            throw new RuntimeException("not found!!!");
        }
    }
}
