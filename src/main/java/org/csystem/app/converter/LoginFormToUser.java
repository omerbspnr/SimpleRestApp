package org.csystem.app.converter;

import org.csystem.app.dtos.LoginForm;
import org.csystem.app.entity.User;
import org.springframework.core.convert.converter.Converter;

public class LoginFormToUser implements Converter<LoginForm, User> {
    @Override
    public User convert(LoginForm loginForm)
    {
        return new User("",loginForm.getUsername(),loginForm.getPassword());
    }
}
