module lk.ijse.gdse.studentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens lk.ijse.gdse.studentmanagementsystem.Controller to javafx.fxml;
    exports lk.ijse.gdse.studentmanagementsystem;
}