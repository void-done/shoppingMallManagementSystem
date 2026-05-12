package com.shoppingmall.shopowner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_owner")
public class ShopOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;
    
    private String ownerName;
    private String shopName;
    private String contactNumber;

    // Default Constructor (Required by JPA)
    public ShopOwner() {
    }

    
    public ShopOwner(Integer ownerId, String ownerName, String shopName, String contactNumber) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.shopName = shopName;
        this.contactNumber = contactNumber;
    }

    
    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}