/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pujan
 */
public class displayCourses {

    String course_id, title, instructor_info, class_time, status;

    public displayCourses(String course_id, String title, String instructor_info, String class_time, String status) {
        this.course_id = course_id;
        this.title = title;
        this.instructor_info = instructor_info;
        this.class_time = class_time;
        this.status = status;
    }

    displayCourses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor_info() {
        return instructor_info;
    }

    public void setInstructor_info(String instructor_info) {
        this.instructor_info = instructor_info;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
