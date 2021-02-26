import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class DataStructureADTTest<T extends DataStructureADT<String, String>> {

  private T ds;

  protected abstract T createInstance();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
    ds = createInstance();
  }

  @AfterEach
  void tearDown() throws Exception {
    ds = null;
  }


  @Test
  void test00_empty_ds_size() {
    if (ds.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + ds.size());
  }

  // TODO: review tests 01 - 04

  @Test
  void test01_insert_one() {
    String key = "1";
    String value = "one";
    ds.insert(key, value);
    assert (ds.size() == 1);
  }

  @Test
  void test02_insert_remove_one_size_0() {
    String key = "1";
    String value = "one";
    ds.insert(key, value);
    assert (ds.remove(key)); // remove the key
    if (ds.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + ds.size());
  }

  @Test
  void test03_duplicate_exception_thrown() {
    String key = "1";
    String value = "one";
    ds.insert("1", "one");
    ds.insert("2", "two");
    try {
      ds.insert(key, value);
      fail("duplicate exception not thrown");
    } catch (RuntimeException re) {
    }
    assert (ds.size() == 2);
  }


  @Test
  void test04_remove_returns_false_when_key_not_present() {
    String key = "1";
    String value = "one";
    ds.insert(key, value);
    assert (!ds.remove("2")); // remove non-existent key is false
    assert (ds.remove(key)); // remove existing key is true
    if (ds.get(key) != null)
      fail("get(" + key + ") returned " + ds.get(key) + " which should have been removed");
  }


  @Test
  void test05_insert_remove_one() {
    String key = "1";
    String value = "one";
    String key2 = "2";
    String value2 = "two";
    ds.insert(key, value);
    ds.insert(key2, value2);
    ds.remove(key2);
    if (ds.size() == 2) {
      fail("Did not remove" + key2 + ". returned " + ds.size());
    }

  }

  @Test
  void test06_insert_many_size() {
    String[] randoKey = {"1", "2", "3", "4", "5"};
    String[] randoVal = {"one", "two", "three", "four", "five"};

    for (int i = 0; i < 5; i++) {
      ds.insert(randoKey[i], randoVal[i]);
    }

    if (ds.size() != 5) {
      fail("Returned " + ds.size() + " instead of 5.");
    }
  }

  void test07_duplicate_values() {
    String key = "1";
    String value = "duplicate";
    String key2 = "2";
    ds.insert(key, value);
    ds.insert(key2, value);
    if (ds.size() != 2)
      fail("Failed to add duplicate value of " + value + ". Returned size of " + ds.size()
          + " instead of 2.");

  }

  @Test
  void test08_get_throws_exception() {
    String key = null;
    String value = "one";
    try {
      ds.insert(key, value);
      fail("Exception not thrown when key is null.");
    } catch (IllegalArgumentException e) {
    }


  }

  @Test
  void test09_get_correct_value() {
    String key = "1";
    String value = "one";
    String key2 = "2";
    String value2 = "two";

    ds.insert(key, value);
    ds.insert(key2, value2);
    ds.get(key2);
    if (!ds.get(key2).equals(value2)) {
      fail("Wrong value returned for " + key2 + ". Expected " + value2 + " but returned "
          + ds.get(key2));
    }
  }

  @Test
  void test10_contains_returns_true() {
    String key = "1";
    String value = "one";
    String key2 = "2";
    String value2 = "two";

    ds.insert(key, value);
    ds.insert(key2, value2);

    if (ds.contains(key2) != true) {
      fail("Contains did not detect the key");
    }
  }

  @Test
  void test11_contains_returns_false_for_nullkey() {
    String key1 = "1";
    String value1 = "one";
    String key = null;
    String keyCom = "1";

    ds.insert(key1, value1);

    if (ds.contains(key) != false && ds.contains(keyCom) != true) {
      fail("Contains method failed to return false when key is null or not found.");
    }


  }
}


// Tip: consider different numbers of inserts and removes and how different combinations of insert
// and removes

