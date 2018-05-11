
    import java.util.Scanner;

    class Player
    {

        private String name;
        private char sign;

        Player( String name, char sign )
        {
            this.name = name;
            this.sign = sign;
        }

        String getName()
        {
            return name;
        }

        char getSign()
        {
            return sign;
        }

        int[] turn()
        {
            Scanner in = new Scanner(System.in);
            System.out.print( name + " " + "Row: " + " " );
            int row = in.nextInt() - 1;
            System.out.println();
            System.out.print( name + " " + "Column: " + " " );
            int col = in.nextInt() - 1;
            return new int[]{row, col};
        }

    }