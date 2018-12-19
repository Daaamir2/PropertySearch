package ru.itpark;

import ru.itpark.comparator.DateDecComparator;
import ru.itpark.comparator.PriceDecComparator;
import ru.itpark.comparator.PriceIncComparator;
import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;
import ru.itpark.service.HouseService;

public class Main {
    public static void main(String[] args) {
        HouseService service = new HouseService(new HouseRepository());

        service.add(new House("Купить","Квартира", "Москва", "Арбат", "Арбатская", true,14_000_000, "17.10.2018"));
        service.add(new House("Купить","Квартира", "Казань", "Вахитовский", "Кремлевская", true,4_000_000, "17.11.2018"));
        service.add(new House("Купить","Квартира", "Москва", "Бабушкинский", "Бабушкинская", true,10_000_000, "15.10.2018"));
        service.add(new House("Продать","Квартира", "Орск", "Советский",  false,1_500_000, "17.09.2018"));
        service.add(new House("Продать","Квартира", "Казань", "Советский", true,6_000_000, "17.12.2017"));
        service.add(new House("Продать","Дом", "Казань", "Вахитовский", "Кремлевская", true,14_000_000, "17.08.2018"));
        service.add(new House("Сдать","Дом", "Москва", "Бибирево", "Бибирево", false,110_000, "01.12.2018"));
        service.add(new House("Сдать","Дом", "Казань", "Вахитовский", "Площадь Тукая", true,50_000, "17.11.2018"));
        service.add(new House("Сдать","Комната", "Казань", "Вахитовский", "Кремлевская", true,25_000, "11.11.2018"));
        service.add(new House("Сдать","Комната", "Орск", "Ленинский", false,10_000, "26.11.2018"));

        System.out.println(service.getSorted(new PriceDecComparator()));
        System.out.println(service.getSorted(new PriceIncComparator()));
        System.out.println(service.getSorted(new DateDecComparator()));

//        System.out.println(service.findByNeighborhood("Бабушкинский").getAll());
//        System.out.println(service.findByMetro("Арбатская").getAll());
//        System.out.println(service.findByPhoto().getAll());
//
//        System.out.println((service.findByCity("Казань")).getSorted(new PriceIncComparator()));
//
//        System.out.println(service.findByTypeOfProperty("Квартира").findPriceRange(5_000_000,10_000_000).getSorted(new PriceIncComparator()));
    }
}
