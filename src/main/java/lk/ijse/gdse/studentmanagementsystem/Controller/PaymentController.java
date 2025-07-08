package lk.ijse.gdse.studentmanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.studentmanagementsystem.Dto.PaymentDto;
import lk.ijse.gdse.studentmanagementsystem.Model.PaymentModel;

import java.sql.SQLException;

public class PaymentController {

    PaymentModel paymentModel = new PaymentModel();

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
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
         String paymentId = lblPaymentId.getText();
         String attendentDate = lblAttendentDate.getText();
         String amount = lblAmount.getText();
         String discount = lblDiscount.getText();
         String studentId = lblStudentId.getText();

        PaymentDto paymentDto = new PaymentDto(paymentId, attendentDate, amount, discount, studentId);
        boolean isSave = paymentModel.savePayment(paymentDto);

        if (isSave) {

            new Alert(Alert.AlertType.INFORMATION, "Payment Saved...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Payment  not save").show();
        }

    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String paymentId = lblPaymentId.getText();
        String attendentDate = lblAttendentDate.getText();
        String amount = lblAmount.getText();
        String discount = lblDiscount.getText();
        String studentId = lblStudentId.getText();

        PaymentDto paymentDto = new PaymentDto(paymentId, attendentDate, amount, discount, studentId);
        boolean isSave = paymentModel.updatePayment(paymentDto);

        if (isSave) {

            new Alert(Alert.AlertType.INFORMATION, "Payment Update...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Payment  not Updated").show();
        }

    }

    @FXML
    void tableOnClick(MouseEvent event) {

    }

}
