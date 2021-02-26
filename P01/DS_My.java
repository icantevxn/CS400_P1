// TODO: Add file header here



// TODO: Add class header here
public class DS_My implements DataStructureADT<String, String> {

  // TODO may wish to define an inner class
  // for storing key and value as a pair
  // such a class and its members should be "private"
  private class KV_pair {
    private String key="";
    private String value="";

    private KV_pair(String key, String value) {
      this.key = key;
      this.value = value;
    }

    private String getKey() {
      return this.key;
    }

    private String getValue() {
      return this.value;
    }

  }

  // Private Fields of the class
  // TODO create field(s) here to store data pairs
  private int count = 0;
  private int size = 1000000;
  private KV_pair[] pair;


  public DS_My() {
    this.pair = new KV_pair[size];

  }

  @Override
  public void insert(String key, String value) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }

    if (contains(key)) {
      throw new RuntimeException("duplicate key");
    }

    KV_pair item = new KV_pair(key, value);
    KV_pair[] temp = pair;
    if (count == (size - 1)) {
      size = size * 2;
      pair = new KV_pair[size];
    }
    pair[0] = item;
    for (int i = 1; i < count; i++) {
      for (int j = 0; j < temp.length; j++) {
        pair[i] = temp[j];
      }
    }
    count++;

  }


  @Override
  public boolean remove(String key) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }
    if (count == 0) {
      return false;
    }
    KV_pair temp[] = new KV_pair[size - 1];
    for (int i = 0, j = 0; i < count; i++) {
      if (!pair[i].getKey().equals(key)) {
        temp[j++] = pair[i];
      } else {
        count--;
        return true;
      }
    }
    return false;

  }

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

  @Override
  public boolean contains(String key) {
    if (key == null) {
      throw new IllegalArgumentException("null key");
    }
    if (pair == null) {
      return false;
    }
    for (int i = 0; i < count; i++) {
      if (pair[i].getKey().equals(key)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int size() {
    return count;
  }


}
