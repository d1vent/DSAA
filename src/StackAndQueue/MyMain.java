package StackAndQueue;

public class MyMain {
    public static void main(String[] args) {
        MyArrayStack myStack = new MyArrayStack(3);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.show();

        myStack.pop();
        myStack.show();
        myStack.pop();
        myStack.show();
        myStack.pop();
        myStack.show();
        myStack.pop();
        myStack.show();

        MyArrayQueue queue = new MyArrayQueue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.show();

        queue.pop();
        queue.show();
        queue.pop();
        queue.show();
        queue.pop();
        queue.show();

        MyLinkedListStack stack = new MyLinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.show();

        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();

        MyLinkedListQueue llqueue = new MyLinkedListQueue();
        llqueue.push(1);
        llqueue.push(2);
        llqueue.push(3);
        llqueue.show();

        System.out.println(llqueue.pop());
        llqueue.show();
        System.out.println(llqueue.pop());
        llqueue.show();
        System.out.println(llqueue.pop());
        llqueue.show();
    }
}
