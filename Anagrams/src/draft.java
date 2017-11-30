import java.util.*;

public class draft {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetterInventory inventory = new LetterInventory("george bush");
		List<String> result = new ArrayList<String>();
		
		List<String> dict1= new ArrayList<String>();
		dict1.add("a");
		dict1.add("bow");
		List<String> dict2= new ArrayList<String>();
		dict2.add("cat");
		
		List<List<String>> total= new ArrayList<List<String>>();
//		total.add(dict1);
//		total.add(dict2);
		Anagrams test1 = new Anagrams(dict1);
		
		test1.getResult(inventory, result);
	}

}
