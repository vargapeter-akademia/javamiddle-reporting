package hu.javamiddle.reporting;

import com.github.javafaker.Address;
import com.github.javafaker.Animal;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerDemo {

    public static void main(String[] args) {
        Locale hu = Locale.forLanguageTag("hu");

        Faker faker = Faker.instance(hu);

        Animal animal = faker.animal();
        System.out.println(animal.name());

        Address address = faker.address();
        System.out.println(address.city());

        Book book = faker.book();
        System.out.println(book.author());
    }

}
