package geektime.spring.search.searchspring.controller;

import geektime.spring.search.searchspring.model.Student;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * StudentControllerTest
 *
 * @author <a href="mailto:kgzheng@coremail.cn">kgzheng</a>
 * @Description:
 * @since unknown, 2020-03-03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void addStu() throws Exception {
        Student stu = new Student();
        stu.setBan("11");
        stu.setGrade("22");
        stu.setMajor("33");
        stu.setName("44");
        stu.setSex("55");
        stu.setSno("66");
        mvc.perform(MockMvcRequestBuilders.post("/stu/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(stu))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}