package org.csystem.app.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginForm {

    @NotBlank
    @Length(max = 16)
    private String m_username;

    @NotBlank
    @Length(min = 8)
    private String m_password;


    public LoginForm(String username, String password)
    {
        m_username = username;
        m_password = password;
    }


    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }


    public String getPassword()
    {
        return m_password;
    }

    public void setPassword(String password)
    {
        m_password = password;
    }
}
