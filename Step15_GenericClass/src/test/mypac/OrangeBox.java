package test.mypac;

public class OrangeBox {
	private Orange orange;
	
	public void push(Orange orange){
		this.orange=orange;
	}
	public Orange pull(){
		return orange;
	}
	
}
