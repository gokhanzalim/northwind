package com.gokhan.northwind.business.abstracts;

import com.gokhan.northwind.core.utilities.DataResult;
import com.gokhan.northwind.core.utilities.Result;
import com.gokhan.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAllSorted();

    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

}
