package Data;

import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String query = "EXEC SP_Register ?, ?, ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setInt(3, user.getRole());
            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                return "Đăng ký tài khoản thành công!";
            } else {
                return "Đăng ký tài khoản thất bại, vui lòng kiểm tra lại thông tin đăng ký!";
            }
        } catch (SQLException e) {
            return e.toString().replaceAll("com.microsoft.sqlserver.jdbc.SQLServerException: ", "") + "!";
        }
    }

    public static void main(String[] args) {
        User user = new User("haudep1", "haunguyen", 1);
        System.out.println(Register(user));
    }

}
