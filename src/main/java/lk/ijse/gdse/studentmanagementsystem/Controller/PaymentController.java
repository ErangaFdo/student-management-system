package lk.ijse.gdse.studentmanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PaymentController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> clmAmount;

    @FXML
    private TableColumn<?, ?> clmAttedentDate;

    @FXML
    private TableColumn<?, ?> clmDiscount;

    @FXML
    private TableColumn<?, ?> clmPaymentId;

    @FXML
    private TableColumn<?, ?> clmStudentId;

    @FXML
    private TextField lblAmount;

    @FXML
    private TextField lblAttendentDate;

    @FXML
    private TextField lblDiscount;

    @FXML
    private TextField lblPaymentId;

    @FXML
    private TextField lblStudentId;

    @FXML
    private AnchorPane paymentAnchorPane;

    @FXML
    private TableView<?> paymentTable;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void tableOnClick(MouseEvent event) {

    }

}
