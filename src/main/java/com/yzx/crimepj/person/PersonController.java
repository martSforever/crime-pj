package com.yzx.crimepj.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @PostMapping("queryAll")
    public List<Person> queryAll() {
        return personDao.findAll();
    }

    @PostMapping("upsert")
    public Person upsert(@RequestBody Person person) {
        return personDao.save(person);
    }

    @PostMapping("delete")
    public Boolean delete(@RequestBody Person person) {
        try {
            personDao.delete(person);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
