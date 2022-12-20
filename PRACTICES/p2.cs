using System;
public class prob {
	static void manipulateString(String str)
	{
		char[] str1 = str.ToCharArray();
	for (int i = 0; i < str.Length; i++) {
		int asc = str1[i];
		int rem = asc - (26 - (str1[i] - 97));
		int m = rem % 26;
		str1[i] = (char)(m + 'a');
			
	}
	String str2 = String.Join("",str1);
	Console.WriteLine(str2);
	}
	public static void Main() {
		String str = "vishal";
		manipulateString(str);		
	}
}

