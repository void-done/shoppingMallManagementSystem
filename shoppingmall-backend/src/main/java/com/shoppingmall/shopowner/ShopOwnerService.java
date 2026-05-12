package com.shoppingmall.shopowner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShopOwnerService {

    @Autowired
    private ShopOwnerRepository repository;

    public List<ShopOwner> listAll() {
        return repository.findAll();
    }

    public void save(ShopOwner shopOwner) {
        repository.save(shopOwner);
    }

    public ShopOwner get(Integer id) {
        return repository.findById(id).get();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}