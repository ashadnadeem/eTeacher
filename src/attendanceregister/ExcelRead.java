/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceregister;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.*;

/**
 *
 * @author Ashad Nadeem
 */
public class ExcelRead {
    private Workbook wb;
    private Sheet sheet;
    private String fileName,sheetName;
    private int rows,cols;
    
    //i represents row
    //j represents column
    public ExcelRead(String fileName, String  sheetName) throws IOException, BiffException{
        
        this.fileName = fileName;
        this.sheetName = sheetName;
        
        wb = Workbook.getWorkbook(new File(this.fileName));
        sheet = wb.getSheet(sheetName);
        calculateNewRowColMark();
        
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    public void calculateNewRowColMark(){
        this.cols = this.sheet.getColumns();
        this.rows = this.sheet.getRows();
        System.out.println("Total columns in the sheet: " + this.cols);
        System.out.println("Total Rows in the sheet: " + this.rows);
    }
    public void read(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(sheet.getCell(j, i).getContents().toString());
            }
            System.out.println();
        }
    }
    
    public Student[] readStudents() throws IOException, WriteException{
        
        Student[] stds = new Student[this.rows-1];
        String name,email;
        int id;
        LocalDate dob;
        char gen;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Cell[] row;
        for(int i=0;i<rows-1;i++){
            row = this.sheet.getRow(i+1);
            
            //String Name, String email, int ID, char gender, LocalDate DOB
            name = (row[0].getContents());
            id  = ( Integer.parseInt(row[1].getContents().trim()) );
            gen = (row[2].getContents().trim().charAt(0));
            dob = (LocalDate.parse(row[3].getContents().trim(), formatter));
            email = ( row[5].getContents().trim());
            
            stds[i] = new Student(name,email,id,gen,dob);
        }
        return stds;
    }
    public void printRow(int i){
        Cell[] row = sheet.getRow(i);
        for(int j=0;j<row.length;j++)
            System.out.print(row[j].getContents());
    }
    public int cntPresent(String Name){
        int thisRow = 0;
        System.out.println("Searching for :" + Name );
        Cell [] colOfNames = sheet.getColumn(0);
        for(int i=0;i<rows;i++){
            if (colOfNames[i].getContents().toString().trim().equals(Name)){
                thisRow = i;
                System.out.println("Student found on Row# " + i);
                break;
            }
        }
        
        int count = 0;
        for(int i=0;i<cols;i++){
            if(sheet.getCell(i, thisRow).getContents().toString().trim().equals("Present"))
                count++;
        }
        System.out.println(Name + " was present " + count + " times");
        return count;
    }
    public String[] getStudents(){
        Cell [] colOfNames = sheet.getColumn(0);
        String [] names = new String[colOfNames.length-1];
        for(int i=1;i<colOfNames.length;i++){
            names[i-1] = colOfNames[i].getContents().toString().trim();
        }
        return names;
    }
}
