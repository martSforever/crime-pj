package com.yzx.crimepj.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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


    @PostMapping("login")
    public Map<String, Object> login(@RequestBody Person person) {
        Map<String, Object> ret = new HashMap<>();
        try {
            Person queryPerson = personDao.findByUserNameAndPassword(person.getUserName(), person.getPassword());
            ret.put("success", queryPerson != null);
            ret.put("result", queryPerson);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
            ret.put("result", null);
        }
        return ret;
    }
}
