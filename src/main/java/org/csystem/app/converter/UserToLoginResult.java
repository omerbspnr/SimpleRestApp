package org.csystem.app.converter;

import org.csystem.app.dtos.LoginResult;
import org.csystem.app.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserToLoginResult implements Converter<User, LoginResult> {
    @Override
    public LoginResult convert(User user)
    {
        return new LoginResult(user.getUserEmail(),user.getUsername());
    }
}
