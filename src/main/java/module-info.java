module com.empresa.mongo_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires mongo.java.driver;


    opens com.empresa.mongo_javafx to javafx.fxml;
    exports com.empresa.mongo_javafx;
}