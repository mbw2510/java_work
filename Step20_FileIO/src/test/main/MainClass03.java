package test.main;

import java.io.File;

public class MainClass03 {
	public static void main(String[] args) {
		String path="c:/";
		File file=new File(path);
		
		//c:/ 에 어떤 폴더와 어떤 파일이 존재하는지 목록을 콘솔창에 출력해보세요.
		String[] a = file.list(); 
		
		//file객체 목록을 얻어온다.
		File[] b = file.listFiles();
		for(int i = 0; i<a.length; i++){
//			String lfolder = a[i];
//			System.out.println(lfolder);
			File lfile=b[i];
			System.out.println(lfile);
		}
		//반복문 돌면서 FIle 객체의 참조값을 하나씩 배내서
		for(File tmp:b){
			//파일 혹은 디렉토리의 이름을 읽어온다.
			String name = tmp.getName();
			if(tmp.isDirectory()){
				//디렉토리면 [d]를 표시해서 확인이 쉽도록한다.
				System.out.println("[d] "+name);
			}else{
				System.out.println(name);
			}
		}
		
	}
}
