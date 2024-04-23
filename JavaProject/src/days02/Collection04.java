package days02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

//Hashtable, HashMap 클래스
//데이터베이스 내부의 키 값을 검색하기 위해서 만들어진 알고리즘을 기반으로 작성된 클래스
//			- 검색을 위해서 사용되는 클래스
// 			- Key, Value를 저장할 수 있는 클래스
//			- Key는 중복을 허용하지 않습니다.
//			- Value는 중복을 허용합니다.
//			- ArrayList와 함께 웹프로그래밍에서 핵심 자료구조로 사용됩니다.
public class Collection04 {

	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable<>();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		//Collection에 데이터를 추가하는 메서드 : put
		ht.put("One", 1);    ht.put("Two", 2);     ht.put("Three", 3);
		hm.put(1, "One");   hm.put(2, "Two");   hm.put(3, "Three");
		
		//Collection에 데이터를 얻는 메서드 : get
		System.out.printf("Hashtable \"Three\" => %d\n", ht.get("Three")); //Hashtable "Three" => 3
		System.out.printf("HashMap 3 => \"%s\"\n", hm.get(3)); //HashMap 3 => "Three"
		
		//키값은 중복된 값으로 두 개의 키값이 저장되지 않습니다.
		//저장된 데이터들을 서로 구분하기 위해
		
		hm.put(1,  "First");
		System.out.printf("HashMap 1 => \"%s\"n", hm.get(1));
		//같은 키값으로 다른 Value 를 저장하면, 기존 Value 가 지워지고 새로운 Value 로 대체됩니다.
		
		//Value 값은 다른 Key 값으로 얼마든지 중복되어 저장될 수 있습니다.
		hm.put(1, "First");
		hm.put(2, "First");
		hm.put(3, "First");
		
		//제네릭이 지정된 ArrayList 에 아무 데이터나 다 저장하려면
		ArrayList<Object> list = new ArrayList<>();
		HashMap<String, Object> hm1 = new HashMap<>();
		
		Point p = new Point();
		hm1.put("intValue", 30);
		hm1.put("stringValue", "abcd");
		hm1.put("pointValue", p);
		
		int i = (Integer)hm1.get("intValue");
		String s = (String)hm1.get("stringValue");
		p = (Point)hm1.get("pointValue");
	}

}
