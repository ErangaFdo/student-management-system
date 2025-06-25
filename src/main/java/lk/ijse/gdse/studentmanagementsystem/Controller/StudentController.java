package lk.ijse.gdse.studentmanagementsystem.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.studentmanagementsystem.Dto.StudentDto;
import lk.ijse.gdse.studentmanagementsystem.Dto.Tm.StudentTm;
import lk.ijse.gdse.studentmanagementsystem.Model.StudentModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

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
    private TableView<StudentTm> studentTable;

    @FXML
    void btnClearOnAction(ActionEvent event) throws SQLException {
        refreshPage();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String ID = lblID.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = studentModel.deleteStudent(ID);
            if (isDeleted) {
                loadStudent();
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
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
            loadStudent();
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Customer saved...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Customer  not saved").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String studentID = lblID.getText();
        String name = lblNAME.getText();
        String address = lblADDRESS.getText();
        String bday = lblBDAY.getText();
        String age = lblAGE.getText();
        String mnum = lblMNUM.getText();

        StudentDto studentDto = new StudentDto(studentID, name, address, bday, age, mnum);
        boolean isSave = studentModel.updateStudent(studentDto);

        if (isSave) {
            loadStudent();
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Customer update...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Customer  not updated").show();
        }

    }

    private void refreshPage() throws SQLException {


        btnSave.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);


        lblID.setText("");
        lblNAME.setText("");
        lblADDRESS.setText("");
        lblBDAY.setText("");
        lblAGE.setText("");
        lblMNUM.setText("");
        lblID.requestFocus();

    }

    private void loadStudent() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDto> studentDtos = studentModel.getAllStudent();
        ObservableList<StudentTm> studentTms = FXCollections.observableArrayList();

          for (StudentDto studentDto : studentDtos) {
              StudentTm studentTm = new StudentTm();
              studentTm.setStudentId(studentDto.getStudentId());
              studentTm.setStudentName(studentDto.getStudentName());
              studentTm.setStudentAddress(studentDto.getStudentAddress());
              studentTm.setStudentBdy(studentDto.getStudentBdy());
              studentTm.setStudentAge(studentDto.getStudentAge());
              studentTm.setStudentPhoneNumber(studentDto.getStudentPhoneNumber()
              );
              studentTms.add(studentTm);
          }

          studentTable.setItems(studentTms);
    }






    @FXML
    void tableOnClick(MouseEvent event) {
               StudentTm studentTm = (StudentTm) studentTable.getSelectionModel().getSelectedItem();
               if (studentTm != null) {
                   lblID.setText(studentTm.getStudentId());
                   lblNAME.setText(studentTm.getStudentName());
                   lblADDRESS.setText(studentTm.getStudentAddress());
                   lblBDAY.setText(studentTm.getStudentBdy());
                   lblAGE.setText(studentTm.getStudentAge());
                   lblMNUM.setText(studentTm.getStudentPhoneNumber());

                   btnSave.setDisable(true);
                   btnUpdate.setDisable(false);
                   btnDelete.setDisable(false);

               }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("StudentAddress"));
        clmBday.setCellValueFactory(new PropertyValueFactory<>("StudentBdy"));
        clmAge.setCellValueFactory(new PropertyValueFactory<>("StudentAge"));
        clmMnum.setCellValueFactory(new PropertyValueFactory<>("StudentPhoneNumber"));

        try {
            loadStudent();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
