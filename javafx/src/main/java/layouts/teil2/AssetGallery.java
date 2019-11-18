package layouts.teil2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class AssetGallery extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        BorderPane rootPane = new BorderPane();

        GridPane menuGrid = new GridPane();
        menuGrid.setPadding(new Insets(5));
        menuGrid.setHgap(5);
        menuGrid.setVgap(5);

        ColumnConstraints columnContraint1 = new ColumnConstraints();
        ColumnConstraints columnContraint2 = new ColumnConstraints();
        columnContraint1.setPercentWidth(50);
        columnContraint2.setPercentWidth(50);
        menuGrid.getColumnConstraints().addAll(columnContraint1, columnContraint2);

        Button newBundleButton = new Button("New Bundle");
        Button importBundleButton = new Button("Import Bundle");

        newBundleButton.setMaxWidth(Double.MAX_VALUE);
        importBundleButton.setMaxWidth(Double.MAX_VALUE);


        TreeItem<String> itmRoot = new TreeItem<String>("Asset Bundles");
        itmRoot.setExpanded(true);

        for (AssetBundle bundle : AssetBundleDao.getAssetBundles()) {
            TreeItem<String> bundleItem = new TreeItem<String>(bundle.getName());

            itmRoot.getChildren().add(bundleItem);
            for (AssetCategory category : bundle.getCategories()) {
                bundleItem.getChildren().add(new TreeItem<>(category.getName()));
            }
        }


        TreeView<String> assetSetsTree = new TreeView<String>(itmRoot);
        // Selektiert das entsprechende TreeItem vor (Demozwecke)
        assetSetsTree.getSelectionModel().select(((TreeItem<String>) ((TreeItem<String>) itmRoot.getChildren().get(2)).getChildren().get(0)));


        menuGrid.addRow(0, newBundleButton, importBundleButton);
        menuGrid.addRow(1, assetSetsTree);
        GridPane.setColumnSpan(assetSetsTree, 2);
        GridPane.setHgrow(assetSetsTree, Priority.ALWAYS);


        TilePane assetPane = new TilePane();
        assetPane.setPadding(new Insets(20));
        assetPane.setVgap(10);
        assetPane.setHgap(10);
        assetPane.setPrefColumns(2);
        assetPane.setPrefTileHeight(140);
        assetPane.setPrefTileWidth(140);

        // WICHTIG: "assets"-Package muss mit den entsprechenden 15 Bildern vorhanden sein!
        for (Image image : AssetBundleDao.getImages()) {
            ImageView imageView = new ImageView(image);
            assetPane.getChildren().add(imageView);
        }


        ScrollPane assetScrollPane = new ScrollPane();
        assetScrollPane.setContent(assetPane);

        rootPane.setLeft(menuGrid);
        rootPane.setCenter(assetScrollPane);

        stage.setTitle("Asset Gallery");
        stage.setScene(new Scene(rootPane, 620, 360));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
