module com.empresa.mongo_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.empresa.mongo_javafx to javafx.fxml;
    exports com.empresa.mongo_javafx;
}