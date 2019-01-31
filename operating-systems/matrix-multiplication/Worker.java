public class Worker extends Thread {

    //private values for use by each thread
    private int r;
    private int c;
    private int m1_rows;
    private int m2_cols;
    private int m1_cols;
    private int[][] m1;
    private int[][] m2;
    private int[][] product;
    private int result = 0;

    //constructor
    public Worker (int r, int c, int m1_rows, int m2_cols, int m1_cols, int[][] m1, int[][] m2, int[][] product) {
        this.r = r;
        this.c = c;
        this.m1_rows = m1_rows;
        this.m2_cols = m2_cols;
        this.m1_cols = m1_cols;
        this.m1 = m1;
        this.m2 = m2;
        this.product = product;
    }

    //calculates resulting cell in the matrix when start() is called
    public void run() {

        for ( int i=0; i < m1_cols; i++) {
           result += m1[r][i] * m2[i][c];
        }

        product[r][c] = result;
        
    }
}