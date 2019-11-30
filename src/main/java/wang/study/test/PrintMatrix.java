package wang.study.test;

public class PrintMatrix {
    public static void main(String[] args) {
        int[][] rectangle = new int[][]{
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5}
        };
        printRectangle(rectangle);
    }

    private static void printRectangle(int[][] rectangle) {
        int j = 0;
        for(int num = 0;num < rectangle.length + rectangle[0].length - 1;num++){
            for(int i = 0;i < rectangle.length;i++){
                j = num - i;
                if((j >= 0) && j < rectangle[0].length) {
                    System.out.print(rectangle[i][j]);
                }
            }
            System.out.println();
        }
    }
}
