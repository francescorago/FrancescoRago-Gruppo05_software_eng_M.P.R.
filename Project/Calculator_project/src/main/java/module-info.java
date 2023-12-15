/* doesn't work with source level 1.8:
module com.mycompany.calculator_project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.calculator_project to javafx.fxml;
    exports com.mycompany.calculator_project;
}
*/
