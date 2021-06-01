package com.gokhan.northwind.api.controllers;

import com.gokhan.northwind.business.abstracts.ProductService;
import com.gokhan.northwind.core.utilities.DataResult;
import com.gokhan.northwind.core.utilities.Result;
import com.gokhan.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public Result getByProductName(@RequestParam String productName){
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameOrCategory")
    public Result getByProductNameOrCategory(@RequestParam String productName, @RequestParam Integer categoryId){
        return productService.getByProductNameOrCategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }
}
