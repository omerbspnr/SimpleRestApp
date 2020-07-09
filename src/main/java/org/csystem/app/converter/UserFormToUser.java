package org.csystem.app.converter;

import org.csystem.app.dtos.UserForm;
import org.csystem.app.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserFormToUser implements Converter<UserForm, User> {

    @Override
    public User convert(UserForm userForm)
    {
        return new User(userForm.getEmail(),userForm.getUsername(),userForm.getPassword());
    }
}
