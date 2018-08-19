package com.yzx.crimepj.lawcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("lawCase")
public class LawCaseController {

    @Autowired
    LawCaseDao lawCaseDao;

    @PostMapping("queryAll")
    public Map<String, Object> queryAll() {
        Map<String, Object> ret = new HashMap<>();
        try {
            ret.put("result", lawCaseDao.findAll());
            ret.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
            ret.put("message", e.getMessage());
        }
        return ret;
    }

    @PostMapping("upsert")
    public Map<String, Object> queryAll(@RequestBody LawCase lawCase) {
        Map<String, Object> ret = new HashMap<>();
        try {
            ret.put("result", lawCaseDao.save(lawCase));
            ret.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
            ret.put("message", e.getMessage());
        }
        return ret;
    }

    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody LawCase lawCase) {
        Map<String, Object> ret = new HashMap<>();
        try {
            lawCaseDao.delete(lawCase);
            ret.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("success", false);
        }
        return ret;
    }
}
