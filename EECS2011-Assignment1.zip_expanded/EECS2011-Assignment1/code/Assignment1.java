import java.io.*;
import java.util.Scanner;

public class Assignment1{
  
  public int[][] denseMatrixMult(int[][] A, int[][] B, int size)
  {
	return B;

  }
  
  public int[][] sum(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
  {
	  int [] [] m1= new int[n][n]; 
	  int [] [] m2= new int[n][n]; 
	 
	  
	  int A1x=x1;
	  int A1y=y1;
	  
	  int B1x=x2;
	  int B1y=y2;
	  
	  for(int i=0;i<n;i++ ) {
		  for(int l =0;l<n;l++) {
			  m1[i][l]= A[A1x][A1y];
			  A1y++;
		  }
		  A1y=A1y-n;
		  A1x++;
	  }
	  
	  for(int k=0;k<n;k++ ) {
		  for(int c =0;c<n;c++) {
			  m2[k][c]= B[B1x][B1y];
			  B1y++;
		  }
		  B1y=B1y-n;
		  B1x++;
	  }
	  
	  int [] [] tot= new int[n][n]; 
	  
	  for(int i=0;i<n;i++) {
		  for(int k=0;k<n;k++) {
			  tot[i][k]=m1[i][k]+m2[i][k];
		  }
	  }
	  
	return tot;
 
  }
  
  public int[][] sub(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
  {
	  int [] [] m1= new int[n][n]; 
	  int [] [] m2= new int[n][n]; 
	  
	  
	  int A1x=x1;
	  int A1y=y1;
	  
	  int B1x=x2;
	  int B1y=y2;
	  
	  for(int i=0;i<n;i++ ) {
		  for(int l =0;l<n;l++) {
			  m1[i][l]= A[A1x][A1y];
			  A1y++;
		  }
		  A1y=A1y-n;
		  A1x++;
	  }
	  
	  for(int k=0;k<n;k++ ) {
		  for(int c =0;c<n;c++) {
			  m2[k][c]= B[B1x][B1y];
			  B1y++;
		  }
		  B1y=B1y-n;
		  B1x++;
	  }
	  
	  int [] [] tot= new int[n][n]; 
	  
	  for(int i=0;i<n;i++) {
		  for(int k=0;k<n;k++) {
			  tot[i][k]=m1[i][k]-m2[i][k];
		  }
	  }
	  
	return tot;
 

  }
  
  
  public int[][] initMatrix(int n)
  {
	  int [] [] mat= new int[n][n]; 
	return mat;

  }
  
  public void printMatrix(int n, int[][] A)
  {
    for(int i=0; i<n;i++) {
	  for(int k=0; k<n;k++) {
		  System.out.print(A[i][k]);
	  }
	  System.out.println();
     }
  }
  
  public int[][] readMatrix(String filename, int n) throws Exception
  {
	  int [] [] read =new int [n] [n];
	  Scanner f = new Scanner (new File(filename));
	  
	
		  for(int i=0; i<n&& f.hasNextLine();i++) {
			  for(int k=0; k<n && f.hasNextLine();k++) {
				  read[i][k]= f.nextInt();
			  }
		  }
		  f.close();

	  
	return read;
 
  }
  
}