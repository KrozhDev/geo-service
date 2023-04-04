package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    LocalizationServiceImpl localization;

    @Test
    void rusLocale() {

        localization = new LocalizationServiceImpl();

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected,localization.locale(Country.RUSSIA));
    }

    @Test
    void usaLocale() {
        localization = new LocalizationServiceImpl();

        String expected = "Welcome";

        Assertions.assertEquals(expected,localization.locale(Country.USA));
    }
}