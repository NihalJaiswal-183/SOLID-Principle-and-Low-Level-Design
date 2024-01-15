package LLDSnakeAndLadder.Model;

public class Board{
     Cell[][] cells;

     public Board(int boardSize, int numberOfSnakes, int numberOfLadders){
        initializeCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
     }

     private void initializeCells(int boardSize) {

        cells = new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++) {
            for(int j=0; j<boardSize;j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders){

        while(numberOfSnakes > 0) {
           int snakeHead = (int)( Math.random() * (cells.length*cells.length-1)) + 1;
           int snakeTail = (int)( Math.random() * (cells.length*cells.length-1)) + 1;
           if(snakeTail >= snakeHead) {
               continue;
           }

           Jump snakeObj = new Jump();
           snakeObj.start = snakeHead;
           snakeObj.end = snakeTail;

           Cell cell = getCell(snakeHead);
           cell.isCellHaveJump = true;
           cell.jump = snakeObj;

            numberOfSnakes--;
        }

        while(numberOfLadders > 0) {
            int ladderStart = (int)( Math.random() * (cells.length*cells.length-1)) + 1;
            int ladderEnd = (int)( Math.random() * (cells.length*cells.length-1)) + 1;
            if(ladderStart >= ladderEnd) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump = ladderObj;
            cell.isCellHaveJump = true;

            numberOfLadders--;
        }

    }
    
    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }
}