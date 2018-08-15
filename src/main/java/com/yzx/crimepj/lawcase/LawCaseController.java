package com.yzx.crimepj.lawcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lawCase")
public class LawCaseController {

    @Autowired
    LawCaseDao lawCaseDao;

    @PostMapping("queryAll")
    public List<LawCase> queryAll() {
        return lawCaseDao.findAll();
    }

    @PostMapping("upsert")
    public LawCase queryAll(@RequestBody LawCase lawCase) {
        return lawCaseDao.save(lawCase);
    }

    @PostMapping("delete")
    public Boolean delete(@RequestBody LawCase lawCase) {
        try {
            lawCaseDao.delete(lawCase);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
