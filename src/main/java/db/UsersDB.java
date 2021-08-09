package db;

import model.User;

import java.sql.*;

public class UsersDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/myspace?serverTimezone=Europe/Minsk";
    private static final String DB_USER = "Bahish";
    private static final String DB_PASSWORD = "tadam";

    /*public static User selectOne(int id) {
        User user = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sqlSelectOneUserById = "SELECT * FROM users where id=?";

                try (PreparedStatement ps = cn.prepareStatement(sqlSelectOneUserById)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        int userID = rs.getInt("id");
                        String userLogin = rs.getString("login");
                        String userPassword = rs.getString("password");

                        user = new User(userID, userLogin, userPassword);
                        user.setArticles(ArticlesDB.selectArticlesForThisUser(user.getId()));
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        return user;
    }*/

    public static User selectOne(String login, String password) {
        User user = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sqlSelectOneUserByLoginAndPassword = "SELECT * FROM users where login=? and password=?";

                try (PreparedStatement ps = cn.prepareStatement(sqlSelectOneUserByLoginAndPassword)) {
                    ps.setString(1, login);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        int userID = rs.getInt("id");
                        user = new User(userID, login, password);
                        user.setArticles(ArticlesDB.selectArticlesForThisUser(user.getId()));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
