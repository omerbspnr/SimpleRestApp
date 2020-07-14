package org.csystem.app.dtos;

public class LoginResult {
    private String m_email;
    private String m_username;

    public LoginResult(String email, String username)
    {
        m_email = email;
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

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }
}
