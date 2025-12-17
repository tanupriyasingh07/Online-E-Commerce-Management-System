package dao;

import db.DBConnection;
import model.User;
import java.sql.*;
import java.security.MessageDigest;

public class UserDAO {

    private static String hash(String pass) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] b = md.digest(pass.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte x : b) sb.append(String.format("%02x", x));
        return sb.toString();
    }

    public static User validateUser(String email, String password) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT id,name,role FROM users WHERE email=? AND password=?"
        );
        ps.setString(1, email);
        ps.setString(2, hash(password));

        ResultSet rs = ps.executeQuery();
        User user = null;

        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setRole(rs.getString("role"));
        }

        rs.close();
        ps.close();
        con.close();
        return user;
    }
}
