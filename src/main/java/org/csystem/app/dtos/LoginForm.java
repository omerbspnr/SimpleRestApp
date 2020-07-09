package org.csystem.app.dtos;

public class LoginForm {
    private String m_username;
    private String m_password;

    public LoginForm()
    {
    }

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

    public String toString()
    {
        return String.format("%s %s", m_username, m_password);
    }
}
