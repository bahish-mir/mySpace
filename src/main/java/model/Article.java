package model;

public class Article {
    private int id;
    private String header;
    private String shortDescription;
    private String textArticle;
    private String dateCreate;
    private String author;

    public Article(int id, String header, String shortDescription, String textArticle, String dateCreate, String author) {
        this.id = id;
        this.header = header;
        this.shortDescription = shortDescription;
        this.textArticle = textArticle;
        this.dateCreate = dateCreate;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTextArticle() {
        return textArticle;
    }

    public void setTextArticle(String textArticle) {
        this.textArticle = textArticle;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final String NEXT_LINE = "\n";
        final String DELIMITER = ";";
        final String HEADER = "header: ";
        final String SHORT_DESCRIPTION = "shortDescription: ";
        final String TEXT_ARTICLE = "textArticle: ";
        final String DATE_CREATE = "dateCreate: ";
        final String AUTHOR = "author: ";
        final StringBuilder sb = new StringBuilder();
        sb.append(HEADER + header + DELIMITER + NEXT_LINE)
                .append(SHORT_DESCRIPTION + shortDescription + DELIMITER + NEXT_LINE)
                .append(TEXT_ARTICLE + textArticle + DELIMITER + NEXT_LINE)
                .append(DATE_CREATE + dateCreate + DELIMITER + NEXT_LINE)
                .append(AUTHOR + author + DELIMITER + NEXT_LINE);

        return sb.toString();
    }
}
