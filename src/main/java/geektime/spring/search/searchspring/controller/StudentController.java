package geektime.spring.search.searchspring.controller;

import geektime.spring.search.searchspring.model.Student;
import geektime.spring.search.searchspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * StudentController
 *
 * @author <a href="mailto:kgzheng@coremail.cn">kgzheng</a>
 * @Description:
 * @since unknown, 2020-03-01
 */
@RestController
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public void addStu(@RequestBody Student stu) {
        Student result = studentService.addStudent(stu);
    }

    @GetMapping("/listAll")
    public List<Student> listStudents() {
        List<Student> students = studentService.listStudents();
        return students;
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        Student student = studentService.getStudent(id);
        return student;
    }

    @PostMapping("/getStudent")
    public List<Student> getStudent(@RequestBody String name) {
        List<Student> students = studentService.getStudentByName(name);
        return students;
    }

    @PostMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) throws Exception {
        if (student.getId() == 0) {
            throw new Exception("id not found");
        }
        Student newStu = studentService.updateStudent(student);
        return newStu;
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "S_OK";
    }

}
