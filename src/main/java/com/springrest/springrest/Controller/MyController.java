package com.springrest.springrest.Controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.sevices.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
 private CourseService courseService;

    public MyController(CourseService courseService) {
        this.courseService = courseService;
    }

    //get the courses

   // @GetMapping("/courses")
    @RequestMapping(path="/courses",method = RequestMethod.GET)
    public List<Course> getCourses()
    {
        return courseService.getCourses();
    }

    // getting single course only
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return courseService.getCourse(Long.parseLong(courseId));
    }

    // adding course here
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus>deleteCourse(@PathVariable String courseId)
    {
        try{
            courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
