/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Client.User.DBAccess;
import entity.Encrypt;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenphuduc
 */
public class dao {

    public ArrayList<Encrypt> getEncrypt() {
        ArrayList<Encrypt> list = new ArrayList<>();
        String query = "select e.IdEncrypt, u.FullName, e.DateTimeCreated, e.Encrypt, e.[Key] from tb_Encrypt e, tb_User u WHERE e.UserCreated = u.IdUser";

        try {
            DBAccess acc = new DBAccess();
            ResultSet rs = acc.Query(query);

            while (rs.next()) {
                list.add(new Encrypt(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean Login(String userString, String passString) {
        String query = "select * from tb_User where Username = '" + userString + "' and Password = '" + passString + "'";
        try {
            DBAccess acc = new DBAccess();
            ResultSet rs = acc.Query(query);

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public int getIdUserByUserName(String username){
        String query = "select * from tb_User where Username = '" + username + "'";
        try {
            DBAccess acc = new DBAccess();
            ResultSet rs = acc.Query(query);

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
        dao dao = new dao();
        List<Encrypt> list = dao.getEncrypt();
        for (Encrypt k : list) {
            System.out.println(k);
        }
    }

}
