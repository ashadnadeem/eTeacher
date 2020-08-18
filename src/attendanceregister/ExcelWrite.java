/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceregister;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
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

    ExcelWrite(String studentxls) throws IOException, BiffException, WriteException {
        try {
            this.fileName = studentxls;
            
            wb = Workbook.getWorkbook(new File(fileName));
            
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
        //Write Attendance as DateCell
        copySheet.addCell(new DateTime(newColumnMark, 0, Date.valueOf(LocalDate.now()), new jxl.write.WritableCellFormat(new DateFormat("dd/MM/yyyy"))));
    }
    void writeRow(Object[] Data, int rowNum) {
        //To edit the Existing row
        try{
            WritableWorkbook copy = Workbook.createWorkbook(new File(this.fileName),wb);
            WritableSheet copySheet = copy.getSheet(this.sheetNo);
            
            //Write Name as string
            copySheet.addCell(new Label(0, rowNum, (String)Data[0]));
            //Write ID as Number
            copySheet.addCell(new Number(1, rowNum, (int)Data[1]));
            //Write Gender as Capital Char from String
            copySheet.addCell(new Label(2, rowNum, (String)Data[2]));
            //Write DOB as DateCell
            copySheet.addCell(new DateTime(3, rowNum, Date.valueOf((LocalDate) Data[3]), new jxl.write.WritableCellFormat(new DateFormat("yyyy-mm-dd"))));
            //Write Age as Number
            copySheet.addCell(new Number(4, rowNum, (int)Data[4]));
            //Write Email as string
            copySheet.addCell(new Label(5, rowNum, (String)Data[5]));
            
            System.out.println("Entry Added Successfully ");
            copy.write();
            System.out.println("Closing Sheet ");
            copy.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }   
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

    public void NewStudent(Object[] Data) {
        try{
            WritableWorkbook copy = Workbook.createWorkbook(new File(this.fileName),wb);
            
            //Attendance Sheet:
            this.sheetName = "Attendance";
            this.sheetNo = 0;
            this.calculateNewFields();
            WritableSheet attendanceSheet = copy.getSheet(this.sheetNo);
            attendanceSheet.addCell(new Label(0, newRowMark, (String)Data[0]));
            
            //Mark Sheet:
            this.sheetName = "MarkSheet";
            this.sheetNo = 2;
            this.calculateNewFields();
            WritableSheet markSheet = copy.getSheet(this.sheetNo);
            markSheet.addCell(new Label(0, newRowMark, (String)Data[0]));
            
            //Personal Data Sheet:
            this.sheetName = "StudentData";
            this.sheetNo = 1;
            this.calculateNewFields();
            WritableSheet studentDataSheet = copy.getSheet(this.sheetNo);
            //Write Name as string
            studentDataSheet.addCell(new Label(0, newRowMark, (String)Data[0]));
            //Write ID as Number
            studentDataSheet.addCell(new Number(1, newRowMark, (int)Data[1]));
            //Write Gender as Capital Char from String
            studentDataSheet.addCell(new Label(2, newRowMark, (String)Data[2]));
            //Write DOB as DateCell
            studentDataSheet.addCell(new DateTime(3, newRowMark, Date.valueOf((LocalDate) Data[3]), new jxl.write.WritableCellFormat(new DateFormat("yyyy-mm-dd"))));
            //Write Age as Number
            studentDataSheet.addCell(new Number(4, newRowMark, (int)Data[4]));
            //Write Email as string
            studentDataSheet.addCell(new Label(5, newRowMark, (String)Data[5]));
            
            System.out.println("Entry Added Successfully ");
            copy.write();
            System.out.println("Closing Sheet ");
            copy.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }
}
