package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    Location location = Mockito.mock(Location.class);
    GeoServiceImpl geoService = new GeoServiceImpl();

    @Test
    void byIpRus() {
        Mockito.when(location.getCountry()).thenReturn(Country.RUSSIA);
        Country tested = geoService.byIp("172.0.32.11").getCountry();
        Country expected = location.getCountry();
        Assertions.assertEquals(expected,tested);
    }

    @Test
    void byIpUsa() {
        Mockito.when(location.getCountry()).thenReturn(Country.USA);
        Country tested = geoService.byIp("96.44.183.149").getCountry();
        Country expected = location.getCountry();
        Assertions.assertEquals(expected,tested);
    }


}