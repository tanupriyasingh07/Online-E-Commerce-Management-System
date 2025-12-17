package dao;

import db.DBConnection;
import java.sql.*;

public class OrderDAO {

    public static void placeOrder(int buyerId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO orders(buyer_id,status) VALUES (?,?)"
        );
        ps.setInt(1, buyerId);
        ps.setString(2, "PLACED");
        ps.executeUpdate();

        ps.close();
        con.close();
    }
}
