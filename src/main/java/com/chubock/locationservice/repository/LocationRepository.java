package com.chubock.locationservice.repository;

import com.chubock.locationservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByFeatureCodeAndCountryCode(String featureCode, String countryCode);

    @Query("from Location l where l.featureCode in ('ADM2', 'ADM3', 'ADM4', 'ADM5') " +
            "and l.countryCode = :countryCode and l.admin1Code = :provinceCode and lower(l.asciiName) like concat('%', :name, '%')")
    List<Location> searchCities(String countryCode, String provinceCode, String name);
}
