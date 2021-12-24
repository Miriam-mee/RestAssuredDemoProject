package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.College;
import model.Course;
import model.Department;
import model.Student;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class JavaToJsonConverterUtil {
    Student s1, s2, s3;
    Department d1, d2, d3;
    Course c1, c2, c3;

    @Test
    public void test() throws JsonProcessingException {
    c1 = Course.builder().CourseId(1).courseName("Science").build();
    c2= Course.builder().CourseId(2).courseName("Arts").build();
    c3= Course.builder().CourseId(3).courseName("Automation Testing").build();
    List<Course> clist1 = Arrays.asList(c1, c2, c3);
    List<Course> clist2 = Arrays.asList(c1, c2);
    List<Course> clist3 = Arrays.asList(c1, c3);
        s1= Student.builder().courseList(clist1).name("Miriam").address("Nigeria").rollNumber(101).build();
        s2= Student.builder().courseList(clist2).name("Yoti").address("US").rollNumber(102).build();
        s3= Student.builder().courseList(clist3).name("Kundan").address("London").rollNumber(103).build();
        List<Student> studentList1= Arrays.asList(s1,s2,s3);
        List<Student> studentList2= Arrays.asList(s1,s3);
        List<Student> studentList3= Arrays.asList(s1,s2);
        d1= Department.builder().departmentName("Computer Science").studentList(studentList1).build();
        d2= Department.builder().departmentName("Cyber Security").studentList(studentList2).build();
        d3= Department.builder().departmentName("IT").studentList(studentList3).build();
        List<Department> d = Arrays.asList(d1, d2, d3);
        College c = College.builder().collegeName("MIT").departmentList(d).build();
        ObjectMapper mapper = new ObjectMapper();
        String s4 = mapper.writeValueAsString(c);
        System.out.println(s4);
        c.setDepartmentList(d);

    }

  /*  @Test
    public void test2(){
        c1 = Course.builder().CourseId(1).courseName("Accounts").build();
        c2= Course.builder().CourseId(2).courseName("IT").build();
        c3= Course.builder().CourseId(3).courseName("").build();
        List<Course> clist1 = Arrays.asList(c1, c2, c3);
        List<Course> clist2 = Arrays.asList(c1, c2);
        List<Course> clist3 = Arrays.asList(c1, c3);
        Department dep1 = Department.builder().departmentName("Arts").build();
        Department dep2 = Department.builder().departmentName("Computer").build();
        Department dep3 = Department.builder().departmentName("Eng").build();
        List<Department> dep = Arrays.asList(dep1, dep2, dep3);
        College c = College.builder().collegeName("Greenwich").departmentList(dep).build();
    }*/
}