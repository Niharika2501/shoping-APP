package com.shopingCart.pd;

import org.springframework.stereotype.Service;

import com.shopingCart.bean.Messsage;

@Service
public interface IShopingCart {
  /**
   * this method read data from Queue and Store in database
   *
   * @return - String
   */
  String saveMessgae(Messsage msg);
}
