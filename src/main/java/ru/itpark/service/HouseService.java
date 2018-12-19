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

    public void add(House house) {
        repository.add(house);
    }

    public List<House> getAll() {
        return repository.getAll();
    }

    public List<House> getSorted(Comparator<House> comparator) {
        List<House> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public List<House> findByCity(String city) {
        List<House> result = new ArrayList<>();
        List<String> findByCityList = Arrays.asList(city);
        for (House house : repository.getAll()) {
            if (findByCityList.contains(house.getCity())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByNeighborhood(String neighborhood) {
        List<House> result = new ArrayList<>();
        List<String> findByNeighborhood = Arrays.asList(neighborhood);
        for (House house : repository.getAll()) {
            if (findByNeighborhood.contains(house.getNeighborhood())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByMetro(String metro) {
        List<House> result = new ArrayList<>();
        List<String> findByMetroList = Arrays.asList(metro);
        for (House house : repository.getAll()) {
            if (findByMetroList.contains(house.getMetro())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findWithPhoto() {
        List<House> result = new ArrayList<>();
        List<String> findByPhotoList = Arrays.asList();
        for (House house : repository.getAll()) {
            if (house.isPhoto()) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findWithoutPhoto() {
        List<House> result = new ArrayList<>();
        List<String> findByPhotoList = Arrays.asList();
        for (House house : repository.getAll()) {
            if (!house.isPhoto()) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findWithTypeOfDeal(String typeOfDeal) {
        List<House> result = new ArrayList<>();
        List<String> findByTypeOfDealList = Arrays.asList(typeOfDeal);
        for (House house : repository.getAll()) {
            if (findByTypeOfDealList.contains(house.getTypeOfDeal())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findByTypeOfProperty(String typeOfProperty) {
        List<House> result = new ArrayList<>();
        List<String> findByTypeOfPropertyList = Arrays.asList(typeOfProperty);
        for (House house : repository.getAll()) {
            if (findByTypeOfPropertyList.contains(house.getTypeOfProperty())) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> findPriceRange(int priceMin, int priceMax) {
        List<House> result = new ArrayList<>();
        for (House house : repository.getAll()) {
            if (house.getPrice() >= priceMin && house.getPrice() <= priceMax) {
                result.add(house);
            }
        }
        return result;
    }
}
