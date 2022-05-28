class Spiral {
    static int[][] spiral(int rows, int columns) {
        int [][] spiral = new int[rows][columns];
        int start = 1;

        if (rows < 2){
            spiral[0][0] = 1;
            for (int i = 1; i < columns; i++) {
                spiral[0][i] = i+1;
            }
        }else {

            for (int i = 0; i < columns; i++) {
                spiral[0][i] = start;
                start++;
            }
            for (int i = 1; i < rows; i++) {
                spiral[i][columns - 1] = start;
                start++;
            }
            for (int i = columns - 2; i >= 0; i--) {
                spiral[rows - 1][i] = start;
                start++;
            }
            for (int i = rows - 2; i > 0; i--) {
                spiral[i][0] = start;
                start++;
            }

            int x = 1;
            int y = 1;

            while (start < rows * columns) {

                while (spiral[x][y + 1] == 0) {
                    spiral[x][y] = start;
                    start++;
                    y++;
                }

                while (spiral[x + 1][y] == 0) {
                    spiral[x][y] = start;
                    start++;
                    x++;
                }

                while (spiral[x][y - 1] == 0) {
                    spiral[x][y] = start;
                    start++;
                    y--;
                }

                while (spiral[x - 1][y] == 0) {
                    spiral[x][y] = start;
                    start++;
                    x--;
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (spiral[i][j] == 0) {
                        spiral[i][j] = start;
                    }
                }
            }

        }
        return spiral;
    }
}
