package client;
public class Stack {
    //Object
    private Object S[];
    private int index=-1;
    String K="";
    
    public Stack(){
        this(10);
    }
    public Stack(int cap){
        S=new Object[cap];
    }

    public int size(){
        return index+1;
    }
    public boolean isEmpty(){
        return index==-1;
    }
    public boolean isFull( ){
        return index==S.length-1; 
    }

    public Object top( ) {
        if (isEmpty()){
            System.out.println("stack is empty");
        }
        return S[index];
    }
    public void push(Object item) {
        if (isFull()){
            System.out.println("stack oneflow");
        }
        index++;
        S[index]=item;
    }
    public Object pop( ) {
        Object element;
        if (isEmpty()){
            System.out.println("stack is empty");
        }
        element=S[index];
        S[index]=null;
        index--;
        return element;
    }    
}
