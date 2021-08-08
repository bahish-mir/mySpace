import model.Article;

import java.sql.*;
import java.util.LinkedList;

public class ArticlesDB {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/myspace?serverTimezone=Europe/Minsk";
    private static final String DB_USER = "Bahish";
    private static final String DB_PASSWORD = "tadam";

    public static LinkedList<Article> selectArticlesForThisUser(int userID) {
        LinkedList<Article> articles = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sqlFindArticlesByUserID = "select articleID from userarticles where userID = ?";

                try(PreparedStatement ps = cn.prepareStatement(sqlFindArticlesByUserID)) {
                    ps.setInt(1, userID);
                    ResultSet rs = ps.executeQuery();
                    String sqlSelectArticlesByUserID = "select * from article where id = ?";

                    while (rs.next()) {
                        int articleID = rs.getInt("id");
                        PreparedStatement psForSelect = cn.prepareStatement(sqlSelectArticlesByUserID);
                        psForSelect.setInt(1, articleID);
                        ResultSet resultSet = psForSelect.executeQuery();

                        if (resultSet.next()) {
                            String header = resultSet.getString("header");
                            String shortDescription = resultSet.getString("shortDescription");
                            String textArticle = resultSet.getString("textArticle");
                            String dateCreate = resultSet.getString("dateCreate");
                            String author = resultSet.getString("author");

                            Article article = new Article(articleID, header, shortDescription, textArticle, dateCreate, author);
                            articles.add(article);
                        }
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return articles;
    }
}
