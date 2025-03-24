// Game.java
public class Game {
  private Board board;
  private Player player1;
  private Player player2;
  private Player currentPlayer;
  private UI ui;

  public Game() {
    board = new Board();
    player1 = new Player("X");
    player2 = new Player("O");
    currentPlayer = player1;
    ui = new UI(this);
  }

  public void startGame() {
    board.resetBoard();
    currentPlayer = player1;
    ui.resetBoard();
  }

  public void switchPlayer() {
    currentPlayer = (currentPlayer == player1) ? player2 : player1;
  }

  public void makeMove(int row, int col) {
    if (board.placeMark(row, col, currentPlayer.getSymbol())) {
      ui.updateButton(row, col, currentPlayer.getSymbol());
      if (board.checkWin(currentPlayer.getSymbol())) {
        ui.displayWinner(currentPlayer);
        // Game automatically restarts in UI
      } else if (board.isFull()) {
        ui.displayDraw();
        // Game automatically restarts in UI
      } else {
        switchPlayer();
      }
    }
  }

  public Board getBoard() {
    return board;
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }
}