module com.example.demo8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens com.example.demo8 to javafx.fxml, org.hibernate.orm.core;
    exports com.example.demo8;
}