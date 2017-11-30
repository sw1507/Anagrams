import java.util.*;

/**
 * CSE143 HW5 Written by: Su Wang, enrolled in quiz session AC. Anagrams uses a
 * dictionary to find all combinations of words that contain same letters as a
 * given text.
 */
public class Anagrams {
	private List<String> originalDictionary;
	private List<String> dictionaryList;
	private Map<String, LetterInventory> dictionaryMap;

	/**
	 * Initialize a new anagram given a list of words as the dictionary.
	 * 
	 * @param dictionary
	 *            is a list of strings. Assumption: a non-empty list contain no
	 *            duplicates.
	 */
	public Anagrams(List<String> dictionary) {
		dictionaryMap = new HashMap<String, LetterInventory>();
		originalDictionary = new ArrayList<String>(dictionary);
		for (String word : dictionary) {
			LetterInventory wordInventory = new LetterInventory(word);
			dictionaryMap.put(word, wordInventory);
		}
	}

	/**
	 * Finds out a phrase's all combinations of anagrams words that contain at
	 * most N words and print them out.
	 * 
	 * @param text
	 *            should be strings, is a given word or phrase that you want to
	 *            explore.
	 * @param max
	 *            should be a positive integer, which is the maximum number of
	 *            words contained in the output. throws
	 *            IllegalArgumentException() if max is negative.
	 */
	public void print(String text, int max) {
		if (max < 0) {
			throw new IllegalArgumentException();
		} else {
			dictionaryList = new ArrayList<String>(originalDictionary);
			LetterInventory explore = new LetterInventory(text);
			List<String> result = new ArrayList<String>();
			for (int index = 0; index < dictionaryList.size(); index++) {
				String key = dictionaryList.get(index);
				if (explore.subtract(dictionaryMap.get(key)) == null) {
					dictionaryList.remove(index);
				}

			}
			getResult(explore, result, max);
		}
	}

	/**
	 * A helper method that can find out a phrase's anagrams.
	 * 
	 * @param textToBeExplored
	 *            should be an LetterInventory, which is the letters needs to be
	 *            explored.
	 * @param result
	 *            should be a list, it shows the output.
	 * @param max
	 *            should be an positive integer. The maximum number of words
	 *            that will be shown in the output.
	 */
	private void getResult(LetterInventory textToBeExplored, List<String> result, int max) {

		if (textToBeExplored != null) {
			if (textToBeExplored.size() == 0 && (result.size() <= max || max == 0)) {
				System.out.println(result);
			} else {
				for (String word : dictionaryList) {
					LetterInventory chosenWord = dictionaryMap.get(word);
					result.add(word);
					getResult(textToBeExplored.subtract(chosenWord), result, max);
					result.remove(result.size() - 1);
				}
			}

		}

	}
}
