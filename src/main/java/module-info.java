module com.mycompany.assignment02_annabelle_aizanman {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.assignment02_annabelle_aizanman to javafx.fxml;
    exports com.mycompany.assignment02_annabelle_aizanman;
}
