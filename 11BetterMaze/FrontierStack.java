public class FrontierStack<T> extends MyStack<T> implements Frontier<T>{
    public void add(T element){
	push(element);
    }
    public T next(){
	return pop();
    }
    public boolean hasNext(){
	return size()!=0;
    }
    public static void main(String[]args){
	FrontierStack<Integer> n = new FrontierStack<Integer>();
	n.add(23);
	n.add(1234);
	System.out.println(n.next());
	System.out.println(n.hasNext());
    }
}
