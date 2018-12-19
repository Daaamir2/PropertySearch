package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class House {
    private String typeOfDeal;
    private String typeOfProperty;
    private String city;
    private String neighborhood;
    private String metro;
    private boolean photo;
    private int price;
    private String date;

    public House(String typeOfDeal, String typeOfProperty, String city, String neighborhood, boolean photo, int price, String date) {
        this.typeOfDeal = typeOfDeal;
        this.typeOfProperty = typeOfProperty;
        this.city = city;
        this.neighborhood = neighborhood;
        this.photo = photo;
        this.price = price;
        this.date = date;
    }
}
