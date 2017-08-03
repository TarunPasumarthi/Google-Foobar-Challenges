/*You forgot to give Professor Boolean's favorite rabbit specimen a name? You know how picky the professor is! Only particular names will do! Fix this immediately, before you're... eliminated!"
 * Luckily, your minion friend has already come up with a list of possible names, and we all know that the professor has always had a thing for names with lots of letters near the 'tail end' of the alphabet, so to speak. You realize that if you assign the value 1 to the letter A, 2 to B, and so on up to 26 for Z, and add up the values for all of the letters, the names with the highest total values will be the professor's favorites. For example, the name Annie has value 1 + 14 + 14 + 9 + 5 = 43, while the name Earz, though shorter, has value 5 + 1 + 18 + 26 = 50. 
 * If two names have the same value, Professor Boolean prefers the lexicographically larger name. For example, if the names were AL (value 13) and CJ (value 13), he prefers CJ.
 * Write a function answer(names) which takes a list of names and returns the list sorted in descending order of how much the professor likes them. 
 * There will be at least 1 and no more than 1000 names. 
 * Each name will consist only of lower case letters. The length of each name will be at least 1 and no more than 8.
*/
package FoobarChallenges;

import java.util.LinkedList;

public class bunny_name_alternate {
	public static void main(String [] args){
		String [] lol={"annie","bonnie","liz"};
		for(String s:answer(lol)){
			System.out.println(s);
		}
	}
	public static String[] answer(String [] names){
		LinkedList<String> list= new LinkedList<String>();
		for(String name:names){
			boolean added=false;
			for(int i=0; i<list.size();i++){
				if(less_than(list.get(i),name)){
					list.add(i,name);
					added=true;
					break;
				}
			}
			if(!added){
				list.add(name);
			}
		}
		String [] retvals=new String[list.size()];
		int i=0;
		for(String node:list){
			retvals[i]=node;
			i++;
		}
		return retvals;
	}
	private static boolean less_than(String name1,String name2){
		int value1= getValue(name1);
		int value2= getValue(name2);
		boolean retval= (value1<value2);
		if(value1==value2){
			if(name1.compareTo(name2)<0){
				retval=true;
			}
		}
		return retval;
	}
	private static int getValue(String name){
		int value=0;
		for(int i=0; i<name.length();i++){
			int char_val=(int)name.charAt(i)-96;
			value= value+char_val;
		}
		return value;
	}
}
