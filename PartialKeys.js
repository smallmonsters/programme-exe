/**
 * 您需要创建一个函数，该函数接受一个对象作为参数，并返回一个非常类似的对象，但具有一个特殊的属性。
 * 返回的对象应该允许用户通过只提供他们想要的值的键的开头来访问值。
 * 例如，如果给定的对象有一个键idNumber，那么您应该能够使用一个键idNum甚至简单的id来访问它在返回对象上的值。
 * Num和Number不应该起作用，因为我们只在键的开头查找匹配项。
 * 请注意，您可以简单地将所有这些部分键一个接一个地添加到对象中。
 * 但是，为了避免混乱，我们不希望JSON有一堆无意义的键。
 * 因此，在随机测试中将有一个测试来检查您是否没有从传入的对象或返回的对象中添加或删除任何键。
 * 同样,如果一个关键测试开始出现原始对象的多个关键
 * (例如,如果原来的对象有一个关键idNumber idString和我们想要测试的关键id)
 * 然后用哪个键是返回值对应的第一个字母顺序排列。
 * (在本例中，它应该是idNumbers值，因为它是按字母顺序排在前面的。)
 * 
 * examples
 *    let subject=partialKeys({aaa: 1,abc: 2,dfg: 3,def: 4,dfgh: 5})
 *        subject.a===1
 *        subject.aa===1
 *        subject.ab===2
 *        subject.df===3
 *        subject.d===4
 *        subject.de===4
 *        subject.dfg===3
 *        subject.dfgh===5
 *        subject.b===undefined
 *        subject.c===undefined
 *        subject.ef===undefined
 * 
 * 
 * https://www.codewars.com/kata/5e602796017122002e5bc2ed/train/javascript
 * */

//  my answer
function partialKeys(obj) {
  const keys = Object.keys(obj).sort()
  let handler = {
    get: (target, name) => {
      let value = undefined
      const reg = new RegExp(`^${name}`)
      for (let i = 0; i < keys.length; i++) {
        if (reg.test(keys[i])) {
          value = target[keys[i]]
          break
        }
      }
      return value
    }
  }
  const newObj = new Proxy(obj, handler)
  return newObj
}
// better anwer

function partialKeys (obj) {
  let keys = Object.keys(obj).sort();
  const obj1 = new Proxy(obj, {
    get: function(target, name, receiver) {
        if (!(name in target)) {
            let regEx = new RegExp('^' + name)
            let key = keys.find(element => regEx.test(element))
            return key === undefined ? undefined : Reflect.get(target, key, receiver);
        }
        return Reflect.get(target, name, receiver);
    }
});
return obj1;
}


a = partialKeys({
  aaa: 1,
  abc: 2,
  dfg: 3,
  def: 4,
  dfgh: 5
})
