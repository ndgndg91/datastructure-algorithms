package dataStructure;

public class MyQueue {
    private int[] queue;
    private int current;
    private int maxSize;
    private static final int increment = 10;

    public MyQueue() {
        this.queue = new int[increment];
        this.maxSize = increment;
        this.current = maxSize - 1;
    }

    public void offer(int element){
        if (current == 0){

        } else {
            queue[current--] = element;
        }
    }

    public int poll(){
        return queue[current+1];
    }


    public static void main(String[] args){

    }
}
