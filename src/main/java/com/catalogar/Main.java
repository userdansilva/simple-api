package com.catalogar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/designs")
    public DesignsResponse designs() {
        Design design = new Design(
                "You only live once",
                List.of(
                        new Category(1, "Party"),
                        new Category(2, "Vocation")
                ),
                new Product(1, "Mug")
        );

        return new DesignsResponse(List.of(design));
    }

    record DesignsResponse(List<Design> designs){}

    record Design(
            String title,
            List<Category> categories,
            Product product
    ){}

    record Category(
            int id,
            String name
    ) {}

    record Product(
            int id,
            String name
    ) {}
}
