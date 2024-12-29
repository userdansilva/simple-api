package com.catalogar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/designs")
public class Main {

    private final DesignRepository designRepository;

    public Main(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Design> getDesigns() {
        return designRepository.findAll();
    }

    @PostMapping
    public Design addDesign(@RequestBody NewDesignRequest request) {
        Design design = new Design();

        design.setTitle(request.title());
        design.setCategories(request.categories());
        design.setProduct(request.product());

        return designRepository.save(design);
    }

    public record NewDesignRequest (
            String title,
            String categories,
            String product
    ) {}

    @DeleteMapping("{designId}")
    public void deleteDesign(@PathVariable("designId") Integer id) {
        designRepository.deleteById(id);
    }

    @PutMapping("{designId}")
    public Design updateDesign(
            @PathVariable("designId") Integer id,
            @RequestBody UpdateDesignRequest request
    ) {
        Design design = new Design();

        design.setId(id);
        design.setTitle(request.title());
        design.setCategories(request.categories());
        design.setProduct(request.product());

        return designRepository.save(design);
    }

    public record UpdateDesignRequest(
            String title,
            String categories,
            String product
    ) {}
}
