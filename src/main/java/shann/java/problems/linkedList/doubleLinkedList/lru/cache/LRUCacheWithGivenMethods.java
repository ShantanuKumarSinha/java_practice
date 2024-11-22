package shann.java.problems.linkedList.doubleLinkedList.lru.cache;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
*/
import java.util.HashMap;
import java.util.Map;
import shann.java.problems.linkedList.doubleLinkedList.utility.ListNode;
import shann.java.problems.linkedList.doubleLinkedList.utility.ListNodeForLRU;

public class LRUCacheWithGivenMethods {

  private int capacity;
  private Map<Integer, ListNodeForLRU> map;
  private ListNodeForLRU head = null;
  private ListNodeForLRU tail = null;

  public LRUCacheWithGivenMethods(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    head = new ListNodeForLRU(-1, -1);
    tail = new ListNodeForLRU(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public static void main(String[] args) {
    //    LRUCacheWithGivenMethods cache1 = new LRUCacheWithGivenMethods(1);
    //    cache1.set(2, 1);
    //    cache1.set(2, 2);
    //    System.out.println(cache1.get(2));
    //    cache1.set(1, 1);
    //    cache1.set(4, 1);
    //    System.out.println(cache1.get(2));

    //    LRUCacheWithGivenMethods cache2 = new LRUCacheWithGivenMethods(7);
    //    System.out.println(cache2.get(2));
    //    cache2.set(2, 6);
    //    System.out.println(cache2.get(1));
    //    cache2.set(1, 5);
    //    cache2.set(1, 2);
    //    System.out.println(cache2.get(1));
    //    System.out.println(cache2.get(2));

    LRUCacheWithGivenMethods cache2 = new LRUCacheWithGivenMethods(1);
    cache2.set(2, 1);
    System.out.println(cache2.get(2));
    cache2.set(3, 2);
    System.out.println(cache2.get(2));
    System.out.println(cache2.get(3));
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      var curr = map.get(key);
      removeNode(curr);
      insertAtLast(curr);
      return curr.val;
    }
    return -1;
  }

  public void set(int key, int value) {
    if (search(key)) {
      var curr = map.get(key);
      removeNode(curr);
      if(curr.val!=value)
        curr.val=value;
      insertAtLast(curr);
      map.put(key, curr);
    } else {
      if (map.size() == capacity) {
        var temp = head.next;
        removeNode(temp);
        map.remove(temp.key);
        var newTail = new ListNodeForLRU(key,value);
        insertAtLast(newTail);
        map.put(key, newTail);
      } else {
        var newTail = new ListNodeForLRU(key,value);
        insertAtLast(newTail);
        map.put(key, newTail);
      }
    }
  }

  private void insertAtLast(ListNodeForLRU temp) {
    var prev = tail.prev;
    tail.prev = temp;
    temp.next = tail;
    temp.prev = prev;
    prev.next = temp;
  }

  private void removeNode(ListNodeForLRU temp) {
    var prev = temp.prev;
    var next = temp.next;
    prev.next = next;
    next.prev = prev;
    temp.next = null;
    temp.prev = null;
  }

  private boolean search(int key) {
    return map.containsKey(key);
  }
}
