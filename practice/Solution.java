import java.util.*;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCutsDim(rectangles, 0) || checkCutsDim(rectangles, 1);
    }

    private boolean checkCutsDim(int[][] rectangles, int dim) {
        int gaps = 0;
        Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);

        int end = rectangles[0][dim+2];
        for (int i = 1; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];

            if (end <= rectangle[dim]) {
                gaps++;
                if (gaps > 2) return true;
            }
            end = Math.max(end, rectangle[dim+2]);
        }

        return false;
    }
}