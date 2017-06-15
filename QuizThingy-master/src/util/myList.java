package util;

import java.util.HashMap;

public class myList<V>{
	private HashMap<Integer, V> list;
	
	public myList(){
		list=new HashMap<Integer, V>();
	}
	
	public void add(V item){
		list.put(list.size(), item);
	}
	
	public V get(int index){
		return list.get(index);
	}
	
	public void clear(){
		list.clear();
	}
	
	public void remove(int index){
		list.remove(index);
	}
	
	public boolean check(V item){
		return list.containsValue(item);
	}
	
	public int size(){
		return list.size();
	}
}
