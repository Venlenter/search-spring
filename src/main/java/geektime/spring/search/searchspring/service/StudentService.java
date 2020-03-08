package geektime.spring.search.searchspring.service;

import geektime.spring.search.searchspring.model.Student;
import geektime.spring.search.searchspring.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * StudentService
 *
 * @author <a href="mailto:kgzheng@coremail.cn">kgzheng</a>
 * @Description:
 * @since unknown, 2020-03-01
 */
@Service
public class StudentService {
    @Autowired
    private StudentRespository studentRespository;
    @Transactional
    public Student addStudent(Student stu) {
        Student resultStu = studentRespository.save(stu);
        return resultStu;
    }

    public List<Student> listStudents() {
        List<Student> students = studentRespository.findAll();
        return students;
    }

    public Student getStudent(Integer id) {
        Student student = studentRespository.findById(id).orElse(null);
        return student;
    }

    public List<Student> getStudentByName(String name) {
        List<Student> students = studentRespository.findAllByName(name);
        return students;
    }

    public Student updateStudent(Student student) {
        Student newStu = studentRespository.save(student);
        return newStu;
    }

    public void deleteStudent(Integer id) {
        studentRespository.deleteById(id);
    }
}
