package hu.javamiddle.reporting;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TemplateDemo {

    public static void main(String[] args) {
        // Thymeleaf (Spring MVC)
        // JSP (Java EE)
        // Freemarker
        // Velocity
        // XSLT - XML Stylesheet Language Transformations (XPath, XSD)


        List<Book> books = IntStream.range(0, 20)
                .mapToObj(e -> new Book())
                .collect(Collectors.toList());

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("file.resource.loader.path", "./templates");
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("hello.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("name", "World");
        velocityContext.put("books", books);

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);

        System.out.println(stringWriter);
    }

}
