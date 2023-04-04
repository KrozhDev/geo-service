package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {




    GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);

    MessageSenderImpl msgSender = new MessageSenderImpl(geoService, localizationService);



    @BeforeEach
    void init(){
        Mockito.reset(geoService, localizationService);


    }


    @Test
    void sendRussian() {
        Location locationRus = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(locationRus);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Привет!");
        Map<String, String> testIpMap = new HashMap<>();
        testIpMap.put("sf","127.234234");
        Assertions.assertEquals("Привет!",msgSender.send(testIpMap));
    }
    @Test
    void sendUsa() {
        Location locationUsa = new Location("New York", Country.USA, "Lenina", 15);
        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(locationUsa);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Hello");
        Map<String, String> testIpMap = new HashMap<>();
        testIpMap.put("sfsfa","96.44.183.149");
        Assertions.assertEquals("Hello",msgSender.send(testIpMap));
    }
}