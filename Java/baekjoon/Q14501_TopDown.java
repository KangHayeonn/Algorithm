// 퇴사 (백준 실버3)

// ver1 : DP (Top-down)
import java.io.*;
import java.util.*;

public class Main {
	public static class Type{
		int T, P;
		public Type(int T, int P) {
			this.T = T;
			this.P = P;
		}
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Type[] arr = new Type[N+2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr[i] = new Type(T, P);
		}
		
		int[] dp = new int[N+2];
		int answer = 0;
		answer = DP(arr, dp, 0, N);
		System.out.println(answer);
	}
	public static int DP(Type[] arr, int[] dp, int now, int N) {
		if(now >= N) return 0;
		if(now + arr[now].T > N) return dp[now] = DP(arr, dp, now+1, N);
		if(dp[now] != 0) return dp[now];
		
		return dp[now] = Math.max(arr[now].P+DP(arr, dp, now+arr[now].T, N), DP(arr, dp, now+1, N));
	}
}