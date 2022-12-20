# min no of platforms required.
using System;
public class prob {	
	public static int findPlatform(int[] arr, int[] dep,
								int n)
	{

		
		int plat_needed = 1, result = 1;
		int i = 0, j = 0;
		for (i = 0; i < n; i++) {
			plat_needed = 1;

			for (j = 0; j < n; j++) {
				if (i != j)
					if (arr[i] >= arr[j]
						&& dep[j] >= arr[i])
						plat_needed++;
			}
			result = Math.Max(result, plat_needed);
		}
		return result;
	}
	static public void Main()
	{

		int[] arr = { 100, 300, 500 };
		int[] dep = { 900, 400, 600 };
		int n = 3;
		Console.WriteLine(findPlatform(arr, dep, n));
	}
}
