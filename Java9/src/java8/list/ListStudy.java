package java8.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStudy {
	public static void main(String[] args) {
		List l = new ArrayList();
		List constList = Collections.unmodifiableList(l);
	}
}
