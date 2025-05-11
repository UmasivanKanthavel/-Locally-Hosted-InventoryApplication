import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StoreApp extends Application {

    Store model;
    public StoreApp() {
        model = Store.createStore();
    }

    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();
        StoreView view = new StoreView();
        aPane.getChildren().add(view);
        primaryStage.setTitle("Sakthi Silk");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
        view.UpdateStore(model,0);


        view.getStoreStock().setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                view.UpdateStore(model,0);
            }
        });

        view.getCurrentCart().setOnMousePressed(new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent mouseEvent) {
                view.UpdateStore(model,0);
            }

        });


        view.getButtonpane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.UpdateStore(model,1);
            }
        });

        view.getButtonpane().getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.UpdateStore(model,2);
            }
        });

        view.getButtonpane().getCompleteSaleButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.UpdateStore(model,3);
            }
        });

        view.getButtonpane().getResetStoreButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model = Store.createStore();
                view.UpdateStore(model,0);
            }
        });










    }



    public static void main(String[] args) {launch(args);}
}
