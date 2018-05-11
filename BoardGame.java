import java.util.InputMismatchException;

class BoardGame
    {

        private int num_row;
        private int num_col;
        private char[][] board;

        BoardGame( int num_row, int num_col )
        {
            this.num_row = num_row;
            this.num_col = num_col;
            board = new char[this.num_row][this.num_col];
        }

        void initBoard()
        {
            for (int i=0; i<num_row; i++){
                for (int j=0; j<num_col; j++)
                    board[i][j] = ' ';
            }
        }

        void viewBoard()
        {
            for (int i=0; i<num_row; i++){
                for (int j=0; j<num_col; j++)
                    System.out.print( "|" + " " + board[i][j] );
                System.out.println( "|" );
            }
        }

        void setValue( int[] block, char value ) throws ValueExists, ArrayIndexOutOfBoundsException, InputMismatchException
        {
            int row = block[0];
            int col = block[1];

            if ( board[row][col] != ' ')
                throw new ValueExists("Block already used.\nTry Again");
            else
                board[row][col] = value;
        }

        char getValue( int row, int col ) throws ArrayIndexOutOfBoundsException
        {
            return board[row][col];
        }

    }
