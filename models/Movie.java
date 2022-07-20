package models;

public class Movie {
    private String name;
    private String format;
    private byte rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie (String name, String format, byte rating){
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;

    }

    public String getName() {
        return name;
    }
    public String getFormat() {
        return format;
    }
    public byte getRating() {
        return rating;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public void setRating(byte rating) {
        this.rating = rating;
    }
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
