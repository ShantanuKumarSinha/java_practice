package shann.java.problems;

import java.util.Arrays;

class TestMap {
  public static void main(String[] args) {
    MyHashMap<Integer, String> map = new MyHashMap<>();
    map.put(1, "Shantanu Kumar");
    System.out.println(map);
  }
}

public class MyHashMap<K, V> {

  private Entry[] entrySet = new Entry[16];
  private int count = 0;

  public MyHashMap() {}

  public MyHashMap(int count) {
    this.count = count;
  }

  public V put(K k, V v) {
    var prevVal = get(k);
    entrySet[count] = new Entry(k, v);
    return prevVal;
  }

  public V get(K k) {
    if (count > 0) {
      for (Entry entry : entrySet) {
        if (entry.getK().equals(k)) return (V) entry.getV();
      }
    }
    return null;
  }

  static class Entry<K, V> {
    K k;
    V v;

    Entry(K k, V v) {
      this.k = k;
      this.v = v;
    }

    public V getV() {
      return v;
    }

    public K getK() {
      return k;
    }

    @Override
    public String toString() {
      return "Entry{" + "k=" + k + ", v=" + v + '}';
    }
  }

  @Override
  public String toString() {
    return "MyHashMap{" + "entrySet=" + Arrays.toString(entrySet) + '}';
  }
}
