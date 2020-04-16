package java9.tryresources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudyTryResources {
	public void java7before () {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void java7after() throws FileNotFoundException {
		// 리소스를 자동관리 한다. 더 이상 finally안에서 close를 안 해도 된다.
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		try (BufferedReader br2 = br) {
			System.out.println(br2.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void java9try() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		try (br) {	//외부에서 선언한 리소스를 try문장 안에서 사용할 수 있게 개선되었다.
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
