/*
 * With the zombie cure injections ready to go, it’s time to start treating our zombified rabbit friends (known as zombits) at our makeshift zombit treatment center. You need to run out really fast to buy some gauze pads but you only have 30 seconds before you need to be back.

Luckily, the corner store has unlimited gauze pads in squares of all sizes. Jackpot! The pricing is simple – a square gauze pad of size K x K costs exactly K * K coins. For example, a gauze pad of size 3×3 costs 9 coins.

You’re in a hurry and the cashier takes a long time to process each transaction. You decide the fastest way to get what you need is to buy as few gauze pads as possible, while spending all of your coins (you can always cut up the gauze later if you need to). Given that you have n coins, what’s the fewest number of gauze pads you can buy?

Write a method answer(n), which returns the smallest number of square gauze pads that can be bought with exactly n coins.

n will be an integer, satisfying 1 <= n <= 10000.
 */
package FoobarChallenges;

public class squares {
	static int min;
	public static int answer(int n) { 
		min=find_greedy_solution(n); //benchmark that we are trying to beat
		boolean var=true;
		while(var){
			var=find_smaller(n,(min-1));
		}
		return min;
    }
	private static boolean find_smaller(int number, int squares){
		//this is because we only want solution that are better than min
		if(squares==0){
			return false;
		}
		/*upper bound for the for loop is root of the number rounded down
		 *lower bound for the for loop is the square of root/levels left to go 
		 *this is because the it the lowest value the would be better than min
		 *for the given levels of recursion left*/
		for(int i=root_floor(number);i>=min_check(number,squares);i--){
			int remainder = number-(i*i);
			if(remainder==0){
				//a smaller solution is found so set min to the smaller solution
				min=min-squares;
				return true;
			}
			else{
				//call recursively decrement squares so a base case is reached
				if(find_smaller(remainder, squares-1)){
					return true;
				}
			}
		}
		return false;
	}
	private static int find_greedy_solution(int number){
		int i=0;
		while(number!=0){
			int root= (int) Math.sqrt(number);
			number=number-(root*root);
			i++;
		}
		return i;
	}
	private static int min_check(int number, int squares){
		return (int) Math.sqrt(number/squares);
	}
	private static int root_floor(int number){
		return (int) Math.sqrt(number);
	}
	public static void main(String [] args){
		System.out.println(answer(180));
	}
}
