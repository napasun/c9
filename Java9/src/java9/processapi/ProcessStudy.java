package java9.processapi;

public class ProcessStudy {
	public static void main(String[] args) {
		ProcessHandle process = ProcessHandle.current();
		System.out.println(process.getPid());
	}
}
