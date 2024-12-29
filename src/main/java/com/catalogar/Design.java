package com.catalogar;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Design {

    @Id
    @SequenceGenerator(
            name = "design_id_sequence",
            sequenceName = "design_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "design_id_sequence"
    )
    private Integer id;
    private String title;
    private String categories;
    private String product;

    public Design (Integer id,
                String title,
                String categories,
                String product) {
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.product = product;
    }

    public Design() {}

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategories() {
        return categories;
    }

    public String getProduct() {
        return product;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Design design = (Design) o;
        return Objects.equals(id, design.id) && Objects.equals(title, design.title) && Objects.equals(categories, design.categories) && Objects.equals(product, design.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, categories, product);
    }

    @Override
    public String toString() {
        return "Design{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", categories='" + categories + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
