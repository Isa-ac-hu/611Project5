//File Name: Tile.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class that represents a space on the board, usually replaced by Market or Field tiles if interactable
import java.util.ArrayList;
import java.util.Scanner;

public class Tile implements InteractionStrategy{
    private Piece[] contents;
    public Tile(){
        contents = new Piece[1];
    }

    public Tile(int numPieces){
        if(numPieces > 0){
            contents = new Piece[numPieces];
        }
        else{
            contents = new Piece[1];
        }
    }


    public void setPiece(Piece piece, int index){
        contents[index] = piece;
    }
    public Piece[] getContents(){
        return contents;
    }
    public Piece getPiece(int index){
        return contents[index];
    }

    @Override
    public void interact(ArrayList<Hero> players, Scanner scanner, Tile tile) {

    }
}
