/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceregister;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;


/**
 *
 * @author Ashad Nadeem
 */
public class AttendanceRegister {

    
    public static void main(String[] args) throws IOException, WriteException, BiffException {
        // TODO code application logic here
        ExcelWrite test = new ExcelWrite("Student.xls","StudentData",1);
        
        MainGUI a = new MainGUI();
    }
    
}
