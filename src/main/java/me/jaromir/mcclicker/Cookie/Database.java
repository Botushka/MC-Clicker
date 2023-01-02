package me.jaromir.mcclicker.Cookie;

import me.jaromir.mcclicker.Listener.CookieListener;

import java.sql.*;

public class Database {

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }
        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";


        this.connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the cookie database");
        return this.connection;
    }

    public void initializeDatabase()  throws SQLException{
            Statement statement = getConnection().createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS sakila(uuid varchar(36) primary key, cookies long, count long)";
            statement.execute(sql);

    }

    public CookieListener findPlayerStatsByUUID(String uuid){
        Statement statement = getConnection().createStatement();
        String sql = "SELECT * FROM Sakila WHERE uuid = " + uuid;
        ResultSet result = statement.executeQuery(sql);

        if(result.next()){
            Integer cookies = result.getLong("cookies");
            Integer count = result.getLong("count");
            Sakila sakila = new Sakila(uuid, cookies, count);
            statement.close();
            return sakila;
        }
        statement.close();
        return null;
    }

}
