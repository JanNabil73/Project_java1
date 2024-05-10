/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.com.mycompany.online_courses_system;


/**
 *
 * @author demia
 */
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
public class Student extends Users implements Comparable<Student> {
private double Final_Grade;
static private int No_of_stud ;
private List<Courses> courses;
private double courseGrade;

    public Student( String name, String email, String college, String department, int age, String gender, String password ) { 
        super(name, email, college, department, age, gender, password);
        No_of_stud++;
        this.courses = new ArrayList<>();
        //this.Final_Grade = Final_Grade;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
        for(Courses c:courses)
        Site.Add_Course(c);
    }

    


//    public double getFinal_Grade() {
////        if(!logedIn ){
////            System.out.println("not loged in");
////            return -1;
////           }
//        for(Courses c:courses){
//        Final_Grade+=this.getCourseGrade(c);
//        try {
//        double finalGrade = Final_Grade/courses.size() ; 
//        return finalGrade;
//        }catch(ArithmeticException e)
//        {
//            e.printStackTrace();
//            return 0;
//        }  
//    }
       //    public double getFinal_Grade() {
////        if(!logedIn ){
////            System.out.println("not loged in");
////            return -1;
////           }
//        for(Courses c:courses){
//        Final_Grade+=this.getCourseGrade(c);
//        try {
//        double finalGrade = Final_Grade/courses.size() ; 
//        return finalGrade;
//        }catch(ArithmeticException e)
//        {
//            e.printStackTrace();
//            return 0;
//        }  
//    } 
        
    public void calcCourseGrade(Courses course) {
        double coursegrade=0;
        for(int i=0;i<course.getTasks().size();i++)
        coursegrade+=course.getTasks().get(i).getGrade();
        try {
         this.setCourseGrade(coursegrade/course.getTasks().size()) ; 
        }catch(ArithmeticException e)
        {
            e.printStackTrace();
        }  
    }

    public double getCourseGrade() {
        return courseGrade;
    }
    

    public void setCourseGrade(double courseGrade) {
        this.courseGrade = courseGrade;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setFinal_Grade(double Final_Grade) {
//        if(!logedIn ){
//            System.out.println("not loged in");
//            return ;
//           }
        this.Final_Grade = Final_Grade;
    }

    public static int getNo_of_stud() {
        return No_of_stud;
    }

    public static void setNo_of_stud(int No_of_stud) {
        Student.No_of_stud = No_of_stud;
    }
    
@Override
    public int compareTo(Student s){
    if(this.Final_Grade>s.Final_Grade)
            return 1;
    else if(this.Final_Grade<s.Final_Grade)
            return -1;
    else 
        return 0;
    
    }
    public void addCourses (Courses course)
    {
//        if(!logedIn ){
//            System.out.println("not loged in");
//            return;
//           }
       this.courses.add(course);
       Site.Add_Course(course);
    }
    public double finalGrade(){
        for(Courses c:this.courses){
            this.Final_Grade+=this.getCourseGrade(c);
        }
        try{
            return this.Final_Grade/this.courses.size();
        }catch(ArithmeticException e){
            e.printStackTrace();
            return 0;
        }
    }
}