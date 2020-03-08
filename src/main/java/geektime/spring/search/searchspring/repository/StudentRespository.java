package geektime.spring.search.searchspring.repository;

import geektime.spring.search.searchspring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * StudentRespository
 *
 * @author <a href="mailto:kgzheng@coremail.cn">kgzheng</a>
 * @Description:
 * @since unknown, 2020-03-01
 */
public interface StudentRespository extends JpaRepository<Student, Integer>{
    List<Student> findAllByName(String name);
}
