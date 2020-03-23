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


function Maze(maze) {
  // 二维地图
  this.maze = []
  // 地图边界
  this.boundary = [0, 0]
  // 当前坐标
  this.x = 0
  this.y = 0
  // 线路
  this.circuit = new Map()
  this.init = () => {
    this.circuit.set(this.x + this.y, {
      up: true,
      left: true,
      right: false,
      donw: false,
    })
    maze.split(/\n/).forEach((v, i) => {
      if (v !== "") {
        if (!this.maze[i]) this.maze[i] = []
        this.maze[i] = v.split("")
      }
    });
    this.boundary[0] = this.maze.length
    this.boundary[1] = this.maze[0].length
  }
  this.moveL = () => this.y = this.y - 1
  this.moveD = () => this.x = this.x + 1
  this.moveR = () => this.y = this.y + 1
  this.moveU = () => this.y = this.y - 1
  this.hasWalk = () => {
    const down = this.x + 1 === this.boundary[0] || this.maze[this.x][this.y + 1] === "W"
    const left = this.y === 0 || this.maze[this.x][this.y - 1] === "W"
    const up = this.x === 0 || this.maze[this.x - 1][this.y] === "W"
    const right = this.y + 1 === this.boundary[1] || this.maze[this.x][this.y + 1] === "W"
    return left || right || down || up
  }
  // 判断一个点是否可以移动
  hasExit = (point, to) => {
    if (this.circuit.has(point)) {
      const { left, up, down, right } = this.circuit.get(point)
      return left, up, down, right
    } else {
      this.circuit.set(point, {
        up: to === "up",
        left: to === "left",
        right: to === "right",
        down: to === "down",
      })
    }
  }
  // 接受一个移动方向,规定先向下移动，然后逆时针旋转，既下=》右=》上=》左
  this.start = (to = "down") => {
    if (this.y + 1 === this.boundary[1] && this.x + 1 === this.boundary[0]) return true
    const point = this.x + this.y
    if (this.hasExit(point)) {

    }
    // if (this.x + 1 < this.boundary[0] && to === "down") {
    //   this.moveD()
    //   if (this.hasWalk()) return this.start("left")
    //   return false
    // }
    // if (this.y + 1 < this.boundary[1] && to === "right") {
    //   this.moveR()
    //   if (this.hasWalk()) return this.start("up")
    //   return false
    // }
    // if (this.y - 1 >= 0 && this.y === this.boundary[1] && to === "left") {
    //   this.moveL()
    //   if (this.hasWalk()) return this.start()
    //   return false
    // }
  }
  this.init()
}
function pathFinder(maze) {
  let mazes = new Maze(maze)
  console.log(mazes.start())
  return mazes.start()
}
pathFinder(maze)