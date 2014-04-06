package jftha.main;

import jftha.spaces.SpaceEnum;

public class BoardTest {
    Board board = new Board();
    
    public static void main(String[] args) {
        BoardTest bt = new BoardTest();
        bt.board.iterateBoard();
        int num = bt.board.iterator();
        System.out.println(num);
    }
    
    public BoardTest(){
        for(int i = 0; i < 15; i++){
            if(i == 2){
                board.addSpace(SpaceEnum.Store);
            }else if(i == 4){
                board.addSpace(SpaceEnum.Chest);
            }else if(i == 6){
                board.addSpace(SpaceEnum.D2D);
            }else if(i == 8){
                board.addSpace(SpaceEnum.Gold);
            }else if(i == 10){
                board.addSpace(SpaceEnum.Health);
            } else if(i == 12) {
                board.addSpace(SpaceEnum.Card);
            }
            else{
                board.addSpace(SpaceEnum.Blank);
            }
        }
    }
    //At least one of every space
    //added is method for each spaces
    //Make it so character would know which spot they landed on
}
