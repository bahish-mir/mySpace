package model;

import java.util.LinkedList;

public class User {
    private int id;
    private String login;
    private String password;
    private LinkedList<Article> articles;

    public User(int id, String login, String password) {
        articles = new LinkedList<>();
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkedList<Article> getArticles() {
        return articles;
    }

    public void setArticles(LinkedList<Article> articles) {
        this.articles = articles;
    }

    public Article getArticle(int id) {
        Article theArticle = null;
        if (!articles.isEmpty()) {
            for (Article article : articles) {
                if (article.getId() == id) {
                    theArticle = article;
                }
            }
        }

        return theArticle;
    }

    public void addArticle (Article article) {
        if (article != null) {
            articles.add(article);
        }
    }
}
