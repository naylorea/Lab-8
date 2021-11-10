import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class GuessingGame implements ActionListener {

JTextField userGuess;
JButton guessButton;
JButton playAgainButton;
JLabel jlabPrompt;
JLabel jlabScore;
JLabel jlabGuess;
Random r = new Random();
int randomNum = r.nextInt(100)+1;

GuessingGame() {
  JFrame frame = new JFrame("Guessing Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(240,120);
  userGuess = new JTextField(10);
  userGuess.setActionCommand("myTF");

  guessButton = new JButton("Guess");
  playAgainButton = new JButton("Play Again");

  userGuess.addActionListener(this);
  guessButton.addActionListener(this);
  playAgainButton.addActionListener(this);

  jlabPrompt = new JLabel("Enter your guess");
  jlabScore = new JLabel("");
  jlabGuess = new JLabel("");

  frame.add(jlabPrompt);
  frame.add(userGuess);
  frame.add(guessButton);
  frame.add(jlabScore);
  frame.add(jlabGuess);
  frame.add(playAgainButton);

  frame.setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
  if(ae.getActionCommand().equals("Guess")) {
    int guess = Integer.parseInt(userGuess.getText());
  if(guess < randomNum) {
    jlabScore.setText("Too low!");
  }
  else if(guess > randomNum) {
    jlabScore.setText("Too high!");
  }
  else {
    jlabScore.setText("You got it!");
  }
  jlabGuess.setText("Last guess was: " + guess);
  userGuess.setText("");
  }
  else if(ae.getActionCommand().equals("Play Again")) {
    int randomNumber = r.nextInt(100)+1;
    randomNum = randomNumber;
    jlabPrompt.setText("Enter your guess: ");
    jlabScore.setText("");
    jlabGuess.setText("");
    userGuess.setText("");
  }
  else {
    jlabScore.setText("You pressed enter. Please press the Guess Button");
  }

}

}