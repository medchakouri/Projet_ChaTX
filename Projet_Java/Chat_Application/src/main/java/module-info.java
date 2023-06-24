module com.example.controlebb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.controleS to javafx.fxml;
    exports com.example.controleS;
}