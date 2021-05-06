package hu.javamiddle.reporting;

import com.github.javafaker.ChuckNorris;
import com.github.javafaker.Faker;

public class Book {
    private static final com.github.javafaker.Book FAKER = Faker.instance().book();
    private static final ChuckNorris chuckNorris = Faker.instance().chuckNorris();

    private final String title = FAKER.title();
    private final String author = FAKER.author();
    private final String genre = FAKER.genre();

    public String fact() {
        return chuckNorris.fact();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
