package com.example.back.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.model.Product;
import com.example.back.service.ProductService;

@RestController
@CrossOrigin("*")//所有IP可以用
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(       //有找到回傳OK
            ()->ResponseEntity.notFound().build() //沒有找到相關物件回傳回去
        );
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product){ //createProduct 自己定義名稱 RequestBody表單回傳
        return productService.saveProduct(product);
    } //儲存紀錄

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetail){
        Optional<Product> product = productService.getProductById(id);
        if(product.isPresent()){
            Product productNew = product.get();
            productNew.setName(productDetail.getName());
            productNew.setDescription(productDetail.getDescription());
            productNew.setPrice(productDetail.getPrice());
            return ResponseEntity.ok(productService.updateProduct(productNew));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    } //更新紀錄

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        Optional<Product> product = productService.getProductById(id);//尋找ID
        if(product.isPresent()){       //isPresent判斷存不存在
            productService.deleteProduct(id); 
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//刪除紀錄
}
