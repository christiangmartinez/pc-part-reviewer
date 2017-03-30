import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ComponentTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void component_instantiatesCorrectly_true() {
    Component testComponent = new Component("GPU", "GTX 1070", 400, "good", 1);
    assertTrue(testComponent instanceof Component);
  }

  @Test
  public void getters_returnCorrectValues_variables() {
    Component testComponent = new Component("GPU", "GTX 1070", 400, "good", 1);
    assertEquals("GPU", testComponent.getType());
    assertEquals("GTX 1070", testComponent.getName());
    assertEquals(400, testComponent.getPrice());
    assertEquals("good", testComponent.getReview());
    assertEquals(1, testComponent.getManufacturerId());
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAreTheSame() {
    Component firstComponent = new Component("GPU", "GTX 1070", 400, "good", 1);
    Component secondComponent = new Component("GPU", "GTX 1070", 400, "good", 1);
    assertTrue(firstComponent.equals(secondComponent));
  }



}
