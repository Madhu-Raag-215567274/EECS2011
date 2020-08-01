import java.io.*;
import java.util.Scanner;

public class Assignment1{
  
  public int[][] denseMatrixMult(int[][] A, int[][] B, int size)
  {  
	  
	  int[][] tot= new int[size][size];
	  
		
		if (size == 2) {
			
			int M0 = (A[0][0]+ A[1][1])*(B[0][0]+ B[1][1]);
			int M1 = (A[1][0]+ A[1][1])*(B[0][0]);
			int M2 = (B[0][1]- B[1][1])*(A[0][0]);
			int M3 = (B[1][0]-B[0][0])*A[1][1];
			int M4 = (A[0][0]+ A[0][1])*(B[1][1]);
			int M5 = (A[1][0]- A[0][0]) *(B[0][0]+ B[0][1]);	
			int M6 = (A[0][1]- A[1][1])*(B[1][0] + B[1][1]);
						
			
			int C00 = M0+ M3- M4+ M6;
			int C01 = M2+ M4;
			int C10 = M1+ M3;
			int C11 = M0- M1 + M2 + M5;
						
			
			tot[0][0] = C00;
			tot[0][1] = C01;
			tot[1][0] = C10;
			tot[1][1] = C11;
			
			return tot;
		}
		
		int newsize= size/2;
		
		
		int[][] A00 = new int[newsize][newsize];
		int[][] A01 = new int[newsize][newsize];
		int[][] A10 = new int[newsize][newsize];	
		int[][] A11 = new int[newsize][newsize];
		
		int[][] B00 = new int[newsize][newsize];	
		int[][] B01 = new int[newsize][newsize];
		int[][] B10 = new int[newsize][newsize];	
		int[][] B11 = new int[newsize][newsize];
		
		
		for (int i = 0; i < newsize;i++ ) {
			for (int k = 0; k< newsize;k++ ) {
				A00[i][k] = A[i][k];
				A01[i][k] = A[i][k+newsize];
				A10[i][k] = A[i+newsize][k];
				A11[i][k] = A[i+newsize][k+newsize];
				
				B00[i][k] = B[i][k];
				B01[i][k] = B[i][k+newsize];
				B10[i][k] = B[i+newsize][k];
				B11[i][k] = B[i+newsize][k+newsize];
			}
		}
		
		
		
		
		int[][] C00 = sum(denseMatrixMult(A00, B00, size/2),
				denseMatrixMult(A01, B10, size/2), 0, 0, 0, 0, size/2);
		
		int[][] C01 = sum(denseMatrixMult(A00, B01,size/2),
				denseMatrixMult(A01, B11, size/2), 0, 0, 0, 0, size/2);
		
		int[][] C10 = sum(denseMatrixMult(A10, B00, size/2), 
				denseMatrixMult(A11, B10, size/2), 0, 0, 0, 0,size/2);
		
		int[][] C11 = sum(denseMatrixMult(A10, B01,size/2), 
				denseMatrixMult(A11, B11, size/2), 0, 0, 0, 0, size/2);
		
		for (int i = 0; i < size; i ++) {
			for (int j = 0; j < size; j ++) {
				
				if (i < newsize && j < newsize) {
					tot[i][j] = C00[i][j];
				}
				else if (i >= newsize && j < newsize) {
					tot[i][j] = C10[i-newsize][j];
				}
				else if (i >= newsize && j >= newsize) {
					tot[i][j] = C11[i-newsize][j-newsize];
				}
				else if (i < newsize && j >= newsize) {
					tot[i][j] = C01[i][j-newsize];
				}
				
				
			}
		}
		
		return tot;

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
		  System.out.print(" ");
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