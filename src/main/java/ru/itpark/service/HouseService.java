package ru.itpark.service;

import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HouseService {
    private HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public void add(House... house) {
        repository.add(house);
    }

    public List<House> getAll(){
        return repository.getAll();
    }

    public List<House> getSorted(Comparator<House> comparator) {
        List<House> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public List<House> findByCity(String... cities) {
        List<House> result = new ArrayList<>();
        List<String> citiesList = Arrays.asList(cities);

        for (House house : repository.getAll()) {
            if (citiesList.contains(house.getCity())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByNeighborhood(String... neighborhoods) {
        List<House> result = new ArrayList<>();
        List<String> neighborhoodsList = Arrays.asList(neighborhoods);

        for (House house : repository.getAll()) {
            if (neighborhoodsList.contains(house.getNeighborhood())) {
               result.add(house);
            }
        }
        return result;
    }

    public List<House> findByMetro(String... metros) {
        List<House> result = new ArrayList<>();
        List<String> metrosList = Arrays.asList(metros);

        for (House house : repository.getAll()) {
            if (metrosList.contains(house.getMetro())) {
                result.add(house);
            }
        }
        return result;
    }

    public HouseService findByWithPhoto() {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.isPhoto()) {
                service.add(house);
            }
        }
        return service;
    }

    public HouseService findByWithoutPhoto() {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (!house.isPhoto()) {
                service.add(house);
            }
        }
        return service;
    }

    public List<House> findByTypeOfDeal(String typeOfDeal) {
        List<House> result = new ArrayList<>();
        List<String> typeOcDealList = Arrays.asList(typeOfDeal);
        for (House house : repository.getAll()) {
            if (typeOcDealList.contains(house.getTypeOfDeal())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByTypeOfProperty(String typeOfProperty) {
        List<House> result = new ArrayList<>();
        List<String> typeOfPropertyList = Arrays.asList(typeOfProperty);
        for (House house : repository.getAll()) {
            if (typeOfProperty.contains(house.getTypeOfProperty())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByPriceRange(int priceMin, int priceMax) {
        List<House> result = new ArrayList<>();
        for (House house : repository.getAll()) {
            if (house.getPrice() >= priceMin && house.getPrice() <= priceMax) {
                result.add(house);
            }
        }
        return result;
    }
}
