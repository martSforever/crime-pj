package com.yzx.crimepj.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Integer> {

    Person findByUserNameAndPassword(String username, String password);

    Person findByUserName(String username);
}
