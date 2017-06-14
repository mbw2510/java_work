package test.mypac;

public class MyBox<T>{
	private T item;
	
	public void set(T item){
		this.item=item;
	}
	public T get(){
		return item;
	}
}
