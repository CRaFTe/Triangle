/*
 * Created by Micah T. Moore to solve the Triangle problem presented by Yodle.
 * Description: Looks at the second to last row, traverse each node in that row, and add the greater
 * value from it's two children to it and place the sum in the current cell. Decrement the row and
 * continue through the routine until the top node is reached,  The value in the top node cell will
 * contain the greatest sum.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Triangle {

	public static void main(String[] args) {
		int keepRowCount = 0;
		int i = 0;
		int triangle[][] = new int[101][101];
		int rowCount = 0;
		try {
			Scanner scanner = new Scanner(new File("triangle.txt"));
			while(scanner.hasNextInt()) {
				triangle[rowCount][i] = scanner.nextInt();
				if(i == rowCount) {
					rowCount++;
					i = 0;
				}
				else {
					i++;
				}
			}
			scanner.close();
			rowCount--;
			keepRowCount = rowCount;
			i = rowCount;
			int myTotal = addTriangle(triangle,keepRowCount);
			System.out.println("This is the Total: " + myTotal);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

			}
	static int addTriangle(int[][] triangle,int totalRows) {
		for(int i = totalRows-1; i>=0; i--) {
			for(int j = 0; j<=i; j++) {
				if(triangle[i+1][j] > triangle[i+1][j+1]) {
					triangle[i][j] += triangle[i+1][j];
				}
				else {
					triangle[i][j] += triangle[i+1][j+1];
				}
			}
		}
		return triangle[0][0];
	}

	}

