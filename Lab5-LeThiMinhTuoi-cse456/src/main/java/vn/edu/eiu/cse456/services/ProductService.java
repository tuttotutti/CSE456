package vn.edu.eiu.cse456.services;

import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.entities.Product;
import vn.edu.eiu.cse456.repo.ProductRepo;

import java.util.List;

@Service
public class ProductService {
    public void save(Product p){
        ProductRepo.save(p);
    }

    public void update(Product p){
        ProductRepo.update(p);
    }

    public void delete(Product p){
        ProductRepo.delete(p);
    }

    public List<Product> findAll(){
        return ProductRepo.findAll();
    }

    public Product findById(long id){
        return ProductRepo.findById(id);
    }

    public List<Product> findByName(String name){
        return ProductRepo.findByName(name);
    }

    public List<Product> findByPrice(double minPrice, double maxPrice){
        return ProductRepo.findByPrice(minPrice, maxPrice);
    }

    public List<Product> findByStock(int stock){
        return ProductRepo.findByStock(stock);
    }
}
