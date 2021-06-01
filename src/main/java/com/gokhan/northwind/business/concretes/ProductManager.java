package com.gokhan.northwind.business.concretes;

import com.gokhan.northwind.business.abstracts.ProductService;
import com.gokhan.northwind.core.utilities.DataResult;
import com.gokhan.northwind.core.utilities.Result;
import com.gokhan.northwind.core.utilities.SuccessDataResult;
import com.gokhan.northwind.core.utilities.SuccessResult;
import com.gokhan.northwind.dataAccess.abstracts.ProductDao;
import com.gokhan.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(),"Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<>(productDao.findAll(sort));
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<>(productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Ürün eklendi.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(productDao.getByProductName(productName));
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByProductNameAndCategory_Id(productName,categoryId),"SUCCESS");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByProductNameOrCategory_Id(productName,categoryId),"SUCCESS");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(productDao.getByCategoryIn(categories),"SUCCESS");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameContains(productName),"SUCCESS");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameStartsWith(productName),"SUCCESS");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByNameAndCategory(productName,categoryId),"SUCCESS");
    }
}
