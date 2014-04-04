package jftha.main;

public class BoardTest {
    Board board = new Board();
    
    public static void main(String[] args) {
        BoardTest bt = new BoardTest();
        bt.board.iterateBoard();
        int num = bt.board.iterator();
        System.out.println(num);
    }
    
    public BoardTest(){
        for(int i = 0; i < 30; i++){
            if(i == 5){
                board.addSpace(i, true, false, false, false, false);
            }else if(i == 10){
                board.addSpace(i, false, true, false, false, false);
            }else if(i == 15){
                board.addSpace(i, false, false, true, false, false);
            }else if(i == 20){
                board.addSpace(i, false, false, false, true, false);
            }else if(i == 25){
                board.addSpace(i, false, false, false, false, true);
            }
            else{
                board.addSpace(i, false, false, false, false, false);
            }
        }
    }
    //At least one of every space
    //added is method for each spaces
    //Make it so character would know which spot they landed on
}
