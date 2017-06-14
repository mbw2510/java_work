package showmethemoney;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.qt.datapicker.DatePicker;

public class MainFrame extends JFrame implements ActionListener{
	//멤버필드 정의하기
	JTextField inputHeight, inputWeight, inputName;
	DefaultTableModel model;
	JButton saveBtn, deleteBtn, updateBtn;
	JTable table;
	int ispig;
	float divider;
	float divider2;
	float bmi;
	
	

	
	List<Map<String, Object>> members;
	
	//생성자
	public MainFrame(){
		makeUI();
	}
	//메소드
	public void makeUI(){
		//레이아웃 설정
		setLayout(new BorderLayout());
		//상단 패널 객체 생성
		JPanel topPanel=new JPanel();
		
		//
		setTitle("주 단위 돼지율 검사");
		
		//레이블 객체 생성
		JLabel label1=new JLabel("신장");
		JLabel label2=new JLabel("몸무게");
		JLabel label3=new JLabel("이름");
		
		//텍스트 필드 객체 생성
		inputHeight=new JTextField(10);
		inputWeight=new JTextField(10);
		inputName=new JTextField(10);
		
		//버튼객체 생성
		saveBtn=new JButton("저장");
		deleteBtn=new JButton("삭제");
		updateBtn=new JButton("수정");
		
		//버튼 리스너 등록 
		saveBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);		
		
		//페널에 컴포넌트 추가 하기 
		topPanel.add(label1);
		topPanel.add(inputHeight);
		topPanel.add(label2);
		topPanel.add(inputWeight);
		topPanel.add(label3);
		topPanel.add(inputName);
		topPanel.add(saveBtn);
		topPanel.add(deleteBtn);
		topPanel.add(updateBtn);
		
		//프레임의 상단에 페널 배치하기
		add(topPanel, BorderLayout.NORTH);	
		
		//테이블 칼럼명
		String[] colNames={"무게", "신장", "이름","돼지율","날짜"};
		//테이블에 연결할 모델 객체 
		model=new DefaultTableModel(colNames, 0);
		
		//테이블 객체 생성
		table=new JTable();		
		//테이블에 모델 연결
		table.setModel(model);
		
		//스크롤 할수 있는 UI 로 테이블을 감싼다. 
		JScrollPane tablePanel=new JScrollPane(table);
		
		add(tablePanel, BorderLayout.CENTER);
		
		//가로 세로 크기 지정하기 
		setSize(800, 500);
		//화면의 가운데 배치 되도록
		setLocationRelativeTo(null);
		setVisible(true);
		// 창 닫을때 프로세스 종료 되도록 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//파일에 있는 정보 로딩하기
		loadFromFile();
		//로딩된 정보 출력하기 
		displayTable();		
		
	}
	
	//멤버필드의 List에 담긴 내용을 파일에 저장하는 메소드
	public void saveToFile() {
		//파일에 출력해서 영구 저장한다.
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		try {
			//FileOutputStream 의 경로를 지정한다.
			fos=new FileOutputStream("c:/myFolder/MyMembers2.dat");
			//객체 정보를 출력할 수 있는 객체 생성하기
			oos=new ObjectOutputStream(fos);
			//List 객체 출력하기
			oos.writeObject(members);
			oos.flush();
//			Map details = members.get(0);
//			int a = Integer.parseInt(details.get(inputHeight).toString());
//			int b = Integer.parseInt(details.get(inputWeight).toString());
//			System.out.println(a);
//			System.out.println(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(fos!=null)fos.close();
				if(oos!=null)fos.close();
			}catch(Exception e){}
		}
	}
	
	public void loadFromFile() {
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try{
			fis=new FileInputStream("c:/myFolder/MyMembers2.dat");
			ois=new ObjectInputStream(fis);
			//원래 type 으로 casting 해서 필드에 저장한다. 
			members=(List)ois.readObject();
		}catch(FileNotFoundException fne){
			//파일을 만든적이 없다면 FileNotFoundException 발생
			members=new ArrayList<>();
			System.out.println("MyMembers2.dat 파일이 없음");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fis!=null)fis.close();
				if(ois!=null)ois.close();
			}catch(Exception e){}
		}
	}
	
	public void displayTable() {
		//table 에 출력된 내용 삭제 되도록
		model.setRowCount(0);
		
		for(Map<String, Object> tmp:members){
			float weight=(float)tmp.get("weight");
			float height=(float)tmp.get("height");
			String name=(String)tmp.get("name");
			float bmi=(float)tmp.get("pig");
			String day=null;
			//System.out.println(num+"/"+name+"/"+addr);
			//회원정보를 Object[] 에 순서대로 담은 다음
			Object[] row=new Object[5];
			row[0]=weight;
			row[1]=height;
			row[2]=name;
			row[3]=bmi;
			row[4]=null;
			//테이블에 연결된 모델에 전달한다. 
			model.addRow(row);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//메인메소드
	public static void main(String[] args) {
		new MainFrame();
	}
	//액션리스너
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saveBtn){
			//TextField에 입력한 내용을 읽어온다.
			float height = Float.parseFloat(inputHeight.getText());
			float weight = Float.parseFloat(inputWeight.getText());
			String name = inputName.getText();
			
			divider=(float)(height*0.01);
			divider2=divider*divider;
			bmi = weight/divider2;
			
			System.out.println(bmi);
			if(bmi<20){
				JOptionPane.showMessageDialog(this, "돼지처럼 먹어라.");
			}else if(bmi>=20&&bmi<=24){
				JOptionPane.showMessageDialog(this, "좋겠다.");
			}else if(bmi>=25&&bmi<=30){
				JOptionPane.showMessageDialog(this, "돼지가 되어가는게 보여.");
			}else if(bmi>30){
				JOptionPane.showMessageDialog(this, "돼지.");
			}			
			
			//HashMap 객체에 회원의 정보를 담아보자
			Map<String, Object> map=new HashMap<>();
			map.put("height", height);
			map.put("weight", weight);
			map.put("name",name);
			map.put("pig", bmi);
			
			System.out.println(height);
			System.out.println(weight);
			
			//ArrayList객체에 회원 한명의 정보를 담는다.
			members.add(map);
			saveToFile();
			//알림창 띄우기
			
			//빈칸으로 만들기
			inputHeight.setText("");
			inputWeight.setText("");
			inputName.setText("");
			
		
			
		}else if(e.getSource() == deleteBtn){
			//선택된 table row 의 인덱스를 읽어온다.
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1){// 선택된 row 가 없다면
				JOptionPane.showMessageDialog
					(this, "삭제할 row 를 선택하세요");
				return; //메소드 끝내기 
			}
			//List 에서 해당 인덱스 삭제
			members.remove(selectedIndex);
			//MyMembers2.dat 파일에도 반영
			saveToFile();
			JOptionPane.showMessageDialog(this, "삭제했습니다.");			
		}else if(e.getSource() == updateBtn){
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1){
				JOptionPane.showMessageDialog(this, "수정할 row를 선택하세요");
			}
			//수정할 이름과 주소를 읽어온다.
			//table.getValueAt(row index, column index)
			String name=(String)table.getValueAt(selectedIndex, 1);
			String addr=(String)table.getValueAt(selectedIndex, 2);
			//List의 데이터를 수정한다.
			members.get(selectedIndex).put("name", name);
			members.get(selectedIndex).put("addr", addr);
			saveToFile();		
		}
		//파일에 있는 정보 로딩하기
		loadFromFile();
		//로딩된 정보 출력하기 
		displayTable();
	}	
}
