// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

//inspired by @ alderith and @Todd2 , difference : actually this is to find 1 and count
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}

//you need to read a java book , by @ hello_today_  --however,this is to go through the 1-or-0
public int hammingWeight(int n) {
    int x = 0;
    while (n != 0) {
       x += (n & 1);
       n = n >>> 1;
    }
    return x;
}

//addtional knowledge : 
//1.>> 右移运算符 >>>无符号右移 移动n位，表示除以2的n次方

// 2.对于：&   -- >  不管怎样，都会执行"&"符号左右两边的程序
//   对于：&& -- >  只有当符号"&&"左边程序为真(true)后，才会执行符号"&&"右边的程序。

//3. & 与运算符   | 或运算符  ~ 非运算符   ^ 异或运算符：两个操作数的位中，相同则结果为0，不同则结果为1。

