package com.revature.eval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		
		if (string == null) {	// Checks for null, returns it if true.
			return null;
		}
		
		String reverseStr = "";
		
		for (int i = string.length() - 1; i >= 0; i--) {
			reverseStr += string.charAt(i);	// Uses charAt function in order to traverse the 
		}									// string backwards and add it to the reverseStr variable.
		return reverseStr;
	}
	
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		if (phrase == null) {
			return null;
		}
		
		String acronym = "";
		
		String [] phraseSplit = phrase.split("\\W+");// Uses a regular expression to split the 
													// string. \W+ is one or more occurrences of non-word characters
		for (String word : phraseSplit) {
			acronym += word.charAt(0);
		}
		
		
		return acronym.toUpperCase();	// Since acronyms are always capital letters I use this here just in case.
	}
	
	
	/**
	 * 3. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		int [] scrabbleScore = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 
									3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};	// Ordered the score by alphabetical order.
		int score = 0;
		
		// Used ASCII code in order to get the correct index in the scrabbleScore array.
		for (int i = 0; i < string.length(); i++) {
			score += scrabbleScore[string.toUpperCase().charAt(i) - 'A'];
		}
				
		return score;
	}
	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return 
	 */
	public Map<String, Integer> wordCount(String string) {
		
		HashMap<String, Integer> wordC = new HashMap<String, Integer>();
		
		String [] stringSplit = string.split("\\W+"); // Used a regular expression again to split the string.
		int count;
		int index = 0;
		
		for (String word : stringSplit) {
			count = 0;
			
			if (word == stringSplit[index]) {
				count++;
				index++;
			}
			wordC.put(word, count);
		}
	// DOESNT WORK FOR ALL TESTS. (multipleOccurrencesOfAWord)
		return wordC;
	}
	
	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
			int middleIndex = getSortedList().size() / 2;	// assigns the middle index of the list.
			
			// Enters the while loop and stays there until middleIndex is equal
			// to the right index in the list.
			while (sortedList.indexOf(t) != middleIndex) { 
				if (sortedList.indexOf(t) > middleIndex) {
					middleIndex++;
				} 
				else if (sortedList.indexOf(t) < middleIndex) {
					middleIndex--;
				} else {
					return middleIndex;
				}
			}
			
			System.out.println(sortedList.indexOf(t));
			
			return middleIndex;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
}
