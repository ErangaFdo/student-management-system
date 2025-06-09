package lk.ijse.gdse.studentmanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private AnchorPane AnchorPaneLogin;

    @FXML
    private TextField TextUserPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField textUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String userName = textUserName.getText();
        String password = TextUserPassword.getText();

        if(userName.equals("admin") && password.equals("1234")){
            AnchorPaneLogin.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/HomeForm.fxml"));
            AnchorPaneLogin.getChildren().add(load);
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid Username or Password").show();
        }

    }

}
