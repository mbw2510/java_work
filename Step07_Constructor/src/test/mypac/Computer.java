package test.mypac;

public class Computer {
	public Cpu cpu;
	public Memory memory;
	public HardDisk hardDisk;
	
	public Computer(Cpu cpu,Memory memory,HardDisk hardDisk){
		this.cpu=cpu;
		this.memory=memory;
		this.hardDisk=hardDisk;				
	}
	//Cpu, Memory, HardDisk type 데이터를 전달받는 생성자 정의
	//default 생성자가 정의 되지않고 정의된 것이 있을때는 default 생성자가 없다라고 본다.
	
}
