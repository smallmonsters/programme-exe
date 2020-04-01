/**
 * 你在迷宫NxN的位置[0,0]，你只能在四个主要方向(即北、东、南、西)中的一个方向移动。
 * 如果可以到达位置[N-1, N-1]，则返回true，否则返回false。
 * 空位置被标记 .
 * 墙位置被标记 W
 * examples
 * testMaze(true,`.W.
 *                .W.
 *                ...`);
 * testMaze(false,`.W.
 *                 WW.
 *                 ...`);
 * 
 * testMaze(false,`......
 *                 ......
 *                 ......
 *                 ......
 *                 .....W
 *                 ....W.`);
 *     
 * 
 * https://www.codewars.com/kata/5765870e190b1472ec0022a2/train/javascript
 * */

const maze = `....W.
......`



function pathFinder(maze) {
  maze = maze.split('\n').map(r => {
    return [...r]
  });
  var len = maze.length, stack = [[0, 0]];
  while (stack.length) {
    let [x, y] = stack.pop();
    let a = maze[y][x]
    if (maze[y][x] !== '.') continue;
    maze[y][x] = 'X';
    [[x, y - 1], [x, y + 1], [x - 1, y], [x + 1, y]].filter(([i, j]) => i >= 0 && j >= 0 && i < len && j < len).forEach(([i, j]) => stack.push([i, j]));
  }
  return maze[len - 1][len - 1] === 'X';
}
pathFinder(maze)