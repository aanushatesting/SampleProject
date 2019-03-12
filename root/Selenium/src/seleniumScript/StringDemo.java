package seleniumScript;

public class StringDemo {

	public static void main(String[] args) {
		
		String s1="Hello";
		String s2=new String("Hello World");
		char ch[]= {'J','a','v','a'};
		String s3=new String(ch);
		
		System.out.println("Lenght of s2:"+s2.length());
		System.out.println(s1.equals(s2));
		System.out.println(s1.concat(s3));
		System.out.println(s2.contains(s1));

	}

}
