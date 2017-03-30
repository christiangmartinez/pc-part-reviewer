import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Component {
  private int id;
  private String type;
  private String name;
  private int price;
  private String review;
  private int manufacturerId;

  public Component(String type, String name, int price, String review, int manufacturerId) {
    this.type = type;
    this.name = name;
    this.price = price;
    this.review = review;
    this.manufacturerId = manufacturerId;
  }

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public String getReview() {
    return review;
  }

  public int getManufacturerId() {
    return manufacturerId;
  }

  @Override
  public boolean equals(Object otherComponent) {
    if (!(otherComponent instanceof Component)) {
      return false;
    } else {
      Component newComponent = (Component) otherComponent;
      return this.getType().equals(newComponent.getType())
        && this.getName().equals(newComponent.getName())
        && this.getPrice() == newComponent.getPrice()
        && this.getReview().equals(newComponent.getReview())
        && this.getManufacturerId() == newComponent.getManufacturerId();
    }
  }

}
