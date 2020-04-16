package khj.study.junit.cal;

public class Calculater implements Cal{
	private Cal mulCal;
	
	public void setMulCal(Cal mulCal) {
		this.mulCal = mulCal;
	}
	
	public int add(int value_1, int value_2) {
		return value_1 + value_2;
	}

	public int sub(int value_1, int value_2) {
		return 10;
	}

	public void mul(int a, int b) {
		mulCal.mul(a, b);
	}
}
