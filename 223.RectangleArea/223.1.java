public class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		return (C - A) * (D - B) + (G - E) * (H - F) - computeArea(A, C, E, G) * computeArea(B, D, F, H);
	}

	public int computeArea(int A, int C, int E, int G) {
		if (A < E && E < C && G <= C) return G - E;
		if (A <= E && E < C && C <= G) return C - E;
		if (C <= E) return 0;
		if (G <= A) return 0;
		if (E <= A && A < G && G <= C) return G - A;
		if (E <= A && A < G && C <= G) return C - A;
	}
}