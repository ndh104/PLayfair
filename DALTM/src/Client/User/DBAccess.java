/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author nguyenphuduc
 */
public class DBAccess {
    private Connection connection;
    private Statement statement;
    public DBAccess(){
        try {
            SQLServerConnection sqlConnection = new SQLServerConnection();
            connection = sqlConnection.getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
        }
    }
    public int Update(String string){
        try {
            int i = statement.executeUpdate(string);
            return i;
        } catch (Exception e) {
            return -1;
        }
    }
    public ResultSet Query(String string){
        try {
            ResultSet resultSet = statement.executeQuery(string);
            return resultSet;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
