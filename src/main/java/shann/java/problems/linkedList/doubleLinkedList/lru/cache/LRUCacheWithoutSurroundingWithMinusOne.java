package shann.java.problems.linkedList.doubleLinkedList.lru.cache;

import static shann.java.problems.linkedList.doubleLinkedList.utility.DoubelLinkedListUtilityClass.printNextValuesFromDoubelLinkedListUtilityClass;
import static shann.java.problems.linkedList.doubleLinkedList.utility.DoubelLinkedListUtilityClass.printPreviousValuesFromDoubelLinkedListUtilityClass;

import java.util.HashMap;
import java.util.Map;
import shann.java.problems.linkedList.doubleLinkedList.utility.ListNode;

public class LRUCacheWithoutSurroundingWithMinusOne {
  Map<Integer, ListNode> map = new HashMap<>();
  ListNode head = null;
  ListNode tail = null;

  public static void main(String[] args) {
    int capacity = 3;
    LRUCacheWithoutSurroundingWithMinusOne lruCache = new LRUCacheWithoutSurroundingWithMinusOne();
    lruCache.add(capacity, 2);
    lruCache.add(capacity, 3);
    lruCache.add(capacity, 4);
    lruCache.add(capacity, 5);
    lruCache.add(capacity, 6);
    lruCache.add(capacity, 4);

    printNextValuesFromDoubelLinkedListUtilityClass(lruCache.head);
    printPreviousValuesFromDoubelLinkedListUtilityClass(lruCache.tail);
  }

  private void add(int capacity, int key) {
    if (search(key)) {
      var curr = map.get(key);
      remove(curr);
      ListNode newNode = new ListNode(key);
      insertAtLast(newNode);
      map.put(key, newNode);
    } else {
      if (map.size() == capacity) {
        var temp = head;
        remove(temp);
        map.remove(temp.val);
        var newNode = new ListNode(key);
        insertAtLast(newNode);
        map.put(key, newNode);
      } else {
        var newNode = new ListNode(key);
        insertAtLast(newNode);
        map.put(key, newNode);
      }
    }
  }

  private boolean search(int key) {
    return map.containsKey(key);
  }

  private void remove(ListNode temp) {
    if (temp == head) {
      head = head.next;
      head.prev = null;
      temp.next = null;
    } else {
      var prev = temp.prev;
      var next = temp.next;
      prev.next = next;
      next.prev = prev;
      temp.next = null;
      temp.prev = null;
    }
  }

  private void insertAtLast(ListNode newNode) {
    if (tail == null) {
      tail = newNode;
      head = newNode;
      } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
  }
}
