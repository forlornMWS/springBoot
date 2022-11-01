package xyz.mwszksnmdys.admin.service;

import xyz.mwszksnmdys.admin.bean.City;

public interface CityService {
    public City getById(Long id);

    public void saveCity(City city);

}
