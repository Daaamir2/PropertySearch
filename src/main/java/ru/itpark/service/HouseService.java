package ru.itpark.service;

import ru.itpark.domain.House;
import ru.itpark.repository.HouseRepository;


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

    public HouseService findByCity(String city) {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.getCity().equalsIgnoreCase(city)) {
                service.add(house);
            }
        }
        return service;
    }

    public HouseService findByNeighborhood(String neighborhood) {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.getNeighborhood().equalsIgnoreCase(neighborhood)) {
                service.add(house);
            }
        }
        return service;
    }

    public HouseService findByMetro(String metro) {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.getMetro() == null) {
            } else if (house.getMetro().equalsIgnoreCase(metro)) {
                service.add(house);
            }
        }
        return service;
    }

    public HouseService findByPhoto() {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.isPhoto()) {
                service.add(house);
            }
        }
        return service;
    }

    public HouseService findByTypeOfDeal(String typeOfDeal) {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.getTypeOfDeal().equalsIgnoreCase(typeOfDeal)) {
                service.add(house);
            }
        }
        return service;
    }

    public HouseService findByTypeOfProperty(String typeOfProperty) {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.getTypeOfProperty().equalsIgnoreCase(typeOfProperty)) {
                service.add(house);
            }
        }
        return service;
    }

    public HouseService findPriceRange(int priceMin, int priceMax) {
        HouseService service = new HouseService(new HouseRepository());
        for (House house : repository.getAll()) {
            if (house.getPrice() >= priceMin && house.getPrice() <= priceMax) {
                service.add(house);
            }
        }
        return service;
    }
}
