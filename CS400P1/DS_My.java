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

// TODO: Add class header here
public class DS_My implements DataStructureADT<String, String> {

  /**
   * Inner class for storing key and value as a pair
   **/
  private class KV_pair {
    private String key = "";
    private String value = "";

    private KV_pair(String key, String value) {
      this.key = key;
      this.value = value;
    }

    /**
     * Method to get key
     * 
     * @returns string of key
     */
    private String getKey() {
      return this.key;
    }

    /**
     * Method to get value
     * 
     * @returns string of value
     */
    private String getValue() {
      return this.value;
    }

  }

  // Private Fields to store data pairs
  private int count = 0;
  private int size = 1000000;
  private KV_pair[] pair;

  /**
   * Constructor to initialize array of size 10000000
   */
  public DS_My() {
    this.pair = new KV_pair[size];

  }

  /**
   * Add the key,value pair to the data structure and increases size.If key is null, throws
   * IllegalArgumentException("null key"); If key is already in data structure, throws
   * RuntimeException("duplicate key"); can accept and insert null values
   */
  @Override
  public void insert(String key, String value) {

    if (key == null) {
      throw new IllegalArgumentException("null key");
    }

    if (contains(key)) {
      throw new RuntimeException("duplicate key");
    }

    KV_pair item = new KV_pair(key, value);
    pair[count] = item;// add item
    count++;
    KV_pair[] temp = pair;// storing temporary array

    if (count == (size - 1)) {
      size = size * 2;
      pair = new KV_pair[size];
    } // increase array size

    for (int i = 0; i < count; i++) {
        pair[i] = temp[i];// reassigning array
      }
  }


  /**
   * If key is found, Removes the key from the data structure and decreases size If key is null,
   * throws IllegalArgumentException("null key") without decreasing size If key is not found,
   * returns false.
   */
  @Override
  public boolean remove(String key) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }
    if (count == 0) {
      return false;
    }

    for (int i = 0; i < count; i++) {
      if (pair[i].getKey().equals(key)) {
        pair[i] = null;

        for (int j = i; j < count - 1; j++) {
          pair[j] = pair[j + 1];// moving array up one index
        }
        count--; //decreasing count of index
        return true;
      }
    }
    return false;

  }

  /**
   * Returns the value associated with the specified key get - does not remove key or decrease size
   * return null if key is not null and is not found in data structure. If key is null, throws
   * IllegalArgumentException("null key")
   */
  @Override
  public String get(String key) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }
    for (int i = 0; i < count; i++) {
      if (pair[i].getKey().equals(key)) {
        return pair[i].getValue();
      }
    }
    return null;
  }

  /**
   * Returns true if the key is in the data structure. Returns false if key is null or not present
   */
  @Override
  public boolean contains(String key) {
    if (key == null) {
      return false;
    }
    if (count == 0) {
      return false;
    }
    for (int i = 0; i < count; i++) {
      if (pair[i].getKey().equals(key)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the number of elements in the data structure
   */
  @Override
  public int size() {
    return count;
  }


}
