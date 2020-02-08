package test_pars;

public class ShortProduct {
    private String shortImage;
    private String name;
    private String linkOnFullDescription;
    private String shortDescription;
    private String price;
    private FullProduct fpd;

    public ShortProduct(String shortImage, String name, String linkOnFullDescription, String shortDescription, String price, FullProduct fpd) {
        this.shortImage = shortImage;
        this.name = name;
        this.linkOnFullDescription = linkOnFullDescription;
        this.shortDescription = shortDescription;
        this.price = price;
        this.fpd = fpd;
    }

    public ShortProduct() {
    }

    public FullProduct getFpd() {
        return fpd;
    }

    public void setFpd(FullProduct fpd) {
        this.fpd = fpd;
    }


    public String getShortImage() {
        return shortImage;
    }

    public void setShortImage(String shortImage) {
        this.shortImage = shortImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkOnFullDescription() {
        return linkOnFullDescription;
    }

    public void setLinkOnFullDescription(String linkOnFullDescription) {
        this.linkOnFullDescription = linkOnFullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
