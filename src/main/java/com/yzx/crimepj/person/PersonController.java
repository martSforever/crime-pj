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
    public Map<String, Object> queryAll() {
        Map<String, Object> ret = new HashMap<>();
        try {
            ret.put("result", personDao.findAll());
            ret.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
            ret.put("message", e.getMessage());
        }
        return ret;
    }

    @PostMapping("upsert")
    public Map<String, Object> upsert(@RequestBody Person person) {
        Map<String, Object> ret = new HashMap<>();
        try {
            ret.put("result", personDao.save(person));
            ret.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
            ret.put("message", e.getMessage());
        }
        return ret;
    }

    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Person person) {
        Map<String, Object> ret = new HashMap<>();
        try {
            personDao.delete(person);
            ret.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
        }
        return ret;
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

    @PostMapping("register")
    public Map<String, Object> register(@RequestBody Person person) {
        Map<String, Object> ret = new HashMap<>();
        try {
            Person userNamePerson = personDao.findByUserName(person.getUserName());
            if (userNamePerson != null) {
                ret.put("success", false);
                ret.put("message", "username has been used!");
            } else {
                Person savePerson = personDao.save(person);
                ret.put("success", savePerson != null);
                ret.put("result", savePerson);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
            ret.put("message", e.getMessage());
            ret.put("result", null);
        }
        return ret;
    }
}
