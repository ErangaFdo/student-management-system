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
import lk.ijse.gdse.studentmanagementsystem.Dto.LectureDto;
import lk.ijse.gdse.studentmanagementsystem.Dto.Tm.LectureTm;
import lk.ijse.gdse.studentmanagementsystem.Model.LectureModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class LectureController  implements Initializable {

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
    private TableView<LectureTm> lectureTable;

    @FXML
    void btnClearOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        refreshPage();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String ID = lblID.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = lectureModel.deleteLecture(ID);
            if (isDeleted) {
                loadLecture();
                refreshPage();
                new Alert(Alert.AlertType.INFORMATION, "Lecture deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete Lecture...!").show();
            }
        }

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
            loadLecture();
            refreshPage();
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
            loadLecture();
            refreshPage();
            new Alert(Alert.AlertType.INFORMATION, "Lecture Updated...!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Lecture  not Updated").show();
        }

    }

    @FXML
    void tableOnClick(MouseEvent event) {
            LectureTm lectureTm = (LectureTm) lectureTable.getSelectionModel().getSelectedItem();
            if (lectureTm != null) {
                lblID.setText(lectureTm.getLectureId());
                lblNAME.setText(lectureTm.getLectureName());
                lblAGE.setText(lectureTm.getLectureAge());
                lblADRESS.setText(lectureTm.getLectureAdress());
                lblMNUM.setText(lectureTm.getLecturePhone());
                lblCoureseId.setText(lectureTm.getCouresId());

                btnSave.setDisable(true);
                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
            }
    }

    private void refreshPage() {
         btnSave.setDisable(false);
         btnDelete.setDisable(true);
         btnUpdate.setDisable(true);

         lblID.setText("");
         lblNAME.setText("");
         lblAGE.setText("");
         lblADRESS.setText("");
         lblMNUM.setText("");
         lblCoureseId.setText("");
    }

    private void loadLecture() throws SQLException, ClassNotFoundException {
        ArrayList<LectureDto> lectureDtos = lectureModel.getAllLectures();
        ObservableList<LectureTm> lectureTms = FXCollections.observableArrayList();

        for (LectureDto lectureDto : lectureDtos) {
            LectureTm lectureTm = new LectureTm();
            lectureTm.setLectureId(lectureDto.getLectureId());
            lectureTm.setLectureName(lectureDto.getLectureName());
            lectureTm.setLectureAge(lectureDto.getLectureAge());
            lectureTm.setLectureAdress(lectureDto.getLectureAdress());
            lectureTm.setLecturePhone(lectureDto.getLecturePhone());
            lectureTm.setCouresId(lectureDto.getCouresId()
            );
            lectureTms.add(lectureTm);
        }
            lectureTable.setItems(lectureTms);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmId.setCellValueFactory(new PropertyValueFactory<>("lectureId"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("lectureName"));
        clmAge.setCellValueFactory(new PropertyValueFactory<>("lectureAge"));
        clmAdress.setCellValueFactory(new PropertyValueFactory<>("lectureAdress"));
        clmMnum.setCellValueFactory(new PropertyValueFactory<>("lecturePhone"));
        clmCourseId.setCellValueFactory(new PropertyValueFactory<>("CouresId"));

        try {
            loadLecture();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
