package com.shopingCart.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopingCart.bean.Messsage;
import com.shopingCart.pd.IShopingCart;

@RestController
public class shopingCartReaderController {
  private Logger log = LoggerFactory.getLogger(shopingCartReaderController.class);
  @Autowired private IShopingCart service;
  @Autowired private JmsTemplate jmsTemplate;

  @PutMapping("/saveMessage")
  public ResponseEntity<?> storeMessageinDB(@RequestBody Messsage msg) {
    log.debug("Start");
    return ResponseEntity.status(HttpStatus.OK).body(service.saveMessgae(msg));
  }
}
