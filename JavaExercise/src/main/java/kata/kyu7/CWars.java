package kata.kyu7;

import kata.common.Kata;

/**
 * https://www.codewars.com/kata/55968ab32cf633c3f8000008/java
 * <p>
 * initials('code wars') => returns C.Wars
 * initials('Barack Hussain obama') => returns B.H.Obama
 */

public class CWars extends Kata {
  public static String initials(String name) {
    String otherName = name.replaceAll("([^\\s])[^\\s]+", "$1").toUpperCase();
    String lastName = name.replaceAll("[\\w\\s]+[\\s][\\w]([\\w]+$)", "$1");
    String fullName = otherName + lastName;
    return fullName.replaceAll(" ", ".");
  }

  public static String initialsBySelf(String name) {
    String[] strArr = name.split(" ");
    String str = "";
    for (int i = 0; i < strArr.length; i++) {
      String item = strArr[i];
      if (i == strArr.length - 1) {
        str = str + item.substring(0, 1).toUpperCase() + item.substring(1);
        break;
      }
      str = str + item.substring(0, 1).toUpperCase() + ".";
    }

    return str;
  }

  public static void test() {
    System.out.printf(CWars.initialsBySelf("Barack Hussain obama"));
    System.out.print("1111111111111111");
  }
}
