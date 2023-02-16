import java.util.Scanner;
public class TickTacToe {
    public static void main(String[] args) {
       
        System.out.print("Let's play Tick-Tae-Toe!!!");
        char[][] board = {
            { '_', '_', '_' },
            { '_', '_', '_' },
            { '_', '_', '_' }
        };
        displayBoard(board);
        for(int i=0;i<9;i++){
            if(i%2==0){
                System.out.println("Turn X:");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';   //0=> returns the row and 1=> returns the column
            }
            else{
                System.out.println("Turn O:");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';  //0=> returns the row and 1=> returns the column
            }
            displayBoard(board);
            int count = checkWin(board);
            if(count == 3){
                System.out.print("X wins!!!");
                break;
            }
            else if(count == -3){
                System.out.print("O wins!!!");
                break;
            }
            else if(i == 8){
                System.out.print("It's a tie!!");
            }
        }
    }
    public static void displayBoard(char[][] board){
        System.out.print("\n");
        for(int i=0;i<board.length;i++){
            System.out.print("\t");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.print("\n\n");
        }
    }
    public static int[] askUser(char[][] board){    //int[] => function returns an array
        Scanner read = new Scanner(System.in);
        System.out.print("Pick a row and a column number: ");
        int row = read.nextInt();
        int column = read.nextInt();
        while(board[row][column] =='X' || board[row][column] == 'O'){
            System.out.print("Spot picked already!!;Try picking a new spot");
            row = read.nextInt();
            column = read.nextInt();
        }
        read.close();
        return new int[] {row,column};  //return the spot that the user chooses
    }
    public static int checkWin(char[][] board){
        int count = 0;
        for(int i=0;i<board.length;i++){        //horizontal check
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 'X'){
                    count++;
                }
                else if(board[i][j] == 'O'){
                    count--;
                } 
            }
            if(count == 3 || count == -3){  //to check if the condition satisfies; if yes break the if condition by breaking the loop else set the count back to 0
                return count;
            }
            else{
                count = 0;                  //cuz the next inner should counting from zero
            }
        }
        for(int i=0;i<3;i++){                //vertical check
            for(int j=0;j<board.length;j++){
                if(board[j][i] == 'X'){
                    count++;
                }
                else if(board[j][i] == 'O'){
                    count--;
                }
            }
            if(count == 3 || count == -3){
                return count;
            }
            else{
                count = 0;
            }
        }
        for(int i=0;i<3;i++){          //left diagonal check => 0 0 ; 1 1 ; 2 2
            if(board[i][i] == 'X'){
                count++;
            }
            else if(board[i][i] == 'O'){
                count--;
            }
        }
        if(count == 3 || count == -3){
            return count;
        }
        else{
            count = 0;
        }
        for(int i=0;i<3;i++){         //right diagonal check => 2 0 ; 1 1 ; 0 2
            int rowCheck = 2-i;
            if(board[rowCheck][i] == 'X'){
                count++;
            }
            else if(board[rowCheck][i] == 'O'){
                count--;
            }
        }
        if(count == 3 || count == -3){
            return count;
        }
        else{
            count = 0;
        }
        return count;
    }
}
