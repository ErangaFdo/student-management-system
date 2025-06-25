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
import lk.ijse.gdse.studentmanagementsystem.Dto.CourseDto;
import lk.ijse.gdse.studentmanagementsystem.Dto.Tm.CourseTm;
import lk.ijse.gdse.studentmanagementsystem.Model.CourseModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    CourseModel courseModel = new CourseModel();

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> clmDiuration;

    @FXML
    private TableColumn<?, ?> clmId;

    @FXML
    private TableColumn<?, ?> clmName;

    @FXML
    private TableColumn<?, ?> clmPayment;

    @FXML
    private TableColumn<?, ?> clmStudentId;

    @FXML
    private AnchorPane courseAnchorPane;

    @FXML
    private TableView<CourseTm> courseTable;

    @FXML
    private TextField lblCourseDiuration;

    @FXML
    private TextField lblCourseId;

    @FXML
    private TextField lblCourseName;

    @FXML
    private TextField lblCoursePayment;

    @FXML
    private TextField lblStudentId;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        refreshPage();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String ID = lblCourseId.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optionalButtonType = alert.showAndWait();

        if (optionalButtonType.isPresent() && optionalButtonType.get() == ButtonType.YES) {

            boolean isDeleted = courseModel.deleteCourse(ID);
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Customer deleted...!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to delete customer...!").show();
            }
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

          String CourseId = lblCourseId.getText();
          String CourseName = lblCourseName.getText();
          String Payment = lblCoursePayment.getText();
          String CourseDiuration = lblCourseDiuration.getText();
          String StudentId = lblStudentId.getText();

          CourseDto courseDto = new CourseDto(CourseId, CourseName, Payment, CourseDiuration, StudentId);
          boolean isSave = courseModel.saveCourse(courseDto);

          if (isSave) {
            System.out.println("save success");
          } else {
            System.out.println("save failed");
          }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        String CourseId = lblCourseId.getText();
        String CourseName = lblCourseName.getText();
        String Payment = lblCoursePayment.getText();
        String CourseDiuration = lblCourseDiuration.getText();
        String StudentId = lblStudentId.getText();

        CourseDto courseDto = new CourseDto(CourseId, CourseName, Payment, CourseDiuration, StudentId);
        boolean isSave = courseModel.updateCourse(courseDto);

        if (isSave) {
            System.out.println("update success");
        } else {
            System.out.println(" update filed");
        }

    }

    @FXML
    void tableOnClick(MouseEvent event) {
             CourseTm courseTm = courseTable.getSelectionModel().getSelectedItem();
             if (courseTm != null) {
                 lblCourseId.setText(courseTm.getCourseId());
                 lblCourseName.setText(courseTm.getCourseName());
                 lblCoursePayment.setText(courseTm.getCoursePayment());
                 lblCourseDiuration.setText(courseTm.getCourseDiuration());
                 lblStudentId.setText(courseTm.getStudentId());

                 btnSave.setDisable(false);
                 btnUpdate.setDisable(true);
                 btnDelete.setDisable(true);

             }
    }

    private void refreshPage(){
         btnSave.setDisable(false);
         btnUpdate.setDisable(true);
         btnDelete.setDisable(true);

         lblCourseId.setText("");
         lblCourseName.setText("");
         lblCoursePayment.setText("");
         lblCourseDiuration.setText("");
         lblStudentId.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         clmId.setCellValueFactory(new PropertyValueFactory<>("CourseId"));
         clmName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
         clmPayment.setCellValueFactory(new PropertyValueFactory<>("CoursePayment"));
         clmDiuration.setCellValueFactory(new PropertyValueFactory<>("CourseDiuration"));
         clmStudentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));

          try {
              loadCourse();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          } catch (ClassNotFoundException e) {
              throw new RuntimeException(e);
          }
    }

    private void loadCourse() throws SQLException, ClassNotFoundException {
        ArrayList<CourseDto> courseDtos = courseModel.getAllCourse();
        ObservableList<CourseTm> courseTms = FXCollections.observableArrayList();

        for (CourseDto courseDto : courseDtos) {
            CourseTm courseTm = new CourseTm();
            courseTm.setCourseId(courseDto.getCourseId());
            courseTm.setCourseName(courseDto.getCourseName());
            courseTm.setCoursePayment(courseDto.getCoursePayment());
            courseTm.setCourseDiuration(courseDto.getCourseDiuration());
            courseTm.setStudentId(courseDto.getStudentId());

            courseTms.add(courseTm);
        }
        courseTable.setItems(courseTms);
    }
}

