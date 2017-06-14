package test.mypac;

public class FruitBox<T> {
	private T fruit;
	
	public void push(T fruit){
		this.fruit=fruit;
	}
	public T pull(){
		return fruit;
	}
}
