package framep;

import net.bytebuddy.asm.Advice.Exit;

public class Serlz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("This is try block");
			System.exit(0);
			//System.out.println(1/0);
		}
		catch(Exception e){
			System.err.println(e);
		}
		finally {
			// TODO: handle finally clause
			System.out.println("This is finally block");
			
		}
		

	}

}
