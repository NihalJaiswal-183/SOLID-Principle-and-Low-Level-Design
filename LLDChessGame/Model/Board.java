package LLDChessGame.Model;

import java.util.ArrayList;

public class Board{
    Cell[][] board;
    ArrayList<Piece> killPiece;

   public Board(){
       board = new Cell[8][8];
       killPiece = new ArrayList<Piece>();
       initliazeBoard();
   }

   public void initliazeBoard(){
       for(int i=0; i<8; i++){
           // whitePiece
           boolean isWhitePiece = true;
           int xCordinate = 0;
           int yCordinate = i;
           board[1][i] = new Cell(xCordinate, yCordinate, new Pawn(isWhitePiece));

           //blackPiece
           xCordinate = 6;
           board[6][i] = new Cell(xCordinate, yCordinate, new Pawn(!isWhitePiece));
       }
       // Setting White Pieces
       board[0][0] = new Cell(0, 0, new Rook(true));
       board[0][1] = new Cell(0, 1, new Knight(true));
       board[0][2] = new Cell(0, 2, new Bishop(true));
       board[0][3] = new Cell(0, 3, new Queen(true));
       board[0][4] = new Cell(0, 4, new King(true));
       board[0][5] = new Cell(0, 5, new Bishop(true));
       board[0][6] = new Cell(0, 6, new Knight(true));
       board[0][7] = new Cell(0, 7, new Rook(true));
       
       // Setting Black Pieces
       board[7][0] = new Cell(7, 0, new Rook(false));
       board[7][1] = new Cell(7, 1, new Knight(false));
       board[7][2] = new Cell(7, 2, new Bishop(false));
       board[7][3] = new Cell(7, 3, new Queen(false));
       board[7][4] = new Cell(7, 4, new King(false));
       board[7][5] = new Cell(7, 5, new Bishop(false));
       board[7][6] = new Cell(7, 6, new Knight(false));
       board[7][7] = new Cell(7, 7, new Rook(false));
    
   }

   public Cell getCell(int xCor, int yCor){
       return this.board[xCor][yCor];
   }

   private int[][] parseMoveString(String moveString){
       String[] parts = moveString.split(" ");
       int[][] move = new int[2][2];
       int[] start = {parts[0].charAt(0) - 'a', Integer.parseInt(parts[0].substring(1)) - 1};
       int[] end = {parts[1].charAt(0) - 'a', Integer.parseInt(parts[1].substring(1)) - 1};
       move[0] = start;
       move[1] = end;

       return move;
   }

   public boolean isValidMove(Player currentPlayer, String moveString) {

        int[][] move = parseMoveString(moveString);
        int[] start = move[0];
        int[] end = move[1];

        // Check if the move is within the board
        if (!(0 <= start[0] && start[0] < 8 && 0 <= start[1] && start[1] < 8 &&
                0 <= end[0] && end[0] < 8 && 0 <= end[1] && end[1] < 8)) {
            return false;
        }

        // Check if there is a piece at the start position
        if (board[start[0]][start[1]] == null) {
            return false;
        }

        // Check if the piece at the start position belongs to the current player
        if (!isOwnPiece(start, currentPlayer)) {
            return false;
        }

        // Validate the move using a move validator
        Piece piece = board[start[0]][start[1]].getPiece();
        Cell startCell = board[start[0]][start[1]];
        Cell endCell = board[end[0]][end[1]];
        return piece.canMove(startCell, endCell);
   }

   private boolean isOwnPiece(int[] start,Player currentPlayer){
       if(board[start[0]][start[1]].getPiece().isWhitePiece() != currentPlayer.isWhiteSide()){
           return false;
       }
       return true;
   }
   
   public void makeMove(String moveString){
       int[][] move = parseMoveString(moveString);
       Cell srcCell = board[move[0][0]][move[0][1]];
       Piece piece = srcCell.getPiece();
       Cell destCell = board[move[1][0]][move[1][1]];

       if(destCell.getPiece() != null){
           destCell.getPiece().setKilled();
           killPiece.add(destCell.getPiece());
       }
       
       srcCell.makeCellEmpty();
       destCell.setCell(piece);
   }

   public boolean isKingAlive(Player player){
       for(int i=0; i<8; i++){
           for(int j=0; j<8; j++){
               if(board[i][j].getPiece() instanceof King && board[i][j].getPiece().isWhitePiece() == player.isWhiteSide()){
                   return true;
               }
           }
       }
       return false;
   }

   private boolean hasLegalMoves(Player player){
       
       return false;
   }

   private boolean isDraw(Player player1, Player player2){
        return !hasLegalMoves(player1) && !isInCheck(player1) ||
        !hasLegalMoves(player2) && !isInCheck(player2);
   }

   public boolean isInCheck(Player player) {
    // Check if the specified player's king is in check
    // Implementation omitted for brevity
    return false;
    }

   public boolean isGameEnd(Player player1, Player player2) {
    // Check if one of the players' kings is captured or if it's a draw
        return !isKingAlive(player1) || !isKingAlive(player2) || isDraw(player1, player2);
}

   public void display(){

   }
}