package com.example.hackerthonproject.dto;

public class ReitsDto {
    public ReitsDto(String type, String price, String pcr, String pcp, String volume) {
        this.type = type;
        this.price = price;
        this.pcr = pcr;
        this.pcp = pcp;
        this.volume = volume;
    }

    private String type;
    private String price;
    private String pcr;
    private String pcp;
    private String volume;

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getPcr() {
        return pcr;
    }

    public String getPcp() {
        return pcp;
    }

    public String getVolume() {
        return volume;
    }
}
