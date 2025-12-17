package dao;

import db.DBConnection;
import model.Product;
import java.sql.*;
import java.util.*;

public class ProductDAO {

    public static List<Product> getAllProducts() throws Exception {
        List<Product> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM products");

        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            p.setStock(rs.getInt("stock"));
            list.add(p);
        }

        rs.close();
        st.close();
        con.close();
        return list;
    }
}
