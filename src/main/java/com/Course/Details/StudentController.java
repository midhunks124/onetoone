package com.Course.Details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by midhun on 15/12/16.
 */
@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentRepo repo;
    @Autowired
    private CourseRepo crepo;

    @RequestMapping(value = "/EnterStudent",method = RequestMethod.POST)
    public String studentDetails(Student student, @RequestParam("courseid") Long id)
    {
        Courses courses=crepo.findById(id);
        student.setCourses(courses);

        repo.save(student);


        return "helo";
    }



    @RequestMapping(value = "/EnterStudent",method = RequestMethod.GET)
    public  String addCourse(Student student,Model model)
    {
//        Courses courses=new Courses();
//        courses.setName("BCA");
//        courses.setDescription("Lots of description");
//        courses.setDuration("1 year");
//        courses.setStart_date("10/11/1992");
//        crepo.save(courses);
//        Student students=new Student();
//        students.setName("midhun");
//        students.setAge(10);
//        students.setPlace("ckst");
//        students.setCourses(courses);
//
//        repo.save(students);
//
//        model.addAttribute("alertSucess","Success");
//        return "homepage";
        List<Courses> list=crepo.findAll();
        for (Courses courses:list)
            System.out.println(courses);
        model.addAttribute("coursedetails",list);
        return "enterStudentDetails";
    }

    @RequestMapping(value = "/viewDetails",method = RequestMethod.GET)
    public  String viewStudent(Model model)
    {
        List<Student> list=repo.findAll();
//        List<Courses> list=crepo.findByDuration("1 year");
        for (Student student:list)
        System.out.println(student);

        model.addAttribute("listStudent",list);
        return "Detialsview";
    }
}