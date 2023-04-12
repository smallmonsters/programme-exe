package hepler;

public class StaticLinkedList {
  private static final int MAXSIZE = 100;
  private final int[] data = new int[MAXSIZE];  // 存储静态链表中的节点数据
  private final int[] next = new int[MAXSIZE];  // 存储静态链表中的节点索引
  private int length = 0;  // 静态链表的长度
  private int head = -1;  // 静态链表的头结点

  // 添加节点到静态链表的尾部
  public void add(int val) {
    int index = length;
    data[index] = val;
    next[index] = -1;

    if (length == 0) {
      head = index;
    } else {
      next[length - 1] = index;
    }

    length++;
  }

  // 通过节点索引来获取对应的节点
  public int getNode(int pos) {
    if (pos < 0 || pos >= length) {
      throw new IllegalArgumentException("位置不合法");
    }

    int p = head;
    for (int i = 0; i < pos; i++) {
      p = next[p];
    }

    return data[p];
  }

  // 插入节点到指定位置
  public void insert(int val, int pos) {
    if (pos < 0 || pos >= length) {
      throw new IllegalArgumentException("插入位置不合法");
    }

    int index = length;
    for (int i = length - 1; i >= pos; i--) {
      data[i + 1] = data[i];
      next[i + 1] = next[i];
    }
    data[pos] = val;
    next[pos] = index;
    next[index] = next[pos + 1];
    next[pos + 1] = index;
    length++;
  }

  // 删除指定位置的节点
  public void delete(int pos) {
    if (pos < 0 || pos >= length) {
      throw new IllegalArgumentException("删除位置不合法");
    }

    if (pos == 0) {
      head = next[0];
    } else {
      next[pos - 1] = next[pos];
    }
    length--;
  }

  // 打印静态链表的元素
  public void printList() {
    int p = head;
    while (p != -1) {
      System.out.print(data[p] + " ");
      p = next[p];
    }
    System.out.println();
  }
}
