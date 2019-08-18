package com.shopingCart.pd;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.shopingCart.bean.Messsage;
import com.shopingCart.repository.ShopingCartRepository;

@Service
public class ShopingCartImpl implements IShopingCart {

  @Autowired private ShopingCartRepository shopingCartRepo;
  @Autowired private JmsTemplate jmsTemplate;

  @Override
  public String saveMessgae(Messsage msg) {
    write(msg);
    Messsage msg1 = read();
    System.out.println("save" + shopingCartRepo.save(msg1));
    getById();
    return null;
  }

  public void write(Messsage msg) {
    jmsTemplate.convertAndSend("message-queue", msg);
  }

  public Messsage read() {
    Messsage result = (Messsage) jmsTemplate.receiveAndConvert("message-queue");
    return result;
  }

  public void getById() {
    System.out.println("MESSAGE:" + shopingCartRepo.findById("1"));
  }
}
