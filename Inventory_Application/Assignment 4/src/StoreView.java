import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;




public class StoreView extends Pane {

    private StoreButtons buttonPane;
    private TextField salesfield,revenuefield,persalefield;
    private Label label1, label2,label3,label4,label5,label6,label7;

    private ListView<Product> MostPopularItems, StoreStock;

    private ListView<String> CurrentCart;



    public void UpdateStore(Store model,int Button){

        if(!model.getStoreHasBeenInitialized()){
            MostPopularItems.setItems(FXCollections.observableArrayList(model.getMostpopularitems()));
            model.SetStoreHasBeenInitialized();
        }

        if (Button==1){
            if(!model.addToCart(StoreStock.getSelectionModel().getSelectedItem())){
                buttonPane.getAddButton().setDisable(true);
            }
        }
        else if (Button==2){
            if(!model.CurrentCartList.isEmpty()){
                model.addToStock(CurrentCart.getSelectionModel().getSelectedItem());
            }
            buttonPane.getDeleteButton().setDisable(true);
        }
        else if(Button==3){
            model.CompleteSale();
            MostPopularItems.setItems(FXCollections.observableArrayList(model.getMostpopularitems()));
        }


        CurrentCart.setItems(FXCollections.observableArrayList(model.getCurrentCartList()));
        label3.setText("Current Cart " + String.format("%.2f",model.getCartvalue()));
        revenuefield.setText(String.valueOf(model.getRevenue()));
        salesfield.setText(String.valueOf(model.getSales()));
        persalefield.setText(String.format("%.2f", model.getPersale()));
        StoreStock.setItems(FXCollections.observableArrayList(model.getStock()));
        buttonPane.getCompleteSaleButton().setDisable(model.CurrentCartList.isEmpty());
        buttonPane.getDeleteButton().setDisable(CurrentCart.getSelectionModel().getSelectedItem() == null);
        buttonPane.getAddButton().setDisable(StoreStock.getSelectionModel().getSelectedItem() == null);

    }


    public StoreView(){
        // Create the labels
        label1 = new Label("Store Summary");
        label1.relocate(30, 10);
        label2 = new Label("Store Stock : ");
        label2.relocate(250, 10);
        label3 = new Label("Current Cart");
        label3.relocate(590, 10);
        label4 = new Label("Most Popular Items:");
        label4.relocate(20, 170);
        label5 = new Label("$/ Sale:");
        label5.relocate(20, 135);
        label6 = new Label("Revenue:");
        label6.relocate(15, 100);
        label7 = new Label("# of Sales:");
        label7.relocate(15, 70);


        salesfield = new TextField();
        salesfield.relocate(72.5, 65);

        salesfield.setPrefSize(62.5,30);

        revenuefield = new TextField();
        revenuefield.relocate(72.5, 95);
        revenuefield.setPrefSize(62.5,30);

        persalefield = new TextField();
        persalefield.relocate(72.5, 130);
        persalefield.setPrefSize(62.5,30);

        salesfield.setEditable(false);
        revenuefield.setEditable(false);
        persalefield.setEditable(false);

        // Create the lists
        MostPopularItems = new ListView<Product>();
        MostPopularItems.relocate(10, 190);
        MostPopularItems.setPrefSize(125,120);

        StoreStock = new ListView<Product>();
        StoreStock.relocate(145, 40);
        StoreStock.setPrefSize(312,270);

        CurrentCart = new ListView<String>();
        CurrentCart.relocate(467, 40);
        CurrentCart.setPrefSize(312,270);

        // Create the button pane
        buttonPane = new StoreButtons();
        buttonPane.relocate(0, 320);
        buttonPane.setPrefSize(800,60);
        buttonPane.getResetStoreButton().setDisable(false);

        // Add all the components to the Pane
        getChildren().addAll(label1, label2, label3,label4,label5,label6,label7,salesfield,revenuefield,persalefield, StoreStock,CurrentCart,MostPopularItems, buttonPane);

        setPrefSize(800, 400);
    }

    public ListView<Product> getStoreStock(){return StoreStock;}
    public ListView<String> getCurrentCart(){return CurrentCart;}
    public ListView<Product> getMostPopularItems(){return MostPopularItems;}
    public StoreButtons getButtonpane(){return buttonPane;}


}
