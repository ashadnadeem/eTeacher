/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceregister;

/**
 *
 * @author Ashad Nadeem
 */
public class Blank extends Exception{
    private String message;
    public Blank(String msg){
        this.message = msg;
    }
    public String toString(){
        return this.message;
    }
}
