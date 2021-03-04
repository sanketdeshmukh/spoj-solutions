import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.Arrays;


public class Main {

	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int x = 0, o = 0, dots = 0;
			char [][] grid = new char[3][3];
			for (int i = 0; i < 3; i++) {
				String str = sc.next();
				x += 3 - str.replaceAll("X", "").length();
				o += 3 - str.replaceAll("O", "").length();
				dots += 3 - str.replaceAll("\\.", "").length();
				grid[i] = str.toCharArray();
			}

			if (dots == 9)
				out.println("yes");

			else {
				String res = check(grid);
				if (res.length() == 2)
					out.println("no");

				else if (res.length() == 0 && (x - o == 1 || x == o))
					out.println("yes");

				else if (res.equals("X") && x - o == 1)
					out.println("yes");

				else if (res.equals("O") && x == o)
					out.println("yes");

				else
					out.println("no");
			}
		}
		out.close();
	}


	public static String check(char[][]grid) {
		String res = "";
		for (int i = 0; i < 3; i++) {
			if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '.')
				res += String.valueOf(grid[i][0]);
		}

		for (int i = 0; i < 3; i++) {
			if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != '.') {
				if (res.length() == 0 || (res.length() != 0 && grid[0][i] != res.charAt(0))  )
					res += String.valueOf(grid[0][i]);
			}
		}

		if (res.length() >= 2)
			return res;

		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '.') {
			if (res.length() == 0 || (res.length() != 0 && grid[0][0] != res.charAt(0)) )
				res += String.valueOf(grid[0][0]);
		}

		if (res.length() >= 2)
			return res;

		if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] != '.') {
			if (res.length() == 0 || (res.length() != 0 && grid[2][0] != res.charAt(0)) )
				res += String.valueOf(grid[2][0]);
		}

		return res;
	}
  
}




class FastReader {

	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException  e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	int [] nextIntArray(int n) {
		int [] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextInt();

		return arr;

	}


	long nextLong() {
		return Long.parseLong(next());
	}

	long [] nextLongArray(int n) {
		long [] arr = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextLong();

		return arr;

	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

}
