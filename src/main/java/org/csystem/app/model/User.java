package org.csystem.app.model;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int m_id;

    @Column(name = "user_email",nullable = false, unique = true)
    private String m_userEmail;

    @Column(name = "user_email",nullable = false, unique = true)
    private String m_username;

    @Column(name = "user_password", nullable = false)
    private String m_password;

    public int getId()
    {
        return m_id;
    }

    public String getUserEmail()
    {
        return m_userEmail;
    }

    public String getUsername()
    {
        return m_username;
    }

    public String getPassword()
    {
        return m_password;
    }

    public void setUserEmail(String userEmail)
    {
        m_userEmail = userEmail;
    }

    public void setUsername(String username)
    {
        m_username = username;
    }

    public void setPassword(String password)
    {
        m_password = password;
    }
}
