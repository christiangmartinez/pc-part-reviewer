import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Manufacturer {
  private String name;
  private int id;

  public Manufacturer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

}
