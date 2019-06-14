package model;

import entity.Phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneModel {
    public boolean insert(Phone phone){
        Connection connection;
        ConnectSql connectSql = new ConnectSql();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectSql.URL  ,connectSql.USER,connectSql.PASS);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into phone (brand,name,price,description) value (?,?,?,?)");
            preparedStatement.setString(1, phone.getBrand());
            preparedStatement.setString(2, phone.getName());
//            preparedStatement.setString(3, md5(account.getPassWord()));
            preparedStatement.setString(3, phone.getPrice());
            preparedStatement.setString(4, phone.getDescription());
            preparedStatement.execute();
            System.out.println("success Usermodel" );
            return true;
        }catch (SQLException e) {
            System.out.println("SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
