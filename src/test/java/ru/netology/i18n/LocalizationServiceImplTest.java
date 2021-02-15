package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {

    @Test
    void testingMethodLocaleFromLocalizationServiceImpl() {
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);

        String expected = "Welcome";

        Assertions.assertEquals(expected, localizationService.locale(Country.BRAZIL));
    }
}
