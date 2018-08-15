package com.yzx.crimepj.user;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentService studentService;

    @GetMapping("list")
    public List<Student> list() {
        return studentDao.findAll();
    }

    @PostMapping("upsert")
    public Student upsert(@RequestBody Student student) {
        return studentDao.save(student);
    }

    @PostMapping("delete")
    public Boolean delete(@RequestBody Student student) {
        try {
            studentDao.delete(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @PostMapping("get")
    public Student get(@RequestBody Student student) {
        return studentDao.getOne(student.getId());
    }

    @PostMapping("findByAge")
    public List<Student> findByAge(@RequestBody Student student) {
        return studentDao.findByAge(student.getAge());
    }

    @PostMapping("multiUpsert")
    public List<Student> multiUpsert(@RequestBody List<Student> students) {
        try {
            return studentService.multiUpsert(students);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
