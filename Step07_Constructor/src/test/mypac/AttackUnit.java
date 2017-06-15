package test.mypac;

public class AttackUnit { // Class 명은 관례상 대문자로 시작
   
   // 일반 멤버필드 // Field 명은 관례상 영문자 소문자로 시작
   public int energy; //public : 접근 지정자 , int : 데이터 타입 , energy : 필드명 
   // public int energy = 0; // int type은 초기화 시켜주지 않아도 기본적으로 0 이 들어가 있어. (멤버 필드의 경우에)
   public String name; // String type의 id 값을 담을수 있는 field 
   // public String name = null; // 참조 데이터 타입은 초기화 시켜주지 않아도 null 로 초기화 되어 있어. (멤버 필드의 경우에)
   
   
   // 인자로 아무것도 전달 받지 않는 default 생성자1
   public AttackUnit(){ // 클래스 명과 같고 return 되는 data type 이 없으니 생성자
      
   }
   // 인자로 int type data 를 전달받는 생성자2
   public AttackUnit(int energy){ // 접근지정자, 클래스명, (데이터타입, 지역변수명)
      this.energy=energy; // 멤버 필드에 저장할거라면 지역변수명도 멤버필드명과 같이 지정해
   }
   
   //this 생성된 객체의 해당 id의 참조값
   
   // 인자로 String type data 를 전달받는 생성자3
   public AttackUnit(String name){
      this.name=name;
   }
   // 인자로 int type과 String type 을 전달 받아서 멤버필드에 저장하는 생성자를 정의해 보세요
   public AttackUnit(int energy, String name){
      this.energy=energy;
      this.name=name;
   }
   
   
   // 일반 멤버 메소드
   public void attack(){ // 접근지정자, 리턴타입, 메소드명
      System.out.println("공격해요~!!!!");
   }
   
   /*
    * Field 와 메소드에 한해서 static 이 붙을수도 있음.
    */
}