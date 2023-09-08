let numbers = [2,1,3,4,1];
let newNumbers = [];

for(let i = 0 ; i < numbers.length-1; i++)
    for(let j=i+1; j < numbers.length; j++)
        newNumbers.push(numbers[i] + numbers[j]);

newNumbers = new Set(newNumbers);
console.log(newNumbers);
console.log([...newNumbers].sort());