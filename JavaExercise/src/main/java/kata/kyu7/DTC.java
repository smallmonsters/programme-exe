package kata.kyu7;

import java.text.DecimalFormat;

//https://www.codewars.com/kata/6397b0d461067e0030d1315e/java
public class DTC {


  /**
   * 将一个正常的时间1:45转换十进制 1.75
   *
   * @param time 时间
   * @return double
   */
  public static double toIndustrial(String time) {
    String[] split = time.split(":");
    double v = Double.parseDouble(split[0]) + Double.parseDouble(split[1]) / 60.0;
    DecimalFormat df = new DecimalFormat("#.##");
    String roundedNum = df.format(v);
    return Double.parseDouble(roundedNum);
  }

  /**
   * 将一个表示分钟的十进制105转换十进制 1.75
   *
   * @param time 时间
   * @return double
   */
  public static double toIndustrial(int time) {
    DecimalFormat df = new DecimalFormat("#.##");
    String roundedNum = df.format((double) time / 60.0);
    return Double.parseDouble(roundedNum);
  }

  /**
   * 将一个十进制 1.75转换正常的时间1:45
   *
   * @param time 时间
   * @return {@link String}
   */
  public static String toNormal(double time) {
    int hour = (int) Math.floor(time);
    long min = Math.round((time - hour) * 60);
    return hour + ":" + (min < 10 ? "0" + min : min);
  }
}
