
    import java.lang.Math;
    import java.util.InputMismatchException;
    import java.util.Scanner;

    class TicTacToe extends BoardGame
    {
        private int numPlayers = 2;
        private Player[] player = new Player[numPlayers];

        TicTacToe()
        {
            super( 3, 3 );
        }

        void initGame()
        {
            initBoard();
            for ( int i = 0; i<numPlayers; i++ ) {
                Scanner in = new Scanner(System.in);
                System.out.printf("Name of the player %d: ", i+1);
                String name = in.next();
                System.out.println();
                System.out.print("Pick a sign to play: ");
                char sign = in.next().charAt(0);
                System.out.println();
                player[i] = new Player( name, sign );
            }
        }

        DetermineResult play()
        {
            int turn = 0;
            boolean win = false;
            while ( win != true && turn <= 9 ){
                for (int i=0; i<numPlayers && win != true && turn <= 9; i++) {
                    int[] block;
                    viewBoard();
                    block = move(i);
                    if (++turn > 4)
                        win = checkWin( block );
                }
            }
            return new DetermineResult( win, turn );
        }

        int[] move( int p )
        {
            int[] block;
            try {
                block = player[p].turn();
                setValue( block, player[p].getSign() );
            } catch ( ValueExists e) {
                System.out.println(e.getMessage());
                return move(p);
            } catch ( ArrayIndexOutOfBoundsException e) {
                System.out.println("Block does not exists.\nTry Again");
                return move(p);
            } catch ( InputMismatchException e) {
                System.out.println("Invalid Input");
                return move(p);
            }
            return block;
        }

        boolean checkWin( int[] block )
        {
            boolean win;
            int row = block[0];
            int col = block[1];

            if ( getValue(0, col) == getValue(1, col) && getValue(1, col) == getValue(2, col) )
                win = true;
            else if ( getValue(row, 0) == getValue(row, 1) && getValue(row, 1) == getValue(row, 2) )
                win = true;
            else if ( row == col && getValue(0, 0) == getValue(1, 1) && getValue(1, 1) == getValue(2, 2) )
                win = true;
            else if ( Math.abs(row-col) == 2 && getValue(2, 0) == getValue(1, 1) && getValue(1, 1) == getValue(0, 2) )
                win = true;
            else
                win = false;

            return win;
        }

        void declareWin( int numTurn ) {
            System.out.println("Congratulations : " + player[(numTurn-1)%2].getName() + "\nYou finished the game in just " + numTurn + "turns.");
        }

        void declareDraw()
        {
            System.out.println("Game Drawn");
        }

    }
    