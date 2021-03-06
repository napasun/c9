package khj.study.junit.summary;

import static org.junit.Assert.*;

import org.junit.Test;

import khj.study.junit.cal.Cal;
import khj.study.junit.cal.Calculater;

public class SpyTest {

	@Test
	public void spyTest() {
		Calculater cal = new Calculater();
		spyCal spy = new spyCal();
		
		cal.setMulCal(spy);
		
		cal.mul(10, 5);
		
		assertEquals(spy.check(10, 5), spy.getC());
	}
	
	public class spyCal implements Cal {
		private int c;
		
		public int getC() {
			return c;
		}
		
		public void mul(int a, int b) {
			this.c = a * b;
		}
		
		public int check(int a, int b) {
			return a * b;
		}
	}
}
