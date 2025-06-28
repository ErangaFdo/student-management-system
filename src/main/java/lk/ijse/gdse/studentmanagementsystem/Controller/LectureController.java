package lk.ijse.gdse.studentmanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.studentmanagementsystem.Dto.LectureDto;
import lk.ijse.gdse.studentmanagementsystem.Model.LectureModel;

import java.sql.SQLException;
import java.util.Optional;

public class LectureController {

    LectureModel lectureModel = new LectureModel();

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> clmAdress;

    @FXML
    private TableColumn<?, ?> clmAge;

    @FXML
    private TableColumn<?, ?> clmCourseId;

    @FXML
    private TableColumn<?, ?> clmId;

    @FXML
    private TableColumn<?, ?> clmMnum;

    @FXML
    private TableColumn<?, ?> clmName;

    @FXML
    private TextField lblADRESS;

    @FXML
    private TextField lblAGE;

    @FXML
    private TextField lblCoureseId;

    @FXML
    private TextField lblID;

    @FXML
    private TextField lblMNUM;

    @FXML
    private TextField lblNAME;

    @FXML
    private AnchorPane lectureAnchorPane;

    @FXML
    private TableView<?> lectureTable;

    @FXML
    void btnClearOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String ID = lblID.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = lectureModel.deleteLecture(ID);
            if (isDeleted) {

                new Alert(Alert.AlertType.INFORMATION, "Lecture deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete Lecture...!").show();
            }
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
          String lecId = lblID.getText();
          String lecName = lblNAME.getText();
          String age = lblAGE.getText();
          String adress = lblADRESS.getText();
          String phone = lblMNUM.getText();
          String courseId = lblCoureseId.getText();

        LectureDto lectureDto = new LectureDto(lecId, lecName, age,adress, phone, courseId);
        boolean isSave = lectureModel.saveLecture(lectureDto);

        if (isSave) {
            new Alert(Alert.AlertType.INFORMATION, "Lecture saved...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Lecture  not saved").show();
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String lecId = lblID.getText();
        String lecName = lblNAME.getText();
        String age = lblAGE.getText();
        String adress = lblADRESS.getText();
        String phone = lblMNUM.getText();
        String courseId = lblCoureseId.getText();

        LectureDto lectureDto = new LectureDto(lecId, lecName, age,adress, phone, courseId);
        boolean isSave = lectureModel.updateLecture(lectureDto);

        if (isSave) {
            new Alert(Alert.AlertType.INFORMATION, "Lecture Updated...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Lecture  not Updated").show();
        }

    }

    @FXML
    void tableOnClick(MouseEvent event) {

    }

}
