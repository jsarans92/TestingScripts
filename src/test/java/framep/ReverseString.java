package framep;

public class ReverseString {

	public static void main(String[] args) {
		String ip="321NANAVARAS";
		char[] rev=ip.toCharArray();
		String op="";

		for(int i=rev.length-1;i>=0;i--) {
			op=op+rev[i];
		}
		System.out.println(op);

	}

}
