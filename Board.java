//File Name: Board.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class representing the state of the overworld, with its montains and lakes
import java.util.ArrayList;
import java.util.Random;
public class Board{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    String[] availableColors = {ANSI_BLACK, ANSI_RED, ANSI_GREEN,
            ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE};

    private Tile[][] board;
    public Board(){
        board = new Tile[8][8];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                Tile ourTile = new Tile(2);
                ourTile.setPiece(new Piece("Land"), 0);
                ourTile.setPiece(new Piece("Land"), 1);
                board[i][j] = ourTile;
            }
        }

        //now that we have our board, calculate the total number of tiles we are dealing with
        int totalTiles = 8*8;

        //we will have 10% mountain tiles and 10% lake tiles, 30% town tiles
        int mountainTiles = (int)(totalTiles * 0.1);
        int lakeTiles = (int)(totalTiles * 0.1);
        int marketTiles = (int)(totalTiles * 0.3);

        do{
            resetBoard();
            placeMountains(mountainTiles);
            placeLake(lakeTiles);
            placeMarket(marketTiles);
        }
        while(!canBeReached());
        replaceTilesWithSubclasses();
        placeHeroes();
    }
    public Board(int rows, int columns) {
        board = new Tile[rows][columns];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                Tile ourTile = new Tile(2);
                ourTile.setPiece(new Piece("Land"), 0);
                ourTile.setPiece(new Piece("Land"), 1);
                board[i][j] = ourTile;
            }
        }

        //now that we have our board, calculate the total number of tiles we are dealing with
        int totalTiles = rows*columns;

        //we will have 10% mountain tiles and 10% lake tiles, 30% town tiles
        int mountainTiles = (int)(totalTiles * 0.1);
        int lakeTiles = (int)(totalTiles * 0.1);
        int marketTiles = (int)(totalTiles * 0.3);

        do{
            resetBoard();
            placeMountains(mountainTiles);
            placeLake(lakeTiles);
            placeMarket(marketTiles);
        }
        while(!canBeReached());
        replaceTilesWithSubclasses();
        placeHeroes();
    }

    public void placeLake(int lakeTiles){
        Random rand = new Random();
        //pick a random tile to start our lake; make sure its not a mountain tile
        int lakeRow = rand.nextInt(board.length);
        int lakeColumn = rand.nextInt(board[0].length);

        while(board[lakeRow][lakeColumn].getPiece(0).getStringContents().equals("Mountain")){
            lakeRow = rand.nextInt(board.length);
            lakeColumn = rand.nextInt(board[0].length);
        }

        this.getTile(lakeRow, lakeColumn).setPiece(new Piece("Lake"), 0);

        while(lakeTiles > 0){
            //find all empty spots adjacent to the lake tile; each round, we will have an equal chance of putting the lake tile on that particular spot; if no spot if found,
            //we will pick a new location for a lake
            ArrayList<Tile> newLakeTiles = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    if(!board[i][j].getPiece(0).getStringContents().equals("Mountain") &&
                            !board[i][j].getPiece(0).getStringContents().equals("Lake")) {

                        boolean validTile = false;
                        //check the four sides if a lake exists on any of them, so long as it is within bounds
                        if (i > 0) {
                            if (board[i - 1][j].getPiece(0).getStringContents().equals("Lake")){
                                validTile = true;
                            }
                        }
                        if(i < board.length - 1){
                            if (board[i + 1][j].getPiece(0).getStringContents().equals("Lake")){
                                validTile = true;
                            }
                        }
                        if (j > 0) {
                            if (board[i][j - 1].getPiece(0).getStringContents().equals("Lake")){
                                validTile = true;
                            }
                        }
                        if(j < board[0].length - 1){
                            if (board[i][j + 1].getPiece(0).getStringContents().equals("Lake")){
                                validTile = true;
                            }
                        }
                        if(validTile){
                            newLakeTiles.add(board[i][j]);
                        }
                    }
                }
            }
            if(newLakeTiles.size() == 0){
                break;
            }
            else{
                //take one of those tiles and set it to be a lake piece!
                int randomIndex = rand.nextInt(newLakeTiles.size());
                newLakeTiles.get(randomIndex).setPiece(new Piece("Lake"), 0);
                lakeTiles--;
            }

        }
    }

    public void replaceTilesWithSubclasses(){
        for(int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {

                if (this.getTile(i, j).getPiece(0).getStringContents().equals("Market")) {
                    Tile ourTile = new MarketTile(2);
                    ourTile.setPiece(new Piece("Market"), 0);
                    ourTile.setPiece(new Piece("Land"), 1);
                    board[i][j] = ourTile;
                }
                else if (this.getTile(i, j).getPiece(0).getStringContents().equals("Land")) {
                    Tile ourTile = new FieldTile(2);
                    ourTile.setPiece(new Piece("Land"), 0);
                    ourTile.setPiece(new Piece("Land"), 1);
                    board[i][j] = ourTile;
                }
            }
        }
    }

    public void placeMarket(int marketTiles) {
        ArrayList<Tile> marketPlaceableTiles = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j].getPiece(0).getStringContents().equals("Mountain") &&
                        !board[i][j].getPiece(0).getStringContents().equals("Lake")) {
                    marketPlaceableTiles.add(board[i][j]);
                }
            }
        }
        Random rand = new Random();
        while(marketTiles > 0){
            //take one of those tiles and set it to be a Market piece!
            int randomIndex = rand.nextInt(marketPlaceableTiles.size());
            Tile newMarket = marketPlaceableTiles.get(randomIndex);
            newMarket.setPiece(new Piece("Market"), 0);
            marketTiles--;
            marketPlaceableTiles.remove(newMarket);
        }
    }

    public void placeHeroes() {
        ArrayList<Tile> heroPlacements = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j].getPiece(0).getStringContents().equals("Mountain") &&
                        !board[i][j].getPiece(0).getStringContents().equals("Lake") &&
                        !board[i][j].getPiece(0).getStringContents().equals("Market")) {
                    heroPlacements.add(board[i][j]);
                }
            }
        }
        Random rand = new Random();
        //take one of those tiles and set it to be a Hero piece!
        int randomIndex = rand.nextInt(heroPlacements.size());
        heroPlacements.get(randomIndex).setPiece(new Piece("Hero"), 1);
    }

    public void resetBoard(){
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j].setPiece(new Piece("Land"), 0);
                board[i][j].setPiece(new Piece("Land"), 1);
            }
        }
    }

    public void placeMountains(int mountainTiles){

        Random rand = new Random();
        //pick a random tile to start our mountain range... then it has to grow in a direction, so make a 2d array of coordinates
        int mountainRow = rand.nextInt(board.length / 2) + (board.length / 4);
        int mountainColumn = rand.nextInt(board[0].length / 2) + (board.length / 4);


        int[][] mountainCoordinates = new int[mountainTiles][2];
        //then, pick a direction for it to grow in, either left, right, up, down, or any diagonal
        int mountainDirection = rand.nextInt(4);
        //now fill those coordinates!

        //r and c will represent our current coordinate, we will see it and decide if we want to fill in the tile with a mountain
        int r = mountainRow;
        int c = mountainColumn;

        mountainCoordinates[0][0] = mountainRow;
        mountainCoordinates[0][1] = mountainColumn;
        for(int i = 1; i < mountainCoordinates.length; i++){
            //going north
            if(mountainDirection == 0){
                //so long as mountain coordinates do not exceed the top boundary, decrement r, then 60% chance its right there,
                //20 percent chance to the left, 20 percent chance to the right
                if(r > 0){
                    r--;
                    float stayInPlace = rand.nextFloat();
                    //if its less than 0.4, then try placing something either right or left; if we've reached a corner, we can just prematurely cut off
                    if(stayInPlace < 0.5){
                        //go right
                        if(stayInPlace < 0.25){
                            if(c < board[0].length - 1)
                                c++;
                            else
                                c--;
                        }
                        //go left
                        else{
                            if(c > 0)
                                c--;
                            else
                                c++;
                        }
                    }
                }
                else{
                    float rightOrLeft = rand.nextFloat();
                    //go left if possible
                    if(rightOrLeft < 0.5){
                        if(c > 0){
                            c--;
                        }
                        else{
                            c++;
                        }
                    }
                    else{
                        if(c < board[0].length - 1){
                            c++;
                        }
                        else{
                            c--;
                        }
                    }
                }

            }
            //southwards
            if(mountainDirection == 1){
                //so long as mountain coordinates do not exceed the top boundary, decrement r, then 60% chance its right there,
                //20 percent chance to the left, 20 percent chance to the right
                if(r < board.length - 1){
                    r++;
                    float stayInPlace = rand.nextFloat();
                    //if its less than 0.4, then try placing something either right or left; if we've reached a corner, we can just prematurely cut off
                    if(stayInPlace < 0.5){
                        //go right
                        if(stayInPlace < 0.25){
                            if(c < board[0].length - 1)
                                c++;
                            else
                                c--;
                        }
                        //go left
                        else{
                            if(c > 0)
                                c--;
                            else
                                c++;

                        }
                    }
                }
                else{
                    float rightOrLeft = rand.nextFloat();
                    //go left if possible
                    if(rightOrLeft < 0.5){
                        if(c > 0){
                            c--;
                        }
                        else{
                            c++;
                        }
                    }
                    else{
                        if(c < board[0].length - 1){
                            c++;
                        }
                        else{
                            c--;
                        }
                    }
                }
            }
            //eastwards
            if(mountainDirection == 2){
                //so long as mountain coordinates do not exceed the top boundary, decrement r, then 60% chance its right there,
                //20 percent chance to the left, 20 percent chance to the right
                if(c < board[0].length - 1){
                    c++;
                    float stayInPlace = rand.nextFloat();
                    //if its less than 0.4, then try placing something either right or left; if we've reached a corner, we can just prematurely cut off
                    if(stayInPlace < 0.5){
                        //go right
                        if(stayInPlace < 0.25){
                            if(r < board.length - 1)
                                r++;
                            else
                                r--;
                        }
                        //go left
                        else{
                            if(r > 0)
                                r--;
                            else
                                r++;
                        }
                    }
                }
                else{
                    float rightOrLeft = rand.nextFloat();
                    //go left if possible
                    if(rightOrLeft < 0.5){
                        if(r > 0){
                            r--;
                        }
                        else{
                            r++;
                        }
                    }
                    else{
                        if(r < board.length - 1){
                            r++;
                        }
                        else{
                            r--;
                        }
                    }
                }
            }
            //westwards
            if(mountainDirection == 3){
                //so long as mountain coordinates do not exceed the top boundary, decrement r, then 60% chance its right there,
                //20 percent chance to the left, 20 percent chance to the right
                if(c > 0){
                    c--;
                    float stayInPlace = rand.nextFloat();
                    //if its less than 0.4, then try placing something either right or left; if we've reached a corner, we can just prematurely cut off
                    if(stayInPlace < 0.5){
                        //go right
                        if(stayInPlace < 0.25){
                            if(r < board.length - 1)
                                r++;
                            else
                                r--;
                        }
                        //go left
                        else{
                            if(r > 0)
                                r--;
                            else
                                r++;
                        }
                    }
                }
                else{
                    float rightOrLeft = rand.nextFloat();
                    //go left if possible
                    if(rightOrLeft < 0.5){
                        if(r > 0){
                            r--;
                        }
                        else{
                            r++;
                        }
                    }
                    else{
                        if(r < board.length - 1){
                            r++;
                        }
                        else{
                            r--;
                        }
                    }
                }
            }
            mountainCoordinates[i][0] = r;
            mountainCoordinates[i][1] = c;
        }

        for(int i = 0; i < mountainCoordinates.length; i++){
            int boardRow = mountainCoordinates[i][0];
            int boardColumn = mountainCoordinates[i][1];
            this.getTile(boardRow, boardColumn).setPiece(new Piece("Mountain"), 0);
        }


    }

    private void dfs(int row, int col, int[][] arr) {
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] != 0) {
            // Out of bounds or already visited or impassable cell.
            return;
        }
        // Mark current cell as reachable
        arr[row][col] = 1;

        // Explore horizontally and vertically
        dfs(row + 1, col, arr); // Down
        dfs(row - 1, col, arr); // Up
        dfs(row, col + 1, arr); // Right
        dfs(row, col - 1, arr); // Left
    }

    //check the state of the board and make sure every single tile can reached from every other tile
    public boolean canBeReached(){
        int[][] mapSimulacra = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j].getPiece(0).getStringContents().equals("Mountain") || board[i][j].getPiece(0).getStringContents().equals("Lake")){
                    mapSimulacra[i][j] = -1;
                }
                else{
                    mapSimulacra[i][j] = 0;
                }
            }
        }

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j].getPiece(0).getStringContents().equals("Mountain") &&
                        !board[i][j].getPiece(0).getStringContents().equals("Lake")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        dfs(startRow, startCol, mapSimulacra);

        // Printing elements of the 2D array
        for (int i = 0; i < mapSimulacra.length; i++) {
            for (int j = 0; j < mapSimulacra[i].length; j++) {
                if(mapSimulacra[i][j] == 0)
                    return false;
            }
        }
        return true;

    }


    //get the value of a particular tile
    public Tile getTile(int x, int y){
        return board[x][y];
    };
    //set the value of a particular tile
    public void setTile(Tile value, int x, int y){
        board[x][y] = value;
    };

    public int getWidth(){
        return board[0].length;
    }
    public int getHeight(){
        return board.length;
    }

    public Tile[][] getBoard(){
        return board;
    }

    public Tile pressedW(){
        for(int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (this.getTile(i, j).getPiece(1).getStringContents().equals("Hero")){
                    if(i > 0 && !this.getTile(i - 1, j).getPiece(0).getStringContents().equals("Mountain")
                            && !this.getTile(i - 1, j).getPiece(0).getStringContents().equals("Lake")){
                        this.getTile(i - 1, j).setPiece(new Piece("Hero"), 1);
                        this.getTile(i, j).setPiece(new Piece("Land"), 1);
                        return null;
                    }
                }
            }
        }
        return null;
    }
    public Tile pressedA(){
        for(int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (this.getTile(i, j).getPiece(1).getStringContents().equals("Hero")){
                    if(j > 0 && !this.getTile(i, j - 1).getPiece(0).getStringContents().equals("Mountain")
                            && !this.getTile(i, j - 1).getPiece(0).getStringContents().equals("Lake")){
                        this.getTile(i, j - 1).setPiece(new Piece("Hero"), 1);
                        this.getTile(i, j).setPiece(new Piece("Land"), 1);
                        return null;
                    }
                }
            }
        }
        return null;
    }
    public Tile pressedD(){
        for(int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (this.getTile(i, j).getPiece(1).getStringContents().equals("Hero")){
                    if(j < board.length - 1 && !this.getTile(i, j + 1).getPiece(0).getStringContents().equals("Mountain")
                            && !this.getTile(i, j + 1).getPiece(0).getStringContents().equals("Lake")){
                        this.getTile(i, j + 1).setPiece(new Piece("Hero"), 1);
                        this.getTile(i, j).setPiece(new Piece("Land"), 1);
                        return null;
                    }
                }
            }
        }
        return null;
    }
    public Tile pressedS(){
        for(int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (this.getTile(i, j).getPiece(1).getStringContents().equals("Hero")){
                    if(i < board[0].length - 1 && !this.getTile(i + 1, j).getPiece(0).getStringContents().equals("Mountain")
                            && !this.getTile(i + 1, j).getPiece(0).getStringContents().equals("Lake")){
                        this.getTile(i + 1, j).setPiece(new Piece("Hero"), 1);
                        this.getTile(i, j).setPiece(new Piece("Land"), 1);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public String toString(){
        String boardRepresentation = "";
        //create our representation, row by row
        for(int i = 0; i < this.getHeight(); i++) {
            //create the border holding the numbers
            for (int j = 0; j < this.getWidth(); j++) {
                boardRepresentation += "+-------";
            }
            boardRepresentation += "+\n";

            for (int j = 0; j < this.getWidth(); j++) {
                boardRepresentation += "|\t";
                if(this.getTile(i,j).getPiece(1).getStringContents().equals("Hero"))
                    boardRepresentation += ANSI_WHITE +  "H" + ANSI_RESET;
                else if(this.getTile(i,j).getPiece(0).getStringContents().equals("Mountain"))
                    boardRepresentation += ANSI_PURPLE + "^" + ANSI_RESET;
                else if(this.getTile(i,j).getPiece(0).getStringContents().equals("Lake"))
                    boardRepresentation += ANSI_BLUE +  "~" + ANSI_RESET;
                else if(this.getTile(i,j).getPiece(0).getStringContents().equals("Market"))
                    boardRepresentation += ANSI_GREEN +  "M" + ANSI_RESET;
                else{
                    boardRepresentation += " ";
                }
                //we will modify this code when we need to actually represent stuff moving around
                boardRepresentation += " ";
                boardRepresentation += "\t";
            }
            boardRepresentation += "|\n";
        }
        //create the final line
        for (int j = 0; j < this.getWidth(); j++) {
            boardRepresentation += "+-------";
        }
        boardRepresentation += "+";
        return boardRepresentation;
    }

}
