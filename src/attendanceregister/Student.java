/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceregister;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author Ashad Nadeem
 */
public class Student {
   private String Name, email;
   private char gender;
   private int ID, Age, present;
   private LocalDate DOB;
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Student(String Name, String email, int ID, char gender, LocalDate DOB) throws IOException, WriteException{
       try {
           this.Name = Name;
           this.email = email;
           this.ID = ID;
           this.gender = gender;
           this.DOB = DOB;
           this.Age = calculateAge(DOB);
           this.present = getHisAttendance(this.Name);
           
           
       } catch (Exception ex) {
       }
    }

    public int getPresent() {
        return present;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return Age;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
    public void addStd() throws IOException, WriteException, BiffException{
        String [] data = new String[6];
        data[0] = this.Name;
        data[1] = this.ID + "";
        data[2] = this.gender + "";
        data[3] = this.DOB.toString();
        data[4] = this.Age + "";
        data[5] = this.email;
        
        ExcelWrite write = new ExcelWrite("Student.xls","StudentData",1);
        write.writeRow(data);
        
        
        ExcelWrite register = new ExcelWrite("Student.xls","Attendance",0);
        String[] row = new String[1];
        row[0] = this.getName();
        register.writeRow(row);
        
        ExcelWrite marksheet = new ExcelWrite("Student.xls","MarkSheet",2);
        String []arr = {"Name"};
        marksheet.writeRow(arr);
        
    }

    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    private int getHisAttendance(String Name) throws IOException, BiffException {
        return  new ExcelRead("Student.xls","Attendance").cntPresent(Name);
    }
   
}
