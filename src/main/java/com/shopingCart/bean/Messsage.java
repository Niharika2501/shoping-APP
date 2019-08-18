package com.shopingCart.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.shopingCart.util.LocalDateDeserializer;
import com.shopingCart.util.LocalDateSerializer;

@Entity
@Table(name = "messsage")
public class Messsage implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  private String description;

  // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  private LocalDate createDate;

  public Messsage() {
    super();
  }

  public Messsage(String id, String description, LocalDate createDate) {
    super();
    this.id = id;
    this.description = description;
    this.createDate = createDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDate createDate) {
    this.createDate = createDate;
  }

  @Override
  public String toString() {
    return "Messsage [id="
        + id
        + ", description="
        + description
        + ", createDate="
        + createDate
        + "]";
  }
}
