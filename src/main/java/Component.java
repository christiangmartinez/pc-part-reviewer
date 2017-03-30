import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Component {
  private int id;
  private String type;
  private String name;
  private int price;
  private String review;
  // private int manufacturerId; (remember to add this to the constructor as well!!!)

  public Component(String type, String name, int price, String review) {
    this.type = type;
    this.name = name;
    this.price = price;
    this.review = review;
    // this.manufacturerId = manufacturerId;
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

  // public int getManufacturerId() {
  //   return manufacturerId;
  // }

  @Override
  public boolean equals(Object otherComponent) {
    if (!(otherComponent instanceof Component)) {
      return false;
    } else {
      Component newComponent = (Component) otherComponent;
      return this.getType().equals(newComponent.getType())
        && this.getName().equals(newComponent.getName())
        && this.getPrice() == newComponent.getPrice()
        && this.getReview().equals(newComponent.getReview());
        // && this.getManufacturerId() == newComponent.getManufacturerId();
    }
  }

  public static List<Component> all() {
    //add manufacturerId to SELECT after it's created
    String sql = "SELECT id, type, name, price, review FROM components";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Component.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      //add manufacturerId to INSERT INTO and VALUES after it's created
      String sql = "INSERT INTO components(type, name, price, review) VALUES (:type, :name, :price, :review)";
      this.id = (int) con.createQuery(sql, true)
      // .addParameter("manufacturerId", this.manufacturerId)
      .addParameter("type", this.type)
      .addParameter("name", this.name)
      .addParameter("price", this.price)
      .addParameter("review", this.review)
      .executeUpdate()
      .getKey();
    }
  }

  public static Component find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM components where id = :id";
      Component component = con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Component.class);
      return component;
    }
  }

}
