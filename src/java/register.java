
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pujan
 */
@ManagedBean
@RequestScoped
public class register {

    private String course_id, title, instructor_info, class_time, status;
    private int class_capacity, num_of_students;

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

    public int getClass_capacity() {
        return class_capacity;
    }

    public void setClass_capacity(int class_capacity) {
        this.class_capacity = class_capacity;
    }

    public int getNum_of_students() {
        return num_of_students;
    }

    public void setNum_of_students(int num_of_students) {
        this.num_of_students = num_of_students;
    }

    public ArrayList<displayCourses> displayOpenCourses() {
        ArrayList<displayCourses> displaycoursedetail = new ArrayList<displayCourses>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            displayerror();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/budhathokip4348";

            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL,
                    "budhathokip4348", "1325487");
            statement = connection.createStatement();

            String SQL = "Select * from courses where status='open'";
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                //save the values in arraylist
                String course_id1 = resultSet.getString("course_id");
                String title1 = resultSet.getString("title");
                String instructor_info1 = resultSet.getString("instructor_info");
                String class_time1 = resultSet.getString("class_time");
                String status1 = resultSet.getString("status");
                //create object fro arraylist
                displayCourses obj = new displayCourses();
                displaycoursedetail.add(obj);

            }

        } catch (SQLException e) {
            displayerror();
        } finally {
            try {

                statement.close();
                resultSet.close();
                connection.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return displaycoursedetail;
    }

    public ArrayList<displayCourses> course_id() {
        ArrayList<displayCourses> displaycoursedetail = new ArrayList<displayCourses>();
        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            displayerror();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/budhathokip4348";

            //connect to the database with user name and password
            connection = DriverManager.getConnection(DATABASE_URL,
                    "budhathokip4348", "1325487");
            statement = connection.createStatement();

            String SQL = "Select * from courses where course_id='" + course_id + "'";
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                //save the values in arraylist
                String course_id1 = resultSet.getString("course_id");
                String title1 = resultSet.getString("title");
                String instructor_info1 = resultSet.getString("instructor_info");
                String class_time1 = resultSet.getString("class_time");
                String status1 = resultSet.getString("status");
                //create object fro arraylist
                displayCourses obj = new displayCourses();
                displaycoursedetail.add(obj);
            }

        } catch (SQLException e) {
            displayerror();
        } finally {
            try {

                statement.close();
                resultSet.close();
                connection.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return displaycoursedetail;
    }

    private String displayerror() {
        return "internal error";
    }
}
