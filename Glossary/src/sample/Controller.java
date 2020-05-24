package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.TimerTask;

public class Controller {
    private int count;

    @FXML
    private AnchorPane window;

    @FXML
    private Text term;

    @FXML
    private Text termDescription;

    @FXML
    private Button addNewTerm;

    @FXML
    private Button deleteTerm;

    @FXML
    void initialize() {
        getTermRandom();

        addNewTerm.setOnAction(event -> {
            String scene = "app.fxml";
            openNewScene(scene);
        });

        deleteTerm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAlertWithoutHeaderText();
            }
        });

        NeoTimer.getInstance().schedule(new TimerTask() {
                                            public void run() {
                                                getTermRandom();
                                            }
                                        },
                0, 20000);

    }

    private void getTermRandom() {
       ArrayList<Term> list = Database.getRandomTerm();
       count = list.size()-1;
        if (count > 0) {
            term.setText(list.get(count).getTerm());
            termDescription.setText(list.get(count).getDescription());
            count--;
        }
        if (count == 0) {
            list.clear();
            list = Database.getRandomTerm();
            count = list.size()-1;
        }
    }

    private void openNewScene(String name) {
        addNewTerm.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(name));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void showAlertWithoutHeaderText() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Удалить?");
        alert.setHeaderText(null);
        alert.setContentText(term.getText());
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == ButtonType.OK) {
            deleteTerm();
        }
    }

    private void deleteTerm() {
        Term termElem = new Term(term.getText(), termDescription.getText());
        Database.deletTerm(termElem);
    }
}
