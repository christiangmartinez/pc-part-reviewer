import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ComponentTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void component_instantiatesCorrectly_true() {
    Component testComponent = new Component("GPU", "GTX 1070", 400, "good");
    assertTrue(testComponent instanceof Component);
  }

  @Test
  public void getters_returnCorrectValues_variables() {
    Component testComponent = new Component("GPU", "GTX 1070", 400, "good");
    assertEquals("GPU", testComponent.getType());
    assertEquals("GTX 1070", testComponent.getName());
    assertEquals(400, testComponent.getPrice());
    assertEquals("good", testComponent.getReview());
    // assertEquals(1, testComponent.getManufacturerId());
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAreTheSame() {
    Component firstComponent = new Component("GPU", "GTX 1070", 400, "good");
    Component secondComponent = new Component("GPU", "GTX 1070", 400, "good");
    assertTrue(firstComponent.equals(secondComponent));
  }

  @Test
  public void all_returnsAllInstancesOfComponent_true() {
    Component firstComponent = new Component("GPU", "GTX 1070", 400, "good");
    firstComponent.save();
    Component secondComponent = new Component("GPU", "GTX 1070", 400, "good");
    secondComponent.save();
    assertTrue(Component.all().get(0).equals(firstComponent));
    assertTrue(Component.all().get(1).equals(secondComponent));
  }

  @Test
  public void save_savesIntoDatabase_True() {
    Component testComponent = new Component("GPU", "GTX 1070", 400, "good");
    testComponent.save();
    assertTrue(Component.all().get(0).equals(testComponent));
  }

  @Test
  public void save_assignsIdToComponent() {
    Component testComponent = new Component("GPU", "GTX 1070", 400, "good");
    testComponent.save();
    Component savedComponent = Component.all().get(0);
    assertEquals(testComponent.getId(), savedComponent.getId());
  }

  @Test
  public void find_returnsComponentsWithSameId_secondComponent() {
    Component firstComponent = new Component("GPU", "GTX 1070", 400, "good");
    firstComponent.save();
    Component secondComponent = new Component("CPU", "1800x", 500, "good");
    secondComponent.save();
    assertEquals(secondComponent, Component.find(secondComponent.getId()));
  }

}
