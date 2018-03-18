package tictac;
import java.util.Random;
public class TicTacToe {

	public static void main(String[] args) {
		String[] s =  args;
		char y;
		int x = Integer.parseInt(s[0]);
		int a = 0;
		//System.out.println(x);
		
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
		//System.out.println(n);
		
		if(n%2 ==0) {
			y = 'X';
			System.out.println(y+" goes first");
		}
		else {
			y = 'O';
			System.out.println(y+" goes first");
		}
		
		char[][] tictac = new char[x][x];
		int j = x*x;
		int b= 0;
		n = rand.nextInt(x-1) + 0;
		a = rand.nextInt(x-1) + 0;
		char c,d,e='O';
		int i,count,k, l = 0;
		Random randomNum = new Random();
		for(i=0; i<j; i++) {
			count =0;
			while(tictac[n][a] != '\u0000')
			{
				n = 0 + randomNum.nextInt(x);
				//System.out.println(n);
				a = 0 + randomNum.nextInt(x);
				//System.out.println(a);
			}			
			
			tictac[n][a] = y;
			
			//System.out.println("["+n+"] ["+a+"] = "+y+" "+i);
			
			if(y == 'X')
				y = 'O';
			else if(y == 'O')
				y = 'X';
			
			c = tictac[0][0];
			
			for(k=1; k<x; k++){				
				for(l=1; l<x; l++) {			
					if(k==l && tictac[k][l]==c && tictac[k][l] != '\u0000') {
						b=1;
						count++;
					}
					else{
						b=-1;
					}
				}
			}
			if(b==1 && count == x-1) {
				System.out.println("Left Diagonal Completed. "+c+" wins!");
				break;
			}
			else
				count = 0;
			
			d = tictac[0][x-1];
			
			for(k=1,l=x-2; k<x; k++,l--){				
					if(tictac[k][l]==d && tictac[k][l] != '\u0000') {
						b=2;
						count++;
					}
					else{
						b=-1;
					}
				}
			if(b==2 && count == x-1) {
				System.out.println("Right Diagonal Completed. "+d+" wins!");
				break;
			}
			else
				count =0;
			
			for(k=0; k<x; k++){
				e = tictac[k][0];
				for(l=1; l<x; l++) {
					if(tictac[k][l] == e && tictac[k][l] != '\u0000') {
						b=3;
						count++;
					}
					else{
						b=-1;
					}
				}
				if(b==3 && count == x-1){
					break;
				}
				else
					count=0;
			}
			if(b==3 && count == x-1) {
				System.out.println("Horizontal line "+(k+1)+" completed. "+e+" wins!");
				break;
			}
			else
				count = 0;
			
			for(k=0; k<x; k++){
				e = tictac[0][k];
				for(l=1; l<x; l++) {
					if(tictac[l][k] == e && tictac[l][k] != '\u0000') {
						b=4;
						count++;
					}
					else{
						b=-1;
					}
				}
				if(b==4 && count == x-1){
					break;
				}
				else
					count=0;
			}
			if(b==4 && count == x-1) {
				System.out.println("Vertical line "+(k+1)+" completed. "+e+" wins!");
				break;
			}
			else
				count = 0;
			
		}
		
		if(i==j)
			System.out.println("Game is Drawn!");
		
		for(i=0; i<x; i++){
			for(j=0; j<x; j++) {
				if(tictac[i][j] == '\u0000')
					System.out.print("# \t");
				else
					System.out.print(tictac[i][j]+" \t");
			}
			System.out.println();
		}
	}
}