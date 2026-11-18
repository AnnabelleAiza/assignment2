module com.mycompany.assignment02_annabelle_aizanman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.assignment02_annabelle_aizanman to javafx.fxml;
    exports com.mycompany.assignment02_annabelle_aizanman;
}
