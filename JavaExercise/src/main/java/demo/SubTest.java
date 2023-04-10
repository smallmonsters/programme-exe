package demo;

public class SubTest extends Test {
  @Override
  public Sub returnParent() {
    return new Sub();
  }
}
