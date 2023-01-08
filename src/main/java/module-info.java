module com.example.testris {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testris to javafx.fxml;
    exports com.example.testris;
    exports com.example.testris.controller;
    opens com.example.testris.controller to javafx.fxml;
}