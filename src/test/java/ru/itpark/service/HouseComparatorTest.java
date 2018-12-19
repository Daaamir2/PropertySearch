package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.comparator.DateDecComparator;
import ru.itpark.comparator.PriceDecComparator;
import ru.itpark.comparator.PriceIncComparator;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseComparatorTest {
    private HouseService service;

    @BeforeEach
    void setUp() {
        HouseRepository repository = new HouseRepository();
        repository.add(new House("Купить", "Квартира", "Москва", "Арбат", "Арбатская", true, 14_000_000, "17.10.2018"));
        repository.add(new House("Купить", "Квартира", "Казань", "Вахитовский", "Кремлевская", true, 4_000_000, "17.11.2018"));
        repository.add(new House("Купить", "Квартира", "Москва", "Бабушкинский", "Бабушкинская", true, 10_000_000, "15.10.2018"));
        repository.add(new House("Купить", "Квартира", "Казань", "Советский", true, 6_000_000, "17.12.2017"));

        service = new HouseService(repository);
    }

    @Test
    void PriceDecComparatorTest() {
        List<House> sorted = service.getSorted(new PriceDecComparator());
        int[] result = new int[sorted.size()];
        int i = 0;
        for (House house : sorted) {
            result[i] = house.getPrice();
            i++;
        }
        int[] expected = {14_000_000,10_000_000,6_000_000,4_000_000};

        assertArrayEquals(expected,result);
    }

    @Test
    void PriceIncComparatorTest() {
        List<House> sorted = service.getSorted(new PriceIncComparator());
        int[] result = new int[sorted.size()];
        int i = 0;
        for (House house : sorted) {
            result[i] = house.getPrice();
            i++;
        }
        int[] expected = {4_000_000,6_000_000,10_000_000,14_000_000};

        assertArrayEquals(expected,result);
    }

    @Test
    void DateDecComparatorTest() {
        List<House> sorted = service.getSorted(new DateDecComparator());
        String[] result = new String[sorted.size()];
        int i = 0;
        for (House house : sorted) {
            result[i] = house.getDate();
            i++;
        }
        String[] expected = {"17.11.2018","17.10.2018","15.10.2018","17.12.2017"};

        assertArrayEquals(expected,result);
    }
}