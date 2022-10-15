package Data;

import Client.frmUser;
import Entity.Student;
import Entity.Subject;
import Entity.Teacher;
import Entity.Transcript;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class DBAccess {

    static Connection connection = SQLServerConnection.getConnection();
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    // Login
    public static String Login(User user) {
        String query = "EXEC SP_Login ?, ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(3);
            } else {
                return "Đăng nhập thất bại, vui lòng kiểm tra lại thông tin đăng nhập!";
            }
        } catch (SQLException e) {
            return e.toString().replaceAll("com.microsoft.sqlserver.jdbc.SQLServerException: ", "") + "!";
        }
    }

    // Register
    public static String Register(User user) {
        String query = "EXEC SP_Register ?, ?, 2";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                return "Đăng ký tài khoản thành công!";
            } else {
                return "Đăng ký tài khoản thất bại, vui lòng kiểm tra lại thông tin đăng ký!";
            }
        } catch (SQLException e) {
            if(e.toString().contains("PRIMARY KEY")){
                return "User is already in database!";
            }else{
                return e.toString().replaceAll("com.microsoft.sqlserver.jdbc.SQLServerException: ", "") + "!";
            }
            
        }
    }

    //display tb_User
    public static List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String query = "EXEC username_role";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new User(
                        resultSet.getString(1),
                        resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static void deleteUser(String userName) {
        String query = "EXEC deleteUser ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    //==============================================================
    //Teacher
    //==============================================================
    public static List<Teacher> getAllTeacher() {
        List<Teacher> list = new ArrayList<>();
        String query = "exec teacher";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Teacher(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    //addTeacher
    public static Boolean addTeacher(String teacherID,
            String encrypt,
            String fullName,
            String sex,
            String phoneNumber,
            String mail,
            String address) {
        String query = "EXEC insertTeacher ?,?,?,?,?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherID);
            preparedStatement.setString(2, encrypt);
            preparedStatement.setString(3, fullName);
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, mail);
            preparedStatement.setString(7, address);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    //deleteTeacher
    public static Boolean deleteTeacher(String teacherID) {
        String query = "EXEC deleteTeacher ?,?,?,?,?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherID);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    //editTeacher
    public static Boolean editTeacher(String teacherID,
            String userName,
            String fullName,
            String sex,
            String phoneNumber,
            String mail,
            String address) {
        String query = "EXEC editTeacher ?,?,?,?,?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherID);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, fullName);
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, mail);
            preparedStatement.setString(7, address);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    //============================================================
    //Student
    //============================================================
    public static List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        String query = "exec student";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Student(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //===============================================================
    public static Boolean addStudent(String studentID,
            String fullName,
            String sex,
            String phoneNumber,
            String mail,
            String address) {
        String query = "EXEC insertStudent ?,?,?,?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentID);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, sex);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, mail);
            preparedStatement.setString(6, address);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    public static Boolean editStudent(String studentID,
            String fullName,
            String sex,
            String phoneNumber,
            String mail,
            String address) {
        String query = "EXEC editStudent ?,?,?,?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentID);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, sex);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, mail);
            preparedStatement.setString(6, address);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    public static Boolean deleteStudent(String studentID) {
        String query = "EXEC deleteStudent ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, studentID);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    //Subject
    //===============================================================
    public static List<Subject> getAllSubject() {
        List<Subject> list = new ArrayList<>();
        String query = "exec sub";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Subject(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //===============================================================
    public static Boolean addSubject(String subID, 
                                    String subNameString, 
                                    int subCredits) {
        String query = "EXEC insertSubject ?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subID);
            preparedStatement.setString(2, subNameString);
            preparedStatement.setInt(3, subCredits);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    public static Boolean editSubject(String subID, 
                                    String subNameString, 
                                    int subCredits) {
        String query = "EXEC editSubject ?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subID);
            preparedStatement.setString(2, subNameString);
            preparedStatement.setInt(3, subCredits);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    public static Boolean deleteSubject(String subID) {
        String query = "EXEC deleteSubject ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subID);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    //Transcript
    //===============================================================
    public static List<Transcript> getAllTranscript() {
        List<Transcript> list = new ArrayList<>();
        String query = "exec transcript";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Transcript(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getFloat(4)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    //===============================================================
    public static Boolean addTranscript(String teacherID, 
                                    String studentID,
                                    String subID,
                                    float point) {
        String query = "EXEC insertTranscript ?,?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherID);
            preparedStatement.setString(2, studentID);
            preparedStatement.setString(3, subID);
            preparedStatement.setFloat(4, point);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    public static Boolean editTranscript(String teacherID, 
                                    String studentID,
                                    String subID,
                                    float point) {
        String query = "EXEC editTranscript ?,?,?,?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherID);
            preparedStatement.setString(2, studentID);
            preparedStatement.setString(3, subID);
            preparedStatement.setFloat(4, point);
            int result = preparedStatement.executeUpdate();
            return result != 0;
        } catch (SQLException e) {
            return false;
        }
    }
    //===============================================================
    public static void deleteTranscript(String teacherID) {
        String query = "EXEC deleteTranscript ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacherID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
//===================================================================
    public static void main(String[] args) {
        System.out.println(getAllUser());
    }

}
