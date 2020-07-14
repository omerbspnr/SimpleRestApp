package org.csystem.app.service;

import org.csystem.app.entity.User;
import org.csystem.app.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UserService implements IUserService {
    private IUserRepository m_userRepository;

    private PasswordEncoder m_encoder;

    public UserService(IUserRepository userRepository, PasswordEncoder encoder)
    {
        m_userRepository = userRepository;
        m_encoder = encoder;
    }

    @Override
    public User save(User u)
    {
        u.setPassword(m_encoder.encode(u.getPassword()));
        System.out.printf("Kayıt sifresi : %s%n", u.getPassword());
        return m_userRepository.save(u);
    }
    @Override
    public Optional<User> controlForLogin(User u)
    {
        u.setPassword(m_encoder.encode(u.getPassword()));
        System.out.printf("Giris sifresi : %s%n",u.getPassword());
        return StreamSupport
                .stream(m_userRepository.findAll().spliterator(),false)
                .filter(i -> i.getPassword().equals(u.getPassword()) && i.getUsername().equals(u.getUsername()))
                .findFirst();
    }

    @Override
    public boolean isUserExist(User u)
    {

        return  StreamSupport
            .stream(m_userRepository.findAll().spliterator(),false)
            .anyMatch(i -> i.getUserEmail().equals(u.getUserEmail()) || i.getUsername().equals(u.getUsername()));

    }
}
