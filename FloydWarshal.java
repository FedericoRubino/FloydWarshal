/*
  frubino
  Federico Rubino
  Assignment #9
  FloydWarshal
*/


import java.util.ArrayList;

public class FloydWarshal{

    //constructor
    public FloydWarshal(){
	size = 0;
	sourceN = new ArrayList<Integer>();
	destinationN = new ArrayList<Integer>();
	weightE = new ArrayList<Integer>();
    }

    //fills the different arraylists with the input
    public void fillMatrix(int source, int dest, int weight){
	if(size < source){ size = source;}
	if(size < dest) { size = dest;}
	sourceN.add(source);
	destinationN.add(dest);
	weightE.add(weight);
    }

    //initialises the distance and parent matricies
    public void adjustMatrix(){
	matrix = new int[size+1][size+1];
	parent = new int[size+1][size+1];
	for(int i = 0; i <=size; i++){ //I need one more than size
	    for(int j = 0; j <=size; j++){
		parent[i][j] = INFINITE; 
		if(i == j)
		    matrix[i][j] = 0; //diagonals will start at 0
		else  
		    matrix[i][j] = INFINITE;
	    }
	}
	for(int k = 0;k < sourceN.size();k++){
	    matrix[sourceN.get(k)][destinationN.get(k)] = weightE.get(k);
	    parent[sourceN.get(k)][destinationN.get(k)] = sourceN.get(k);
	}
	for(int k = 0; k <= size;k++){
	    for(int i = 0; i <= size;i++){
		for(int j = 0; j <= size;j++){
		    matrix[i][j] = min(i,j,k);
		}//for j
	    }//for i
	}//for k
    }

    //finds the min between ij or ik + kj
    private int min(int i, int j, int k){
	if(k == 0){ return matrix[i][j];}
	int dij = matrix[i][j];
	int dik = matrix[i][k];
	int dkj = matrix[k][j];
	if(dij > dik + dkj && dik != INFINITE && dkj != INFINITE){
	    	    parent[i][j] = k;
	    return dik + dkj;
	} else 
	    return dij;
    }

    //prints the distance matrix
    public void printMatrix(){
	System.out.printf("D ");
	for(int i = 1; i <=size; i++){ 
	    System.out.printf("%d: ", i);
	}
	System.out.println();
	for(int i = 1; i <=size; i++){ 
	    System.out.printf("%d: ", i);
	    for(int j = 1; j <=size; j++){
		int temp = matrix[i][j];
		if(temp != INFINITE)
		    System.out.printf("%d ", temp);
		else 
		    System.out.printf("%s ", ".");
	    }
	    System.out.println();
 	}
    }

    //prints the parent matrix
    public void printParent(){
	System.out.printf("P ");
	for(int i = 1; i <=size; i++){ 
	    System.out.printf("%d: ", i);
	}
	System.out.println();
	for(int i = 1; i <=size; i++){ 
	    System.out.printf("%d: ", i);
	    for(int j = 1; j <=size; j++){
		int temp = parent[i][j];
		if(temp != INFINITE)
		    System.out.printf("%d ", temp);
		else 
		    System.out.printf("%s ", ".");
	    }
	    System.out.println();
 	}
    }


    //member variables
    //    private ArrayList<ArrayList<Integer> > edges;
    private int[][] matrix;
    private int[][] parent;

    private ArrayList<Integer> sourceN;
    private ArrayList<Integer> destinationN;
    private ArrayList<Integer> weightE;
    private int size;
    private int INFINITE = Integer.MAX_VALUE;

}//class
