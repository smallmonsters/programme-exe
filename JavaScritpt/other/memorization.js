/**
 *使用memorization优化递归  
 *
 */
function memorization(fn){
  let cache={}
  return function(key) {
    if(!cache[key])cache[key]=fn.apply(this,arguments)
    return cache[key]
  }
}

function cumulative(number) {
  if(number===1)return 1
  return number+cumulative(--number)
}
function cumulativeOptimize(number) {
  console.log("a");
  if(!cumulativeOptimize.cache)cumulativeOptimize.cache={1:1}
  if(cumulativeOptimize.cache[number])return cumulativeOptimize.cache[number]||1
  cumulativeOptimize.cache[number]=number+cumulativeOptimize(--number)
  console.log( cumulativeOptimize.cache);
  return  cumulativeOptimize.cache[number]
}
console.log(cumulativeOptimize(4));
console.log(cumulativeOptimize(6));