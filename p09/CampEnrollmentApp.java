import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CampEnrollmentApp {
  public static void main(String[] args) {
    CampManager campManager = new CampManager();
    try {
      List<String> fileLines = Files.readAllLines(Paths.get("sim.txt"));

      // Read through every line
      for (int i = 0; i < fileLines.size(); i++) {
        String s = fileLines.get(i);

        // Extract data from string
        String[] data = s.split(" ");

        // Checks which command is being issued
        String c = data[0];
        
        try {
          // Statistics
          if (c.equals("S")) {
            campManager.printStatistics();
          }
          if (c.equals("E") || c.equals("R")) {
            String firstName = data[2];
            String lastName = data[1];
            
            // Enroll
            if (c.equals("E")) {
              int age = Integer.parseInt(data[3]);
              campManager.enrollCamper(new Camper(firstName, lastName, age));
            }
            
            // Unenroll
            if (c.equals("R")) {
              campManager.unenrollCamper(new Camper(firstName, lastName, 10));
            }
          }
          // Traverse
          if (c.equals("T")) {
            String order = data[1];
            Iterator<Camper> itr = campManager.traverse(order);
            while(itr.hasNext()) {
              System.out.println(itr.next());
            }
            System.out.println("--------------------------");
          }
        } catch (NoSuchElementException e2) {
          System.out.println(e2.getMessage());
        } catch (IllegalArgumentException e3) {
          System.out.println(e3.getMessage());
        }
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
