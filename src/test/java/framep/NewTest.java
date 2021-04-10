package framep;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		String first="SARAVANAN123";
		
		String[] out=first.split("[^a-zA-Z']+");
		String result="";

		for(int i=0;i<out.length;i++) {

			result+=out[i];

			System.out.println(result);


		}
	}
}
