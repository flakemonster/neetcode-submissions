class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int l0=0;
        int r0=rows-1;
        int mid0;

        while(l0<=r0){
            mid0=(l0+r0)/2;
            if(matrix[mid0][0]<=target && target<=matrix[mid0][cols-1]){
                return searchInRow(matrix, target, mid0);
            } else if(target<matrix[mid0][0]) {
                r0=mid0-1;
            } else if(target>matrix[mid0][0]) {
                l0=mid0+1;
            }
        }
        return false;
    }

    public boolean searchInRow(int[][] matrix, int target, int row){
        int l=0;
        int r=matrix[0].length;
        int mid;
        while(l<=r) {
            mid=(l+r)/2;
            if(matrix[row][mid]==target)
                return true;
            if(matrix[row][mid]>target){
                r=mid-1;
            } else if(matrix[row][mid]<target){
                l=mid+1;
            }
        }
        return false;
    }
}
