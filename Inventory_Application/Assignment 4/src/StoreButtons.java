import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
public class StoreButtons extends Pane {
        private     Button  addButton, deleteButton, CompleteSaleButton,ResetStoreButton;

        public Button getAddButton() { return addButton; }
        public Button getDeleteButton() { return deleteButton; }
        public Button getCompleteSaleButton() { return CompleteSaleButton; }
        public Button getResetStoreButton(){return ResetStoreButton;}

        public StoreButtons() {
            Pane innerPane = new Pane();

            //Create the buttons

            ResetStoreButton = new Button("Reset Store");
            ResetStoreButton.setStyle("-fx-font: 12 arial;");
            ResetStoreButton.relocate(20, 0);
            ResetStoreButton.setPrefSize(110,60);

            addButton = new Button("Add to Cart");
            addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); -fx-text-fill: rgb(255,255,255);");
            addButton.relocate(223, 0);
            addButton.setPrefSize(156,60);

            deleteButton = new Button("Remove from Cart");
            deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(200,0,0); -fx-text-fill: rgb(255,255,255);");
            deleteButton.relocate(467, 0);
            deleteButton.setPrefSize(156,60);

            CompleteSaleButton = new Button("Complete Sale");
            CompleteSaleButton.setStyle("-fx-font: 12 arial;");
            CompleteSaleButton.relocate(623, 0);
            CompleteSaleButton.setPrefSize(156,60);


            addButton.setDisable(true);
            deleteButton.setDisable(true);
            CompleteSaleButton.setDisable(true);
            ResetStoreButton.setDisable(true);

            // Add all three buttons to the pane
            innerPane.getChildren().addAll(addButton, deleteButton, CompleteSaleButton,ResetStoreButton);

            getChildren().addAll(innerPane);//, titleLabel);
        }
    }



