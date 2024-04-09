//File Name: Piece.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: An object that exists on top of a tile, to give an indicator to the toString method as to what kind of terrain to place on the tile
public class Piece {
    private Object piece;

    //A tile is a type of object that takes two kinds of contents, an int or a string
    //a tile containing a number must also specify the min and max range.
    public Piece(){
        piece = null;
    }
    public Piece(int input){
        piece = input;
    }
    public Piece(String input){
        piece = input;
    }

    //here is how we extract the contents of an integer tile; if we try to extract an integer on a tile
    //that doesn't have one, we will return -1
    public int getIntContents(){
        try{
            int number = (int)piece;
            return number;
        }
        catch(NumberFormatException ex) {
            System.out.println("contents of tile do not contain an integer");
            return -1;
        }
    }

    //here is how we extract the contents of a String tile; if we try to extract a String on a tile
    //that doesn't have one, we will return an empty string
    public String getStringContents(){
        try{
            String str = (String)piece;
            return str;
        }
        catch(Exception ex) {
            System.out.println("contents of tile do not contain a string");
            return "";
        }
    }

}
