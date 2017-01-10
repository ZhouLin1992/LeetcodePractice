/* 
指针模拟栈法：
假设序列是[10, 5, 2, 6, 12]，遍历序列到第n个数时，栈中情况是这样的：
1 | 10
2 | 10 5
3 | 10 5 2
4 | 10 6
5 | 12
分析可得：栈的大小不会超过当前遍历的数的位置，可以用之前遍历过的部分当做栈
用纸镇i标记栈顶
*/

public class Solution {
	public boolean verifyPreorder(int[] preorder) {
		// help to point at the top of stack (array here works as a stack)
		// 标记栈顶
		// i初始化为-1,这样第一个元素加入时不会越界
		int i = -1, low = Integer.MIN_VALUE;
		for (int num: preorder) {
			// break the minimum rules
			if (num < low) {
				return false;
			}
			// 将数组当做栈，每pop一次相当于i--
			while (i >= 0 && num > preorder[i]) {
				low = preorder[i--];
			}
			// push相当于i++
			preorder[++i] = num;
		}
		return true;
	}
}