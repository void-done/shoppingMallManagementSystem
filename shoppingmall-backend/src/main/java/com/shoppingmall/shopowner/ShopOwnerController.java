package com.shoppingmall.shopowner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/shopowners")
public class ShopOwnerController {

    @Autowired
    private ShopOwnerService service;

    
    @GetMapping
    public List<ShopOwner> list() {
        return service.listAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ShopOwner> get(@PathVariable Integer id) {
        try {
            ShopOwner owner = service.get(id);
            return new ResponseEntity<>(owner, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PostMapping
    public ShopOwner add(@RequestBody ShopOwner shopOwner) {
        service.save(shopOwner);
        return shopOwner;
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ShopOwner shopOwner, @PathVariable Integer id) {
        try {
            ShopOwner existOwner = service.get(id);
            
            existOwner.setOwnerName(shopOwner.getOwnerName());
            existOwner.setShopName(shopOwner.getShopName());
            existOwner.setContactNumber(shopOwner.getContactNumber());
            
            service.save(existOwner);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}