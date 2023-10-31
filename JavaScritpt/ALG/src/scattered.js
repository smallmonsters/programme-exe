// 从数组中找到重复的数
export const demo = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < i; j++) {
      if (arr[i] === arr[j]) return arr[i]
    }
  }
}

// 不使用Array原生方法，实现数组中间插入
export const inset = (index, num, arr) => {
  // js不用考虑扩容问题
  if (index > arr.length) return arr[index] = num
  for (let i = arr.length - 1; i >= 0; i--) {
    arr[i + 1] = arr[i]
    if (index === i) {
      arr[i] = num
      break
    }
  }
  return arr;
}
// better
export const inset2 = (index, num, arr) => {
  if (index > arr.length) return arr[index] = num
  for (let i = arr.length - 1; i >= index; i--) {
    arr[i + 1] = arr[i]
  }
  arr[index] = num
  return arr;
};

// 不使用Array原生方法，实现数组删除
export const deleteArr = (index, arr) => {
  for (let i = index; i < arr.length; i++) {
    arr[i] = arr[i + 1]
  }
  arr[arr.length - 1] = undefined
  return arr
}
