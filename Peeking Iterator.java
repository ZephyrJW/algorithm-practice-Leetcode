// Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

// Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

// Call next() gets you 1, the first element in the list.

// Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

// You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

// Hint:

// Think of "looking ahead". You want to cache the next element.
// Is one variable sufficient? Why or why not?
// Test your design with call order of peek() before next() vs next() before peek().
// For a clean implementation, check out Google's guava library source code.
// Follow up: How would you extend your design to be generic and work with all types, not just integer?


// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Integer nextCachedVal = null;
    private Iterator<Integer> iterator; //--1

    public PeekingIterator(Iterator<Integer> iterator) { //--2
        // initialize any member here.
        this.iterator = iterator;  // 1 = 2
        next(); // cache the next value if any
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextCachedVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer retVal = nextCachedVal;
        nextCachedVal = iterator.hasNext() ? iterator.next() : null;
        return retVal;
    }

    @Override
    public boolean hasNext() {
        return (nextCachedVal != null);
    }
}

//something about Iterator:
//Java中的Iterator功能比较简单，并且只能单向移动：

//　　(1) 使用方法iterator()要求容器返回一个Iterator。第一次调用Iterator的next()方法时，它返回序列的第一个元素。注意：iterator()方法是java.lang.Iterable接口,被Collection继承。

//　　(2) 使用next()获得序列中的下一个元素。

//　　(3) 使用hasNext()检查序列中是否还有元素。

//　　(4) 使用remove()将迭代器新返回的元素删除。
