package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class Controller {
    @FXML
    private Button sassoButton;
    @FXML
    private Button cartaButton ;
    @FXML
    private Button forbiceButton;
    @FXML
    private Label whoWinsGameLabel;
    @FXML
    private Label computerChoiceLabel;
    @FXML
    private Label userChoice;
    @FXML
    private Label userScoreLabel;
    @FXML
    private Label computerScoreLabel;

    //Secondary Controllers:
    private ScoresController scoresController;

    public void initialize(){
        scoresController = new ScoresController(computerScoreLabel,userScoreLabel,whoWinsGameLabel);

    }


    /**
     * Sceglie come mossa Sasso e calcola la mossa del computer,dopo verifica chi ha vinto
     * @param actionEvent
     *
     */
    @FXML
    public void sassoChoice(ActionEvent actionEvent) {
        resetAll();
        StringBuffer sb = new StringBuffer(computerChoiceLabel.getText());
        sb.append(calcolaMossaComputer());
        computerChoiceLabel.setText(sb.toString());
        verifyWinner("Sasso");
        scoresController.updateScores();

    }
@FXML
    public void cartaChoice(ActionEvent actionEvent) {
    resetAll();
    StringBuffer sb = new StringBuffer(computerChoiceLabel.getText());
    sb.append(calcolaMossaComputer());
    computerChoiceLabel.setText(sb.toString());
        verifyWinner("Carta");
        scoresController.updateScores();
    }
@FXML
    public void forbiceChoice(ActionEvent actionEvent)
    {
        resetAll();
        StringBuffer sb = new StringBuffer(computerChoiceLabel.getText());
        sb.append(calcolaMossaComputer());
        computerChoiceLabel.setText(sb.toString());
        verifyWinner("Forbice");
        scoresController.updateScores();
    }


    private String calcolaMossaComputer(){
        Random r = new Random();
        String mossa = "";
        int el = r.nextInt(3);
       if(el == 0) return "Sasso";
       if(el==1) return "Forbice";
       else
           return "Carta";
    }

    private void verifyWinner(String userChoice){

        String computerChoice = computerChoiceLabel.getText().split("[:]")[1].trim();
        if(computerChoice.trim().equals(userChoice.trim())) {
            whoWinsGameLabel.setText("Nobody wins");
            return;
        }
        if(userChoice.equals("Sasso")){
            if(computerChoice.equals("Forbice")) whoWinsGameLabel.setText("User wins");
            if(computerChoice.equals("Carta"))  whoWinsGameLabel.setText("Computer wins");
        }

        if(userChoice.equals("Forbice")){
            if(computerChoice.equals("Carta")) whoWinsGameLabel.setText( "User wins");
            if(computerChoice.equals("Sasso")) whoWinsGameLabel.setText("Computer wins");
        }

        if(userChoice.equals("Carta")){
            if(computerChoice.equals("Sasso")) whoWinsGameLabel.setText("User wins");
           else
               whoWinsGameLabel.setText("Computer wins");


        }

    }

    private void resetAll(){
        whoWinsGameLabel.setText("");
        computerChoiceLabel.setText("Computer choice: ");
    }


}
