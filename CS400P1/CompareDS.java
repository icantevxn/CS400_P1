//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P1 Implement and Test an ADT
// Files: DS_My.java, TestDS_my.java, DataStructureADTTest.java, CompareDS.java
// Course: COMP SCI 400 (LEC 001) Spring 2020
//
// Author: Evangeline Lim
// Email: elim28@wisc.edu
// Lecturer's Name: Deb Deppler
//
//
/////////////////////////////// ///////////////////////////////////////////////
/**
 * This class compares runtime for DS_My and DS_Srivatsan
 * 
 * @author evangelinelim
 *
 */
public class CompareDS {

  /**
   * Generates array of keys of n size.
   * 
   * @param n integer of wanted array size
   * @return String of array of keys
   */
  private static String[] generateKeys(int n) {
    String[] keys = new String[n];
    for (int i = 0; i < n; i++) {
      keys[i] = Integer.toString(i);
    }
    return keys;
  }

  /**
   * Generates array of values of n size.
   * 
   * @param n integer of wanted array size
   * @return String of array of values
   */
  private static String[] generateValues(int n) {
    String[] values = new String[n];
    for (int i = 0; i < n; i++) {
      values[i] = Integer.toString(i);
    }
    return values;
  }

  public static void main(String args[]) {
    

    // Test 1
    System.out.println("CompareDS.main: Compares work time for: DS_My and DS_Srivatsan.");
    System.out
        .println("Description: Programs inserts 100 keys and values using Math.random() function");
    DS_My mine = new DS_My();
    DS_Srivatsan sri = new DS_Srivatsan();
    int n1 = 100;
    String keys1[] = generateKeys(n1);
    String values1[] = generateValues(n1);

    long startTime = System.nanoTime();

    for (int i = 0; i < n1; i++) {
      mine.insert(keys1[i], values1[i]);
    }
    long endTime = System.nanoTime();
    System.out.println("DS_My takes " + (endTime - startTime) + "ns to run.");

    long startTimeD = System.nanoTime();

    for (int i = 0; i < n1; i++) {
      sri.insert(keys1[i], values1[i]);
    }
    long endTimeD = System.nanoTime();
    System.out.println("DS_Srivatsan takes " + (endTimeD - startTimeD) + "ns to run.\n");


    // Test 2.1
    System.out.println("CompareDS.main: Compares work time for: DS_My and DS_Srivatsan.");
    System.out.println("Description: Programs inserts 1000 keys and values.");
    DS_My mine2 = new DS_My();
    DS_Srivatsan sri2 = new DS_Srivatsan();
    int n2 = 1000;
    String keys2[] = generateKeys(n2);
    String values2[] = generateValues(n2);

    long startTime2 = System.nanoTime();

    for (int i = 0; i < n2; i++) {
      mine2.insert(keys2[i], values2[i]);
    }
    long endTime2 = System.nanoTime();
    System.out.println("DS_My takes " + (endTime2 - startTime2) + "ns to run.");


    long startTimeD2 = System.nanoTime();

    for (int i = 0; i < n2; i++) {
      sri2.insert(keys2[i], values2[i]);
    }
    long endTimeD2 = System.nanoTime();
    System.out.println("DS_Srivatsan takes " + (endTimeD2 - startTimeD2) + "ns to run.\n");



    // Test 2.2
    System.out.println("CompareDS.main: Compares work time for: DS_My and DS_Srivatsan.");
    System.out.println("Description: Programs retrieves 1000 keys and values.");

    long startTime2_2 = System.nanoTime();

    for (int i = 0; i < n2; i++) {
      mine2.get(keys2[i]);
    }


    long endTime2_2 = System.nanoTime();
    System.out.println("DS_My takes " + (endTime2_2 - startTime2_2) + "ns to run.");


    long startTimeD2_2 = System.nanoTime();

    for (int i = 0; i < n2; i++) {
      sri2.get(keys2[i]);
    }
    long endTimeD2_2 = System.nanoTime();
    System.out.println("DS_Srivatsan takes " + (endTimeD2_2 - startTimeD2_2) + "ns to run.\n");



    // Test 3
    System.out.println("CompareDS.main: Compares work time for: DS_My and DS_Srivatsan.");
    System.out.println("Description: Programs inserts 10000 keys and values.");
    DS_My mine3 = new DS_My();
    DS_Srivatsan sri3 = new DS_Srivatsan();
    int n3 = 10000;
    String keys3[] = generateKeys(n3);
    String values3[] = generateValues(n3);

    long startTime3 = System.nanoTime();

    for (int i = 0; i < n3; i++) {
      mine3.insert(keys3[i], values3[i]);
    }

    long endTime3 = System.nanoTime();
    System.out.println("DS_My takes " + (endTime3 - startTime3) + "ns to run.");


    long startTimeD3 = System.nanoTime();
    for (int i = 0; i < n3; i++) {
      sri3.insert(keys3[i], values3[i]);
    }

    long endTimeD3 = System.nanoTime();
    System.out.println("DS_Srivatsan takes " + (endTimeD3 - startTimeD3) + "ns to run.\n");


    // Test 4
    System.out.println("CompareDS.main: Compares work time for: DS_My and DS_Srivatsan.");
    System.out.println(
        "Description: Programs inserts 1000000 keys and values.");
    DS_My mine4 = new DS_My();
    DS_Srivatsan sri4 = new DS_Srivatsan();
    int n4 = 1000000;
    String keys4[] = generateKeys(n4);
    String values4[] = generateValues(n4);

    long startTime4 = System.nanoTime();


    for (int i = 0; i < n4; i++) {
      mine4.insert(keys4[i], values4[i]);
    }

    long endTime4 = System.nanoTime();
    System.out.println("DS_My takes " + (endTime4 - startTime4) + "ns to run.");


    long startTimeD4 = System.nanoTime();
    for (int i = 0; i < n4; i++) {
      sri4.insert(keys4[i], values4[i]);
    }
    long endTimeD4 = System.nanoTime();
    System.out.println("DS_Srivatsan takes " + (endTimeD4 - startTimeD4) + "ns to run.\n");
  }



}

