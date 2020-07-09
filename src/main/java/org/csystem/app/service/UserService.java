package org.csystem.app.service;

import org.csystem.app.entity.User;
import org.csystem.app.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UserService implements IUserService {
    private IUserRepository m_userRepository;

    public UserService(IUserRepository userRepository)
    {
        m_userRepository = userRepository;
    }

    @Override
    public User save(User u)
    {
        return m_userRepository.save(u);
    }
    @Override
    public Optional<User> controlForLogin(User u)
    {
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
