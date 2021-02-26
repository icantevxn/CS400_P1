import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * This class manages the Binary Search Tree for Camp Badger.
 * 
 * @author josiahchoong
 *
 */
public class CampManager {
  private CamperBST campers;
  private final static String[] CABIN_NAMES =
      new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};

  /**
   * Constructor for the CampManager by initializing the campers field.
   */
  public CampManager() {
    campers = new CamperBST();
  }

  /**
   * Prints statistics based on the current "state" of the camp. The statistics to be printed is the
   * total number of campers.
   */
  public void printStatistics() {
    System.out.println("--- Camp Statistics ---");
    System.out.println("Number of campers: " + campers.size());
    System.out.println("-----------------------");
  }

  /**
   * "Enrolls" a camper by determining their cabin and adding them to the tree.
   * 
   * @param newCamper camper to be added
   */
  public void enrollCamper(Camper newCamper) {
    int age = newCamper.getAge();

    // Assign cabin to the camper based on their age
    if (age == 8 || age == 9) {
      newCamper.assignCabin(CABIN_NAMES[0]);
    } else if (age >= 10 && age <= 12) {
      newCamper.assignCabin(CABIN_NAMES[1]);
    } else if (age == 13 || age == 14) {
      newCamper.assignCabin(CABIN_NAMES[2]);
    }

    // Insert camper into BST
    campers.insert(newCamper);
    System.out.println("Enrollment of " + newCamper.getFirstName() + " " + newCamper.getLastName()
        + " Successful!");
  }

  /**
   * "Unenrolls" a camper by removing them from the tree.
   * 
   * @param delCamper the camper to be unenrolled the camp
   * @throws NoSuchElementException if CamperBST.delete throws the exception
   *                                java.util.NoSuchElementException
   */
  public void unenrollCamper(Camper delCamper) throws NoSuchElementException {
    campers.delete(delCamper);
    System.out.println("Unenrollment of " + delCamper.getFirstName() + " " + delCamper.getLastName()
        + " Successful!");
  }

  /**
   * Traverses the tree in the designated order by calling it through the CamperBST class.
   * 
   * @param order the type of traversal for the tree to perform
   * @return the Iterator of Campers from CampBST.traverse()
   */
  public Iterator<Camper> traverse(String order) {
    System.out.println("--- " + order + " Traversal ---");
    return campers.traverse(order);
  }
}
