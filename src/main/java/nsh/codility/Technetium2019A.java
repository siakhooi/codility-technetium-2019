package nsh.codility;

import java.util.ArrayList;

public class Technetium2019A implements Technetium2019Interface {
	class Position {
		int n;
		int m;

		Position(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

	public String solution(int[][] A) {
		int N = A.length;
		int M = A[0].length;
		int Max = Math.max(N, M);

		ArrayList<Position> P0 = new ArrayList<Position>(Max);
		ArrayList<Position> P1 = new ArrayList<Position>(Max);
		P0.add(new Position(0, 0));

		String R = "" + A[0][0];
		while (!(P0.size() == 1 && (P0.get(0).m == M - 1 || P0.get(0).n == N - 1))) {

			int biggestNumber = 0;
			for (Position p : P0) {
				if (p.n < N - 1) {
					int p1 = A[p.n + 1][p.m];
					if (p1 > biggestNumber) {
						biggestNumber = p1;
						P1.clear();
						P1.add(new Position(p.n + 1, p.m));
						A[p.n + 1][p.m] = 0;
					} else if (p1 == biggestNumber) {
						P1.add(new Position(p.n + 1, p.m));
						A[p.n + 1][p.m] = 0;
					}
				}
				if (p.m < M - 1) {
					int p1 = A[p.n][p.m + 1];
					if (p1 > biggestNumber) {
						biggestNumber = p1;
						P1.clear();
						P1.add(new Position(p.n, p.m + 1));
						A[p.n][p.m + 1] = 0;
					} else if (p1 == biggestNumber) {
						P1.add(new Position(p.n, p.m + 1));
						A[p.n][p.m + 1] = 0;
					}
				}
			}
			R += biggestNumber;

			ArrayList<Position> t = P0;
			P0 = P1;
			P1 = t;
			P1.clear();
		}
		Position p = P0.get(0);
		if (p.m == M - 1)
			for (int i = p.n + 1; i < N; i++)
				R += A[i][p.m];
		else if (p.n == N - 1)
			for (int i = p.m + 1; i < M; i++)
				R += A[p.n][i];
		return R;
	}
}
