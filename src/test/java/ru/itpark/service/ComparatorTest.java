package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.comparator.DateDecComparator;
import ru.itpark.comparator.PriceDecComparator;
import ru.itpark.comparator.PriceIncComparator;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {
    private HouseService service;

    @BeforeEach
    void setUp() {
        HouseRepository repository = new HouseRepository();
        repository.add(new House("Купить", "Квартира", "Москва", "Арбат", "Арбатская", true, 14_000_000, "17.10.2018"));
        repository.add(new House("Купить", "Квартира", "Казань", "Вахитовский", "Кремлевская", true, 4_000_000, "17.11.2018"));
        repository.add(new House("Купить", "Квартира", "Москва", "Бабушкинский", "Бабушкинская", true, 10_000_000, "15.10.2018"));
        repository.add(new House("Купить", "Квартира", "Казань", "Советский", false, 1_500_000, "17.09.2018"));

        service = new HouseService(repository);
    }

    @Test
    void priceDecComparatorTest() {
        List<House> list = service.getSorted(new PriceDecComparator());
        List<Integer> result = list.stream()
                .map(House::getPrice)
                .collect(Collectors.toList());

        List<Integer> expected = Arrays.asList(14_000_000, 10_000_000, 4_000_000, 1_500_000);
        assertEquals(expected, result);
    }

    @Test
    void priceIncComparatorTest() {
        List<House> list = service.getSorted(new PriceIncComparator());
        List<Integer> result = list.stream()
                .map(House::getPrice)
                .collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(1_500_000, 4_000_000, 10_000_000, 14_000_000);
        assertEquals(expected, result);
    }

    @Test
    void dateDecComparatorTest() {
        List<House> list = service.getSorted(new DateDecComparator());
        List<String> result = list.stream()
                .map(House::getDate)
                .collect(Collectors.toList());

        List<String> expected = Arrays.asList("17.11.2018", "17.10.2018", "15.10.2018", "17.09.2018");
        assertEquals(expected, result);
    }
}