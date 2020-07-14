package org.csystem.app.dtos;


public class RegistrationForm {
    private String m_username;

    private String m_email;

    private String m_password;

    public RegistrationForm()
    {

    }
    public RegistrationForm(String username, String password)
    {
    }
    public RegistrationForm(String username, String email, String password)
    {
        m_username = username;
        m_email = email;
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

    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        m_email = email;
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
