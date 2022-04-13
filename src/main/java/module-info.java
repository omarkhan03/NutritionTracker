module com.example.cpsc233projectdemo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires java.desktop;
    requires java.sql;


    opens com.example.cpsc233projectdemo3 to javafx.fxml;
    exports com.example.cpsc233projectdemo3;
}