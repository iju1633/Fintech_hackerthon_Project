package com.example.hackerthonproject;

public class ProductItem {
    private String type;
    private String price;
    private String pcr;
    private String pcp;
    private String volume;

    public ProductItem(String type, String price, String pcr, String pcp, String volume){
        this.type = type;
        this.price = price;
        this.pcr = pcr;
        this.pcp = pcp;
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPcr() {
        return pcr;
    }

    public void setPcr(String pcr) {
        this.pcr = pcr;
    }

    public String getPcp() {
        return pcp;
    }

    public void setPcp(String pcp) {
        this.pcp = pcp;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

}
