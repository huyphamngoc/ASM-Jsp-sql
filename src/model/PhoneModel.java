package model;

import entity.Phone;

import java.sql.*;
import java.util.ArrayList;

public class PhoneModel {
    Connection connection;
    ConnectSql connectSql = new ConnectSql();
    public boolean insert(Phone phone) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectSql.URL, connectSql.USER, connectSql.PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into phone (brand,name,price,description) value (?,?,?,?)");
            preparedStatement.setString(1, phone.getBrand());
            preparedStatement.setString(2, phone.getName());
//            preparedStatement.setString(3, md5(account.getPassWord()));
            preparedStatement.setString(3, phone.getPrice());
            preparedStatement.setString(4, phone.getDescription());
            preparedStatement.execute();
            System.out.println("success Usermodel");
            return true;
        } catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Phone> select() {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM phone");

            ResultSet rs = preparedStatement.executeQuery();

            ArrayList<Phone> listFeedback = new ArrayList<Phone>();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String price = rs.getString("price");
                String brand = rs.getString("brand");
                String description = rs.getString("description");
                Phone fb = new Phone(id, name, price, brand, description);
                listFeedback.add(fb);
            }
            return listFeedback;

        } catch (Exception e) {
            System.out.println("SQL select " + e);
        }
        return null;
    }
}
