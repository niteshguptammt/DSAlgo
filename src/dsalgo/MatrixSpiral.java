package dsalgo;

class MatrixSpiral {
  public static void main(String[] args) {
    
    int[][] sampleArray = {{1, 2, 3, 4},
                           {5, 6, 7, 8},
                           {9, 10,11,12},
                           {13,14,15,16},
                           {17,18,19,20}
                          };
    for (int i = 1; i< 5;i++) {
    	System.out.println("Clockwise " + i +" :");
    	printSpiral(sampleArray, true, i);
    	System.out.println();
    	System.out.println("AntiClockwise " + i +" :");
    	printSpiral(sampleArray, false, i);
    	System.out.println();
    }
    
    	/*Clockwise 1 :
    	1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,14,10,
    	AntiClockwise 1 :
    	1,5,9,13,17,18,19,20,16,12,8,4,3,2,6,10,14,15,11,7,
    	Clockwise 2 :
    	4,8,12,16,20,19,18,17,13,9,5,1,2,3,7,11,15,14,10,6,
    	AntiClockwise 2 :
    	4,3,2,1,5,9,13,17,18,19,20,16,12,8,7,6,10,14,15,11,
    	Clockwise 3 :
    	20,19,18,17,13,9,5,1,2,3,4,8,12,16,15,14,10,6,7,11,
    	AntiClockwise 3 :
    	20,16,12,8,4,3,2,1,5,9,13,17,18,19,15,11,7,6,10,14,
    	Clockwise 4 :
    	17,13,9,5,1,2,3,4,8,12,16,20,19,18,14,10,6,7,11,15,
    	AntiClockwise 4 :
    	17,18,19,20,16,12,8,4,3,2,1,5,9,13,14,15,11,7,6,10,*/
  }
  
	private static void topDown(int[][] myArray, int m, int n, int k, int l, boolean c) {
		for (int i = k; i < m; i++) {
			if (c) {
				System.out.print(myArray[i][n - 1] + ",");
			} else {
				System.out.print(myArray[i][l] + ",");
			}
		}
		if (c) {
			n--;
	        if (k < m) {
	          rightLeft(myArray, m, n, k, l, c);
	        }
		} else {
			l++;
	        if (k < m) {
	          leftRight(myArray, m, n, k, l, c);
	        }
		}
	}
	
	private static void bottomUp(int[][] myArray, int m, int n, int k, int l, boolean c) {
		for (int i = m - 1; i >= k; i--) {
			if (c) {
				System.out.print(myArray[i][l] + ",");
			} else {
				System.out.print(myArray[i][n - 1] + ",");
			}
		}
		if (c) {
			l++;
	        if (k < m) {
	          leftRight(myArray, m, n, k, l, c);
	        }
		} else {
			n--;
	        if (k < m) {
	          rightLeft(myArray, m, n, k, l, c);
	        }
		}
	}
	
	private static void leftRight(int[][] myArray, int m, int n, int k, int l, boolean c) {
		for (int i = l; i < n; i++) {
			if (c) {
				System.out.print(myArray[k][i] + ",");
			} else {
				System.out.print(myArray[m - 1][i] + ",");
			}
		}
		if (c) {
			k++;
	        if (l < n) {
	        	topDown(myArray, m, n, k, l, c);
	        }
		} else {
			m--;
	        if (l < n) {
	          bottomUp(myArray, m, n, k, l, c);
	        }
		}
	}
	
	private static void rightLeft(int[][] myArray, int m, int n, int k, int l, boolean c) {
		for (int i = n - 1; i >= l; i--) {
			if (c) {
				System.out.print(myArray[m - 1][i] + ",");
			} else {
				System.out.print(myArray[k][i] + ",");
			}
		}
		if (c) {
			m--;
	        if (l < n) {
	          bottomUp(myArray, m, n, k, l, c);
	        }
		} else {
			k++;
	        if (l < n) {
	          topDown(myArray, m, n, k, l, c);
	        }
		}
	}
  
  private static void printSpiral(int[][] myArray, boolean clockwise, int position){
    
    //Position = 1:LT, 2:RT, 3:RB, 4:LB

    int rows = myArray.length;
    int cols = myArray[0].length;

    //System.out.println("rows " + rows + ", cols " + cols); 

    // Spiral Order
    // 1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,14,10
    // Anticlockwise
    // 1,5,9,13,17,18,19,20,16,12,8,4,3,2,6,10,14,15,11,7
    
    // R1 C4 R4 C1 R2 C3 R3 C1
    int k = 0; // start row
    int l = 0; // start col
    int m = rows; // end row
    int n = cols; // end col
    
    if (clockwise) {
			if (position == 1) {
				leftRight(myArray, m, n, k, l, clockwise);
			} else if (position == 2) {
				topDown(myArray, m, n, k, l, clockwise);
			} else if (position == 3) {
				rightLeft(myArray, m, n, k, l, clockwise);
			} else if (position == 4) {
				bottomUp(myArray, m, n, k, l, clockwise);
			}
    } else {
			if (position == 1) {
				topDown(myArray, m, n, k, l, clockwise);
			} else if (position == 2) {
				rightLeft(myArray, m, n, k, l, clockwise);
			} else if (position == 3) {
				bottomUp(myArray, m, n, k, l, clockwise);
			} else if (position == 4) {
				leftRight(myArray, m, n, k, l, clockwise);
			}
    }
  }
}
