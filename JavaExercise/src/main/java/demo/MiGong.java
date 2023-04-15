package demo;


// 迷宫回溯问题 https://www.bilibili.com/video/BV1E4411H73v?p=45&vd_source=1a3e236d757ed516a67f8c9b0103998f
//https://juejin.cn/post/6844904158143709197
public class MiGong {
  int[][] map; // 地图 1: 墙 0: 路 2：节点走过 3：节点走过并且不通 4: 终点
  int[] start; // 起点
  int[] end; // 终点
  int rows;
  int cols;

  MiGong(int rows, int cols, int[] start, int[] end) {
    this.rows = rows;
    this.cols = cols;
    if (verifyAxis(start) && verifyAxis(end)) {
      initMap();
      this.start = start;
      this.end = end;
    } else {
      throw new IllegalArgumentException("起点或终点坐标不正确");
    }
  }

  public static void main(String[] args) {
    MiGong mg = new MiGong(8, 8, new int[]{1, 1}, new int[]{6, 5});
    MiGong mg1 = new MiGong(8, 8, new int[]{1, 1}, new int[]{6, 5});
    System.out.println("move地图 是否可以到达终点：" + mg.move(mg.start, Dire.down));
    for (int i = 0; i < mg.rows; i++) {
      for (int j = 0; j < mg.cols; j++) {
        System.out.printf(mg.map[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("getWay地图 是否可以到达终点：" + mg1.getWay(mg1.end[0], mg1.end[0]));
    for (int i = 0; i < mg1.rows; i++) {
      for (int j = 0; j < mg1.cols; j++) {
        System.out.printf(mg1.map[i][j] + " ");
      }
      System.out.println();
    }


  }

  //  采用 下->右->上->左的策略得出的结果
  public boolean move(int[] axis, Dire dire) {
    // 到达了终点
    if (axis[0] == end[0] && axis[1] == end[1]) {
      map[axis[1]][axis[0]] = 4;
      return true;
    }
    // 当前节点标记为走过
    map[axis[1]][axis[0]] = 2;
    if (verifyAxis(axis) && map[axis[1] + 1][axis[0]] == 0) {
      // 可以向下走
      axis[1] = axis[1] + 1;
      return move(axis, Dire.down);
    } else if (verifyAxis(axis) && map[axis[1]][axis[0] + 1] == 0) {
      // 可以向右走
      axis[0] = axis[0] + 1;
      return move(axis, Dire.right);
    } else if (verifyAxis(axis) && map[axis[1] - 1][axis[0]] == 0) {
      // 可以向上走
      axis[1] = axis[1] - 1;
      return move(axis, Dire.up);
    } else if (verifyAxis(axis) && map[axis[1]][axis[0] - 1] == 0) {
      // 可以向左走
      axis[0] = axis[0] - 1;
      return move(axis, Dire.left);
    } else {
      // 当前节点标记为走过不通
      map[axis[1]][axis[0]] = 3;
      if (axis[0] == start[0] && axis[1] == start[1]) return false;
      //回溯
      if (dire == Dire.down) {
        axis[1] = axis[1] - 1;
        return move(axis, Dire.right);
      } else if (dire == Dire.right) {
        axis[0] = axis[0] - 1;
        return move(axis, Dire.up);
      } else if (dire == Dire.up) {
        axis[1] = axis[1] + 1;
        return move(axis, Dire.left);
      } else {
        axis[0] = axis[0] + 1;
        return move(axis, Dire.down);
      }
    }
  }

  // 网友更好的递归方式
  public boolean getWay(int i, int j) {
    if (map[end[1]][end[0]] == 2) {
      map[end[1]][end[0]] = 4;
      return true;
    } else if (map[i][j] == 0) {
      map[i][j] = 2;
      if (getWay(i + 1, j)) {
        return true;
      } else if (getWay(i, j + 1)) {
        return true;
      } else if (getWay(i - 1, j)) {
        return true;
      } else if (getWay(i, j - 1)) {
        return true;
      } else {
        map[i][j] = 3;
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * 检查节点是否在地图中
   *
   * @param axis 坐标
   * @return boolean true: 在；false：不在
   */
  public boolean verifyAxis(int[] axis) {
    return axis[0] > 0 && axis[0] < cols - 1 && axis[1] > 0 && axis[1] < rows - 1;
  }


  /**
   * 是否到达了边界
   *
   * @param axis 轴
   * @return boolean false: 到达了不能在这个方向继续前进；true：没有到达了 继续前进
   */
  public boolean arriveBoundary(int[] axis) {
    return axis[0] > 1 && axis[0] < cols - 2 && axis[1] > 1 && axis[1] < rows - 2;
  }

  public void initMap() {
    // rows*cols的一个地图
    map = new int[rows][cols];
    // 上下两边加墙
    for (int i = 0; i < cols; i++) {
      map[0][i] = 1;
      map[rows - 1][i] = 1;
    }
    // 左右两边加墙
    for (int i = 0; i < rows; i++) {
      map[i][0] = 1;
      map[i][cols - 1] = 1;
    }
    // 设置地图中间的墙
    map[3][1] = 1;
    map[3][2] = 1;
    map[5][3] = 1;
    map[5][4] = 1;
    map[5][5] = 1;

  }

  public enum Dire {
    down, right, left, up
  }
}
