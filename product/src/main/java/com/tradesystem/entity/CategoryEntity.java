package com.tradesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ProductEntity> productEntities = new ArrayList<>();

    public void addProduct(ProductEntity productEntity) {
        productEntities.add(productEntity);
    }

    class A {
        List<String> names;
    }
}
