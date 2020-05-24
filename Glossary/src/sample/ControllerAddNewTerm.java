package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAddNewTerm {
    @FXML
    private Button new_term;

    @FXML
    private TextField term;

    @FXML
    private TextArea term_description;

    @FXML
    private Button cancel;

    @FXML
    void initialize() {
        new_term.setOnAction(event -> {
            addNewTerm();
        });
        cancel.setOnAction(event -> {
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.close();
        });
    }

    private void addNewTerm() {
        String termNew = term.getText();
        String description = term_description.getText();
        Term terms = new Term(termNew, description);
        Database.addNewTerm(terms);
        term.clear();
        term_description.clear();
    }
}
