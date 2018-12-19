package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseServiceTest {
    private HouseService service;
    @BeforeEach
    void setUp() {
        HouseRepository repository = new HouseRepository();
        repository.add(new House("Купить","Квартира", "Москва", "Арбат", "Арбатская", true,14_000_000, "17.10.2018"));
        repository.add(new House("Купить","Квартира", "Казань", "Вахитовский", "Кремлевская", true,4_000_000, "17.11.2018"));
        repository.add(new House("Купить","Квартира", "Москва", "Бабушкинский", "Бабушкинская", true,10_000_000, "15.10.2018"));
        repository.add(new House("Купить","Квартира", "Казань", "Советский",  false,1_500_000, "17.09.2018"));
        repository.add(new House("Купить","Квартира", "Казань", "Советский", true,6_000_000, "17.12.2017"));
        repository.add(new House("Продать","Дом", "Казань", "Вахитовский", "Кремлевская", true,14_000_000, "17.08.2018"));
        repository.add(new House("Сдать","Дом", "Москва", "Бибирево", "Бибирево", false,110_000, "01.12.2018"));
        repository.add(new House("Сдать","Дом", "Казань", "Вахитовский", "Площадь Тукая", true,50_000, "17.11.2018"));
        repository.add(new House("Сдать","Дом", "Казань", "Вахитовский", "Кремлевская", true,25_000, "11.11.2018"));
        repository.add(new House("Сдать","Комната", "Орск", "Ленинский", false,10_000, "26.11.2018"));

        service = new HouseService(repository);
    }

    @Test
    void findByCityWithZeroResult() {
        List<House> result = service.findByCity("Бугульма");

        assertEquals(0,result.size());
    }
    @Test
    void findByCityWithOneResult() {
        List<House> result = service.findByCity("Орск");

        assertEquals(1,result.size());
    }
    @Test
    void findByCityWithMultipleResult() {
        List<House> result = service.findByCity("Москва");

        assertEquals(3,result.size());
    }


    @Test
    void findByNeighborhoodWithZeroResult() {
        List<House> result = service.findByNeighborhood("Кировский");

        assertEquals(0,result.size());
    }
    @Test
    void findByNeighborhoodWithOneResult() {
        List<House> result = service.findByNeighborhood("Ленинский");

        assertEquals(1,result.size());
    }
    @Test
    void findByNeighborhoodWithMultipleResult() {
        List<House> result = service.findByNeighborhood("Советский");

        assertEquals(2,result.size());
    }


    @Test
    void findByMetroWithZeroResult() {
        List<House> result = service.findByMetro("Бутово");

        assertEquals(0,result.size());
    }
    @Test
    void findByMetroWithOneResult() {
        List<House> result = service.findByMetro("Арбатская");

        assertEquals(1,result.size());
    }
    @Test
    void findByMetroWithMultipleResult() {
        List<House> result = service.findByMetro("Кремлевская");

        assertEquals(3,result.size());
    }


    @Test
    void findWithPhotoTest() {
        List<House> result = service.findWithPhoto();

        assertEquals(7,result.size());
    }
    @Test
    void findWithoutPhotoTest() {
        List<House> result = service.findWithoutPhoto();

        assertEquals(3,result.size());
    }


    @Test
    void findWithTypeOfDealWithZeroResult() {
        List<House> result = service.findWithTypeOfDeal("Аренда");

        assertEquals(0,result.size());
    }
    @Test
    void findWithTypeOfDealWithOneResult() {
        List<House> result = service.findWithTypeOfDeal("Продать");

        assertEquals(1,result.size());
    }
    @Test
    void findWithTypeOfDealWithMultipleResult() {
        List<House> result = service.findWithTypeOfDeal("Сдать");

        assertEquals(4,result.size());
    }


    @Test
    void findByTypeOfPropertyWithZeroResult() {
        List<House> result = service.findByTypeOfProperty("Коттедж");

        assertEquals(0,result.size());
    }
    @Test
    void findByTypeOfPropertyWithOneResult() {
        List<House> result = service.findByTypeOfProperty("Комната");

        assertEquals(1,result.size());
    }
    @Test
    void findByTypeOfPropertyWithMultipleResult() {
        List<House> result = service.findByTypeOfProperty("Дом");

        assertEquals(4,result.size());
    }


    @Test
    void findPriceRangeWithZeroResult() {
        {
            int priceMin = 0;
            int priceMax = 5_000;
            List<House> result = service.findPriceRange(priceMin,priceMax);

            assertEquals(0, result.size());
        }
        {
            int priceMin = 40_000_000;
            int priceMax = 50_000_000;
            List<House> result = service.findPriceRange(priceMin,priceMax);

            assertEquals(0, result.size());
        }
    }
    @Test
    void findPriceRangeWithOneResult() {
        int priceMin = 3_000_000;
        int priceMax = 5_000_000;
        List<House> result = service.findPriceRange(priceMin,priceMax);

        assertEquals(1, result.size());
    }
    @Test
    void findPriceRangeWithMultipleResult() {
        int priceMin = 25_000;
        int priceMax = 50_000;
        List<House> result = service.findPriceRange(priceMin,priceMax);

        assertEquals(2, result.size());
    }
}