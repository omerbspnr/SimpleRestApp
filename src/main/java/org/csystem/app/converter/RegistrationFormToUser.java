package org.csystem.app.converter;

import org.csystem.app.dtos.RegistrationForm;
import org.csystem.app.entity.User;
import org.springframework.core.convert.converter.Converter;

public class RegistrationFormToUser implements Converter<RegistrationForm, User> {

    @Override
    public User convert(RegistrationForm registrationForm)
    {
        return new User(registrationForm.getEmail(), registrationForm.getUsername(), registrationForm.getPassword());
    }
}
