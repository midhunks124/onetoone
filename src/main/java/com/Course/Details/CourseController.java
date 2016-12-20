package com.Course.Details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.StreamTokenizer;
import java.util.List;

/**
 * Created by midhun on 15/12/16.
 */
@Controller
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CourseRepo repo;

    @RequestMapping("/index")
    public String homepage()
    {
        return "Homepage";
    }

    @RequestMapping("/coursedetails")
    public String listCourses(Model model)
    {
        List<Courses> list= repo.findAll();
        if(list!=null)
        {
            model.addAttribute("courses",list);
        }
        return "ListCourses";
    }
    @RequestMapping("/newCourse")
    public  String newCourse()
    {

        return "createCourse";
    }
    @RequestMapping(value = "/newCourse",method = RequestMethod.POST)
    public  String addCourse(Courses courses,Model model)
    {
        repo.save(courses);
        model.addAttribute("alertSucess","Success");
        return "Homepage";
    }
    @RequestMapping(value="/coursedetails/{courseid}")
    public String fullcoursedetails(@PathVariable("courseid") String courseid, Model model)
    {
        Courses courses=repo.findById(Long.parseLong(courseid));
        model.addAttribute("courselist",courses);
        return "fullcoursedetails";
    }



}
