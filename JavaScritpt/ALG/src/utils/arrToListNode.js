export function arrToListNode(arr) {
  if (arr.length === 1) return {val: arr[0], next: null}
  return {val: arr[0], next: arrToListNode(arr.slice(1, arr.length))}
}

export function listNodeToArray(listNode) {
  debugger
  let arr = []
  while (listNode) {
    arr.push(listNode.val)
    listNode = listNode.next
  }
  return arr
}
