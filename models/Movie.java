package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie (String name, String format, double rating){
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("DVD") ? 0.99 : 1.99;
        this.isAvailable = true;

    }
    public Movie (Movie source){
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }

    public String getName() {
        return name;
    }
    public String getFormat() {
        return format;
    }
    public double getRating() {
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
        setSellingPrice(format.equals("Blue-Ray") ? 4.25 : 2.25);
        setRentalPrice(format.equals("Blue-Ray") ? 1.99 : 0.99);
    }
    public void setRating(double rating) {
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

    public String toString(){
        return "\t Name: " + this.name + "\n" + 
        "\t Format: " + this.format + "\n" + 
        "\t Rating: " + this.rating + "\n" + 
        "\t Selling Price: " + this.sellingPrice + "\n" +
        "\t Rental Price : " + this.rentalPrice + "\n" + 
        "\t Available: " + (this.isAvailable ? "in stock" : "unavailable") + "\n"; 
    }
}
