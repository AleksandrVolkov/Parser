package test_pars;

import java.util.List;
import java.util.Map;

public class FullProduct {
    private List<String> imageList;
    private Map<String, Map<String, String>> fullProductDescription;

    public FullProduct(List<String> imageList, Map<String, Map<String, String>> fullProductDescription) {
        this.imageList = imageList;
        this.fullProductDescription = fullProductDescription;
    }

    public FullProduct() {
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public Map<String, Map<String, String>> getFullProductDescription() {
        return fullProductDescription;
    }

    public void setFullProductDescription(Map<String, Map<String, String>> fullProductDescription) {
        this.fullProductDescription = fullProductDescription;
    }
}
