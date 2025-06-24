module lk.ijse.gdse.studentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires java.desktop;


    opens lk.ijse.gdse.studentmanagementsystem.Controller to javafx.fxml;
    opens lk.ijse.gdse.studentmanagementsystem.Dto.Tm to javafx.base;
    exports lk.ijse.gdse.studentmanagementsystem;
}