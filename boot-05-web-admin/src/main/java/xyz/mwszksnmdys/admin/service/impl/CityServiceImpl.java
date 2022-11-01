package xyz.mwszksnmdys.admin.service.impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyz.mwszksnmdys.admin.bean.City;
import xyz.mwszksnmdys.admin.mapper.CityMapper;
import xyz.mwszksnmdys.admin.service.CityService;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    Counter counter;

    public City getById(Long id){
        return cityMapper.findById(id);
    }

    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);
    }


    public CityServiceImpl(MeterRegistry meterRegistry ){
        counter = meterRegistry.counter("CityService.saveCity.count");

    }

}
