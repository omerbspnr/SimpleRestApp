package org.csystem.app.repository;

import org.csystem.app.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User,Integer> {
}
