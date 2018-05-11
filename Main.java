
    final class DetermineResult
    {
        final boolean win;
        final int turn;

        DetermineResult(boolean win, int turn )
        {
            this.win = win;
            this.turn = turn;
        }
    }

    class Main
    {

        public static void main(String[] args)
        {

            TicTacToe game = new TicTacToe();
            game.initGame();
            DetermineResult result = game.play();
            if ( result.win ) {
                game.declareWin( result.turn );
                game.viewBoard();
            }
            else {
                game.declareDraw();
                game.viewBoard();
            }

        }

    }