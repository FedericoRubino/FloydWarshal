/*
  Federico Rubino
  frubino
  Assignment #9
  Floyd-Warshal
  p9.java
*/

import java.util.Scanner;
import java.util.Arrays;

public class p9{
    
    public static void main(String args[]){
	FloydWarshal matrix = new FloydWarshal();
	Scanner input = new Scanner(System.in);
	int[] line;
	int sNode =0; int dNode =0; int weight=0;
	while(input.hasNextLine()){
	    line = 
		Arrays.stream(input.nextLine()
			      .replaceAll("[^\\d- ]", " " )
			      .split("\\s+"))
		.mapToInt(Integer::parseInt)
		.toArray();
	    matrix.fillMatrix(line[0], line[1], line[2]);
	}//while input
	matrix.adjustMatrix();
	matrix.printMatrix();
	System.out.println();
	matrix.printParent();
    }//main

}//class
