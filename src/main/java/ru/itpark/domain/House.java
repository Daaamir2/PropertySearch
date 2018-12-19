package ru.itpark.domain;

public class House {
    private String typeOfDeal;
    private String typeOfProperty;
    private String city;
    private String neighborhood;
    private String metro;
    private boolean photo;
    private int price;
    private String date;

    public House(String typeOfDeal, String typeOfProperty, String city, String neighborhood, String metro, boolean photo, int price, String date) {
        this.typeOfDeal = typeOfDeal;
        this.typeOfProperty = typeOfProperty;
        this.city = city;
        this.neighborhood = neighborhood;
        this.metro = metro;
        this.photo = photo;
        this.price = price;
        this.date = date;
    }

    public House(String typeOfDeal, String typeOfProperty, String city, String neighborhood, boolean photo, int price, String date) {
        this.typeOfDeal = typeOfDeal;
        this.typeOfProperty = typeOfProperty;
        this.city = city;
        this.neighborhood = neighborhood;
        this.photo = photo;
        this.price = price;
        this.date = date;
    }

    public String getTypeOfDeal() {
        return typeOfDeal;
    }

    public void setTypeOfDeal(String typeOfDeal) {
        this.typeOfDeal = typeOfDeal;
    }

    public String getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(String typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public boolean isPhoto() {
        return photo;
    }

    public void setPhoto(boolean photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "House{" +
                "typeOfDeal='" + typeOfDeal + '\'' +
                ", typeOfProperty='" + typeOfProperty + '\'' +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", metro='" + metro + '\'' +
                ", photo=" + photo +
                ", price=" + price +
                ", date='" + date + '\'' +
                "}\n";
    }
}
