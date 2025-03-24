// Board.java
public class Board {

  private String[][] grid; // Declaration here

  public Board() {
    grid = new String[3][3]; // Usage in the constructor
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        grid[i][j] = "";
      }
    }
  }

  public boolean placeMark(int row, int col, String player) {
    if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col].isEmpty()) {
      grid[row][col] = player;
      return true;
    }
    return false;
  }

  public String getCell(int row, int col) {
    if (row >= 0 && row < 3 && col >= 0 && col < 3) {
      return grid[row][col];
    }
    return null;
  }

  public boolean isFull() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grid[i][j].isEmpty()) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean checkWin(String player) {
    // Check rows
    for (int i = 0; i < 3; i++) {
      if (grid[i][0].equals(player) && grid[i][1].equals(player) && grid[i][2].equals(player)) {
        return true;
      }
    }
    // Check columns
    for (int j = 0; j < 3; j++) {
      if (grid[0][j].equals(player) && grid[1][j].equals(player) && grid[2][j].equals(player)) {
        return true;
      }
    }
    // Check diagonals
    if (grid[0][0].equals(player) && grid[1][1].equals(player) && grid[2][2].equals(player)) {
      return true;
    }
    if (grid[0][2].equals(player) && grid[1][1].equals(player) && grid[2][0].equals(player)) {
      return true;
    }
    return false;
  }

  public void resetBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        grid[i][j] = "";
      }
    }
  }
}