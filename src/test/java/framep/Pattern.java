package framep;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern obj=new Pattern();
		//obj.numberPattern();
		obj.starPattern2();


	}

	public void numberPattern() {
		for (int i = 1; i <=6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public void starPattern() {
		int x, y, row=5; 
		//outer loop for rows 
		for(x=0; x<row; x++) 
		{ 
			//inner loop for columns 
			for(y=0; y<=x; y++) 
			{ 
				//To prints stars 
				System.out.print("* "); 
			} 
			//Cursor goes to the new line after printing each line. 
			System.out.println(); 
		} 
	}
	public void starPattern1() {

		int x, y, row = 5; 
		//Outer loop for rows 
		for (x=0; x<row; x++) 
		{ 
			//inner loop for space 
			for (y=row-x; y>1; y--) 
			{ 
				//To print space between two stars 
				System.out.print(" "); 
			} 
			//inner loop for columns 
			for (y=0; y<=x; y++ ) 
			{ 
				//To print star 
				System.out.print("* "); 
			} 
			//Cursor goes to the new line after printing each line.
			System.out.println(); 
		} 
	}
	
	public void starPattern2() {

		int x, y, row = 5; 
		//Outer loop for rows 
		for (x=0; x<row; x++) 
		{ 
			//inner loop for space 
			for (y=2*(row-1); y>=0; y--) 
			{ 
				//To print space between two stars 
				System.out.print(" "); 
			} 
			//inner loop for columns 
			for (y=0; y<=x; y++ ) 
			{ 
				//To print star 
				System.out.print("* "); 
			} 
			//Cursor goes to the new line after printing each line.
			System.out.println(); 
		} 
	}

}
