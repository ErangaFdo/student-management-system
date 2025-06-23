package lk.ijse.gdse.studentmanagementsystem.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.io.IOException;

public class HomeFormController {

    @FXML
    private Pane HomeAnchorPane;

    @FXML
    private Button btnAttendance;

    @FXML
    private Button btnCourse;

    @FXML
    private Button btnDepartment;

    @FXML
    private Button btnLecture;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnSalary;

    @FXML
    private Button btnStudent;

    @FXML
    private AnchorPane loadingAnchorPane;

    @FXML
    void btnAttendanceOnAction(ActionEvent event) {

    }

    @FXML
    void btnCourseOnAction(ActionEvent event) {

    }

    @FXML
    void btnDepartmentOnAction(ActionEvent event) {

    }

    @FXML
    void btnLectureOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) {

    }

    @FXML
    void btnSalaryOnAction(ActionEvent event) {

    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
             navigateTo("/view/StudentView.fxml");
    }

    private void navigateTo(String fxmlPath) {
        try {
            loadingAnchorPane.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane loadedPane = loader.load();
            loadingAnchorPane.getChildren().add(loadedPane);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load view: " + fxmlPath);
        }
        System.out.println("Loadin");
    }

}
