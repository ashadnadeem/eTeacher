/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceregister;

import static java.awt.Toolkit.getDefaultToolkit;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
/**
 *
 * @author Ashad Nadeem
 */
public class ExcelWrite {
    
    private Workbook wb;
    
    LocalDate now;
    DateTimeFormatter dtf;
    private Label label;
    private int newColumnMark, newRowMark, sheetNo;
    private String fileName,sheetName;
    
    public ExcelWrite(String file, String sheet, int sheetNo) throws IOException, WriteException, BiffException{
        try {
            this.fileName = file;
            this.sheetName = sheet;
            this.sheetNo = sheetNo;
            
            wb = Workbook.getWorkbook(new File(fileName));
            calculateNewFields();
            
        }catch (FileNotFoundException ex) {
            //Creating New Sheet Cause It doesn't Exist
            System.err.println("File Not Found");
            fileNotFound();
        }
    }
    public void calculateNewFields(){
        Sheet sheet = wb.getSheet(this.sheetNo);
        this.newColumnMark = sheet.getColumns();
        this.newRowMark = sheet.getRows();
        System.out.println("Total columns in the sheet "+this.sheetName + " :" + this.newColumnMark);
        System.out.println("Total Rows in the sheet "+this.sheetName + " :" +this.newRowMark);
    }
    
    public void addDate(WritableWorkbook copy, WritableSheet copySheet) throws WriteException, IOException{
        
        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        now = LocalDate.now();
        System.out.println(dtf.format(now));
        label = new Label(newColumnMark, (0), dtf.format(now));
        copySheet.addCell(label);
    }
    public void writeRow(String[] Data){
        try{
            WritableWorkbook copy = Workbook.createWorkbook(new File(this.fileName),wb);
            WritableSheet copySheet = copy.getSheet(this.sheetNo);
            Number num;
            for(int i=0;i<Data.length;i++){
                try{
                    num = new Number(i, newRowMark, Double.parseDouble(Data[i]));
                    copySheet.addCell(num);
                }catch(NumberFormatException e){
                    this.label = new Label(i, newRowMark, Data[i]);
                    copySheet.addCell(label);
                }
            }            
            System.out.println("Entry Added Successfully " +this.sheetName);
            copy.write();
            System.out.println("Closing Sheet " + this.sheetName);
            copy.close();
        }catch(Exception e){}
    }
    
    void writeRow(String[] Data, int rowNum) {
        //To edit the Existing row
        try{
            WritableWorkbook copy = Workbook.createWorkbook(new File(this.fileName),wb);
            WritableSheet copySheet = copy.getSheet(this.sheetNo);
            Number num;
            for(int i=0;i<Data.length;i++){
                try{
                    num = new Number(i, rowNum, Double.parseDouble(Data[i]));
                    copySheet.addCell(num);
                }catch(NumberFormatException e){
                    this.label = new Label(i, rowNum, Data[i]);
                    copySheet.addCell(label);
                }
            }            
            System.out.println("Entry Added Successfully " +this.sheetName);
            copy.write();
            System.out.println("Closing Sheet " + this.sheetName);
            copy.close();
        }catch(Exception e){}
    }
    public void writeAttendance(String[] Data) throws IOException, WriteException {
        try{
            WritableWorkbook copy = Workbook.createWorkbook(new File(fileName),wb);
            WritableSheet copySheet = copy.getSheet(sheetNo);
            
            addDate(copy, copySheet);
            
            for(int i=0;i<Data.length;i++){
                label = new Label(newColumnMark, (i+1), Data[i]);
                copySheet.addCell(label);
            }            
            System.out.println("Entry Added Successfully " +this.sheetName);
            copy.write();
            copy.close();
            System.out.println("Closing Sheet " + this.sheetName);
        }catch(Exception e){}
    }
    public void writeMarks(String[] Data){
        try{
            WritableWorkbook copy = Workbook.createWorkbook(new File(fileName),wb);
            WritableSheet copySheet = copy.getSheet(sheetNo);
            
            addDate(copy, copySheet);                     //Adding Test Name
            
            Number num;
            label = new Label(newColumnMark, (1), Data[0]);
            copySheet.addCell(label);
            System.out.println(Data.length);
            for(int i=1;i<Data.length;i++){
                try{
                    num = new Number(newColumnMark, (i+1), Double.parseDouble(Data[i]));
                    copySheet.addCell(num);
                }catch(NumberFormatException x){}
            }            
            System.out.println("Entry Added Successfully " +this.sheetName);
            copy.write();
            copy.close();
            System.out.println("Closing Sheet " + this.sheetName);
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }

    private void fileNotFound() throws IOException, WriteException {
        WritableWorkbook wb = Workbook.createWorkbook(new File("Student.xls"));
        
        WritableSheet firstSheet = wb.createSheet("Attendance", 0);
        firstSheet.addCell(new Label(0, 0, "Name"));
        
        WritableSheet secondSheet = wb.createSheet("StudentData", 1);
        //Writing header Row
        String [] header = {"Name","StdID","Gender","DOB","Age","Email"};
        for(int i=0;i<header.length;i++)
            secondSheet.addCell(new Label(i, 0, header[i]));
        
        WritableSheet thirdSheet = wb.createSheet("MarkSheet", 2);
        thirdSheet.addCell(new Label(0, 0, "Date"));
        thirdSheet.addCell(new Label(0, 1, "Name"));
        thirdSheet.addCell(new Label(0, 2, "MaxMarks"));
        
        wb.write();
        wb.close();
    }

    
    
}
