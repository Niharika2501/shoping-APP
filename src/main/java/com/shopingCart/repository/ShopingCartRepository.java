package com.shopingCart.repository;

import com.shopingCart.bean.Messsage;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ShopingCartRepository extends CrudRepository<Messsage, String> {}
