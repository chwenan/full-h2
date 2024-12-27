package com.example.back.service;

import com.example.back.model.Product;
import com.example.back.repository.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;



//實作
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override //Override 覆寫資料
    //public 公有函數讓其他人使用
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    } //儲存紀錄

    @Override
    public Product updateProduct(Product product){
        return productRepository.save(product);
    } //更新紀錄

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }//刪除紀錄

}

