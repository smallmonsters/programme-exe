/**
 * 实现一个addStaticMethod函数，它接受一个类(例如:Test)、一个名称(例如:'foo')和一个方法(函数)
 * 作为参数。它将把方法引用添加到具有指定名称的类中，作为其静态方法之一。
 * 添加的静态方法应该能够被类及其实例调用，就像在Java中所发生的一样。
 *
 * examples
 *        function Test() {
 *           this.value = 9;
 *         }
 *        var o = new Test();
 *         addStaticMethod(Test, 'foo', () => this.value);
 *         o = new Test();
 *         Test.value = 8;
 *         o.value; // 9
 *         Test.foo() => 8;
 *         o.foo() => 8;
 *
 * 
 * https://www.codewars.com/kata/561aca76c3e5e0156000001d/train/javascript
*/

//  answer
function addStaticMethod(constructor, name, method) {
  constructor[name] = constructor.prototype[name] = method.bind(constructor)
}