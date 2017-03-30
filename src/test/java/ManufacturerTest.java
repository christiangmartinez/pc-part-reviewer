import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ManufacturerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void manufacturer_instantiatesCorrectly_true() {
    Manufacturer testManufacturer = new Manufacturer("Asus");
    assertTrue(testManufacturer instanceof Manufacturer);
  }

  @Test
  public void getName_manufacturerInstantiatesWithName_Asus() {
    Manufacturer testManufacturer = new Manufacturer("Asus");
    assertEquals("Asus", testManufacturer.getName());
  }

}
