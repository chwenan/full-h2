//連接model
package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.back.model.Product;

@Repository
//class -> interface 拉model的東西; class 要定義屬性和方法;
public interface ProductRepository extends JpaRepository<Product, Long>{    
    
}
