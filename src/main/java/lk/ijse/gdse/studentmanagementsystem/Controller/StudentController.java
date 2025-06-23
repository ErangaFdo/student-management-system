package lk.ijse.gdse.studentmanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.studentmanagementsystem.Dto.StudentDto;
import lk.ijse.gdse.studentmanagementsystem.Model.StudentModel;

import java.sql.SQLException;

public class StudentController {

    StudentModel studentModel = new StudentModel();

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> clmAddress;

    @FXML
    private TableColumn<?, ?> clmAge;

    @FXML
    private TableColumn<?, ?> clmBday;

    @FXML
    private TableColumn<?, ?> clmId;

    @FXML
    private TableColumn<?, ?> clmMnum;

    @FXML
    private TableColumn<?, ?> clmName;

    @FXML
    private TextField lblADDRESS;

    @FXML
    private TextField lblAGE;

    @FXML
    private TextField lblBDAY;

    @FXML
    private TextField lblID;

    @FXML
    private TextField lblMNUM;

    @FXML
    private TextField lblNAME;

    @FXML
    private AnchorPane studentAnchorPane;

    @FXML
    private TableView<?> studentTable;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
             String studentID = lblID.getText();
             String name = lblNAME.getText();
             String address = lblADDRESS.getText();
             String bday = lblBDAY.getText();
             String age = lblAGE.getText();
             String mnum = lblMNUM.getText();

        StudentDto studentDto = new StudentDto(studentID, name, address, bday, age, mnum);
        boolean isSave = studentModel.saveStudent(studentDto);

        if (isSave) {
            new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Customer  not saved").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
