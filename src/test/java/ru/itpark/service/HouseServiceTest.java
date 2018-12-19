package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.comparator.PriceDecComparator;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseServiceTest {
    private HouseService service;

    @BeforeEach
    void setUp() {
        HouseRepository repository = new HouseRepository();
        repository.add(new House("Купить", "Квартира", "Москва", "Арбат", "Арбатская", true, 14_000_000, "17.10.2018"));
        repository.add(new House("Купить", "Квартира", "Казань", "Вахитовский", "Кремлевская", true, 4_000_000, "17.11.2018"));
        repository.add(new House("Купить", "Квартира", "Москва", "Бабушкинский", "Бабушкинская", true, 10_000_000, "15.10.2018"));
        repository.add(new House("Купить", "Квартира", "Казань", "Советский", true, 6_000_000, "17.12.2017"));
        repository.add(new House("Продать", "Дом", "Казань", "Вахитовский", "Кремлевская", true, 14_000_000, "17.08.2018"));
        repository.add(new House("Сдать", "Дом", "Москва", "Бибирево", "Бибирево", false, 110_000, "01.12.2018"));
        repository.add(new House("Сдать", "Дом", "Казань", "Вахитовский", "Площадь Тукая", true, 50_000, "17.11.2018"));
        repository.add(new House("Сдать", "Дом", "Казань", "Вахитовский", "Кремлевская", true, 25_000, "11.11.2018"));
        repository.add(new House("Сдать", "Комната", "Орск", "Ленинский", false, 10_000, "26.11.2018"));

        service = new HouseService(repository);
    }

    @Test
    void fundByCityWithZeroResult() {
        List<House> result = service.findByCity("Бугульма");

        assertEquals(0, result.size());
    }

    @Test
    void findByCityWithOneResults() {
        List<House> result = service.findByCity("Орск");

        assertEquals(1, result.size());
    }

    @Test
    void findByCityWithMultipleResults() {
        List<House> result = service.findByCity("Казань");

        assertEquals(5, result.size());
    }


    @Test
    void findByNeighborhoodWithZeroResult() {
        List<House> result = service.findByNeighborhood("Бутово");

        assertEquals(0, result.size());
    }

    @Test
    void findByNeighborhoodWithOneResult() {
        List<House> result = service.findByNeighborhood("Ленинский");

        assertEquals(1, result.size());
    }

    @Test
    void findByNeighborhoodWithMultipleResult() {
        List<House> result = service.findByNeighborhood("Вахитовский");

        assertEquals(4, result.size());
    }


    @Test
    void findByMetroWithZeroResult() {
        List<House> result = service.findByMetro("Бутово");

        assertEquals(0, result.size());
    }

    @Test
    void findByMetroWithOneResult() {
        List<House> result = service.findByMetro("Бабушкинская");

        assertEquals(1, result.size());
    }

    @Test
    void findByMetroWithMultipleResult() {
        List<House> result = service.findByMetro("Кремлевская");

        assertEquals(3, result.size());
    }


    @Test
    void findByWithPhoto() {
        assertEquals(2, service.findByWithoutPhoto().getAll().size());
    }

    @Test
    void findByPhotoTrue() {
        assertEquals(7, service.findByWithPhoto().getAll().size());
    }


    @Test
    void findByTypeOfDealWithZeroResult() {
        List<House> result = service.findByTypeOfDeal("Аоендовать");

        assertEquals(0, result.size());
    }

    @Test
    void findByTypeOfDealWithOneResult() {
        List<House> result = service.findByTypeOfDeal("Продать");

        assertEquals(1, result.size());
    }

    @Test
    void findByTypeOfDealWithMultipleResult() {
        List<House> result = service.findByTypeOfDeal("Сдать");

        assertEquals(4, result.size());
    }


    @Test
    void findByTypeOfPropertyWithZeroResult() {
        List<House> result = service.findByNeighborhood("Коттедж");

        assertEquals(0, result.size());
    }

    @Test
    void findByTypeOfPropertyWithOneResult() {
        List<House> result = service.findByTypeOfProperty("Комната");

        assertEquals(1, result.size());
    }

    @Test
    void findByTypeOfPropertyWithMultipleResult() {
        List<House> result = service.findByTypeOfProperty("Дом");

        assertEquals(4, result.size());
    }


    @Test
    void findByPriceRangeWithZeroResult() {
        {
            int priceMin = 0;
            int priceMax = 5_000;
            List<House> result = service.findByPriceRange(priceMin, priceMax);

            assertEquals(0, result.size());
        }
        {
            int priceMin = 20_000_000;
            int priceMax = 100_000_000;
            List<House> result = service.findByPriceRange(priceMin, priceMax);

            assertEquals(0, result.size());
        }
    }

    @Test
    void findByPriceRangeWithOneResult() {
        int priceMin = 25_000;
        int priceMax = 25_000;
        List<House> result = service.findByPriceRange(priceMin, priceMax);

        assertEquals(1, result.size());
    }

    @Test
    void findByPriceRangeWithMultipleResult() {
        int priceMin = 10_000;
        int priceMax = 50_000;
        List<House> result = service.findByPriceRange(priceMin, priceMax);

        assertEquals(3, result.size());
    }
}