package Controllers;
import javafx.scene.control.*;

public class ScoresController {
    private Label computerScoreLabel;
    private Label userScoreLabel;
    private Label whoWinsGameLabel ;


    public ScoresController(Label computerScoreLabel , Label userScoreLabel , Label whoWinsGameLabel){
        this.computerScoreLabel = computerScoreLabel;
        this.userScoreLabel = userScoreLabel;
        this.whoWinsGameLabel = whoWinsGameLabel ;
    }


    public void updateScores(){
        if(whoWinsGameLabel.getText().startsWith("C")) {
            int previousScore = Integer.parseInt(computerScoreLabel.getText().split("[:]")[1]);
            computerScoreLabel.setText("");
            computerScoreLabel.setText("Computer:"+(previousScore+1));
        }
        else
        {
            userScoreLabel.setText("");
            int previousScore = Integer.parseInt(computerScoreLabel.getText().split("[:]")[1]);
            userScoreLabel.setText("User:"+(previousScore+1));
        }

    }
}
