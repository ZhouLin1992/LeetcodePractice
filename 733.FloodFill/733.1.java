class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        floodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void floodFill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        
        image[sr][sc] = newColor;
        floodFill(image, sr + 1, sc, color, newColor);
        floodFill(image, sr - 1, sc, color, newColor);
        floodFill(image, sr, sc + 1, color, newColor);
        floodFill(image, sr, sc - 1, color, newColor);
    }
}