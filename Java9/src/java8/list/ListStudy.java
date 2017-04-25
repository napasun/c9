package java8.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ListStudy {
	public static void main(String[] args) {
		List l = new ArrayList();
		List constList = Collections.unmodifiableList(l);

		//java forEach 
		l.forEach(new Consumer<String>() {
			@Override
			public void accept(String arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
