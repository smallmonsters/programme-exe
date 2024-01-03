export function numPrecision(num1, num2, symbol = '+') {
  const symbolMap = {
    '+': (a, b) => (a * 1000 + b * 1000) / 1000,
    '-': (a, b) => (a * 1000 - b * 1000) / 1000,
    '*': (a, b) => ((a * 1000) * (b * 1000)) / 1000 / 1000,
    '/': (a, b) => ((a * 1000) / (b * 1000))
  };
  return symbolMap[symbol](num1, num2);
}
