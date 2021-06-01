package com.gokhan.northwind.dataAccess.abstracts;

import com.gokhan.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_Id(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_Id(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.id=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);
}
