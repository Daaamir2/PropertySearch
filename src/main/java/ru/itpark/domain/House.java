package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@Data
@RequiredArgsConstructor public class House {
    @NonNull private String typeOfDeal;
    @NonNull private String typeOfProperty;
    @NonNull private String city;
    @NonNull private String neighborhood;
    private String metro;
    @NonNull private boolean photo;
    @NonNull private int price;
    @NonNull private String date;
}
