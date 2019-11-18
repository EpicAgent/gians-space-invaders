package layouts.teil2;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AssetBundleDao {
    private static String[] assetBundles = new String[]{"Painted", "Pixelart", "Vector"};
    private static String[] assetCategories = new String[]{"Isometric", "Platformer", "Topdown"};
    private static Image[] assetImages = new Image[]{
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_010.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_015.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_016.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_021.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_022.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_028.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_029.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_036.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_067.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_075.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_083.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_091.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_098.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_099.png")),
            new Image(AssetBundleDao.class.getResourceAsStream("/gallery/landscapeTiles_106.png"))
    };

    public static List<AssetBundle> getAssetBundles() {
        List<AssetBundle> assetTypeList = new ArrayList<>();

        for (String bundle : assetBundles) {
            AssetBundle assetBundle = new AssetBundle(bundle);

            for (String category : assetCategories) {
                assetBundle.addCategory(new AssetCategory(category));
            }

            assetTypeList.add(assetBundle);
        }
        return assetTypeList;
    }

    public static List<Image> getImages() {
        return Arrays.asList(assetImages);
    }
}

class AssetBundle {
    private List<AssetCategory> categories = new ArrayList<>();
    private String name;

    public AssetBundle(String name) {
        this.name = name;
    }

    public List<AssetCategory> getCategories() {
        categories.sort(new Comparator<AssetCategory>() {
            @Override
            public int compare(AssetCategory o1, AssetCategory o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return categories;
    }

    public void addCategory(AssetCategory assetCategory) {
        categories.add(assetCategory);
    }

    public void removeCategory(AssetCategory assetCategory) {
        categories.remove(assetCategory);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class AssetCategory {
    private String name;

    public AssetCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}