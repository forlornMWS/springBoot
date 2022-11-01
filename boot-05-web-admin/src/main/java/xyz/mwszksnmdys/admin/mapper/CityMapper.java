package xyz.mwszksnmdys.admin.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import xyz.mwszksnmdys.admin.bean.City;

@Mapper
public interface CityMapper {

    @Insert("insert into city(name, state, country) values (#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);

    @Select("select * from city where id = #{id}")
    City findById(Long id);
}
