// UI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {
  private Game game;
  private TTTTileButton[][] boardButtons;

  public UI(Game game) {
    super("Tic Tac Toe");
    this.game = game;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(3, 3));
    boardButtons = new TTTTileButton[3][3];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        boardButtons[i][j] = new TTTTileButton(i, j);
        boardButtons[i][j].addActionListener(this);
        add(boardButtons[i][j]);
      }
    }

    setSize(300, 300);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    TTTTileButton clickedButton = (TTTTileButton) e.getSource();
    int row = clickedButton.getRow();
    int col = clickedButton.getCol();
    game.makeMove(row, col);
  }

  public void updateButton(int row, int col, String symbol) {
    boardButtons[row][col].setSymbol(symbol);
  }

  public void displayWinner(Player player) {
    JOptionPane.showMessageDialog(this, "Player " + player.getSymbol() + " wins!");
    game.startGame(); // Start a new game after a win
  }

  public void displayDraw() {
    JOptionPane.showMessageDialog(this, "It's a draw!");
    game.startGame(); // Start a new game after a draw
  }

  public void resetBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        boardButtons[i][j].setText("");
      }
    }
  }
}