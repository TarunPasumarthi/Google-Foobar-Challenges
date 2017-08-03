/*
 * Can we save them? Beta Rabbit is trying to break into a lab that contains the
only known zombie cure - but there's an obstacle. The door will only open if a
challenge is solved correctly. The future of the zombified rabbit population is
at stake, so Beta reads the  challenge: There is a scale with an object on the
left-hand side, whose mass is given in some number of units.
Predictably, the task is to  balance the two sides.
But there is a catch: You only have this peculiar weight set,
having masses 1, 3, 9, 27, ... units. That is, one  for each power of 3.
Being a brilliant mathematician, Beta Rabbit quickly discovers that any number
of units of mass can be balanced exactly using this set. To help Beta get into
the room, write a method called answer(x), which outputs a list of strings
representing where the weights should be  placed, in order for the two sides to
be balanced, assuming that weight on the left has mass x units.
The first element of the output list should correspond to the 1-unit weight,
the second element to the 3-unit weight, and so on. Each string is one of:
"L" : put weight on left-hand side
"R" : put weight on right-hand side
"-" : do not use weight
To ensure that the output is the smallest possible, the last element of the list
must not be "-". x will always be a positive integer, no larger than 1000000000.
 */
package FoobarChallenges;

public class weights {
	public static void main(String [] args){
		for(String s: answer(1000000000)){
			System.out.print(s);
		}
	}
	public static String[] answer(int x) { 
		String weight_string="";
		while(x!=0){
			int remainder= x%3;
			x=x/3;
			if(remainder==1){
				weight_string=weight_string+"R";
			}
			else if(remainder==0){
				weight_string=weight_string+"-";
			}
			else if(remainder==2){
				weight_string=weight_string+"L";
				x=x+1;
			}
		}
		String [] retvals= new String [weight_string.length()];
		for(int i=0;i<weight_string.length();i++){
			retvals[i]=""+weight_string.charAt(i);
		}
		return retvals;
    }
}
