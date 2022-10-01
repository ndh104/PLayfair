/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author nguyenphuduc
 */
import java.util.Date;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

public class test {

  public static void main(String[] args) {

    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    Date dateobj = new Date();

    System.out.println(df.format(dateobj));

   
  }
}
