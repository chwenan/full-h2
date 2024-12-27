package com.example.back.service;

import com.example.back.model.Product;
import java.util.List;
import java.util.Optional;

//宣告函數(空值)
public interface ProductService{
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product); //儲存紀錄
    Product updateProduct(Product product); //更新紀錄
    void deleteProduct(Long id);//刪除紀錄
}