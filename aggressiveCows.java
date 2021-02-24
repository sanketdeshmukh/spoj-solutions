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
			int stalls = sc.nextInt();
			int cows = sc.nextInt();
			int [] pos = sc.nextIntArray(stalls);
			Arrays.sort(pos);
			int left = 1;
			int right = pos[stalls - 1] - pos[0];
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (check(mid, pos, cows))
					left = mid + 1;

				else
					right = mid - 1;
			}
			out.println(right);
		}
		out.close();
	}

	static boolean check(int dis, int [] pos, int cows) {
		int cowsPlaced = 1;
		int lastpos = 0;
		for (int i = 1; i < pos.length; i++) {
			if ((pos[i] - pos[lastpos]) < dis)
				continue;

			if (++cowsPlaced == cows)
				return true;

			lastpos = i;
		}

		return false;
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
