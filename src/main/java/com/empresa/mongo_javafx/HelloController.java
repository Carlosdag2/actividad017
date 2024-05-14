package com.empresa.mongo_javafx;

import com.mongodb.client.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.bson.Document;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ListView lvList;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfPrecio;

    private MongoClient cliente;
    private MongoCollection<Document> tabla;

    @FXML
    protected void initialize() {
        // Conexión a MongoDB Atlas
        cliente = MongoClients.create("mongodb+srv://editor:editor@cluster0.gomt1im.mongodb.net/");
        MongoDatabase db = cliente.getDatabase("ejemplo");
        tabla = db.getCollection("actividad017");
    }

    @FXML
    protected void onHelloButtonClick() {
        // Consulta y muestra los documentos en el ListView
        ObservableList<String> documentos = FXCollections.observableArrayList();
        MongoCursor<Document> cursor = tabla.find().iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            documentos.add(doc.toJson());
        }
        lvList.setItems(documentos);
    }

    @FXML
    protected void onAgregarButtonClick() {
        // Inserta un nuevo documento en la colección
        String nombre = tfNombre.getText();
        double precio = Double.parseDouble(tfPrecio.getText());

        Document documento = new Document("nombre", nombre)
                .append("precio", precio);

        tabla.insertOne(documento);
        tfNombre.clear();
        tfPrecio.clear();
    }
}
