package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class MessageSenderImplTest {

    @Test
    void thatOnlyRussianTextIsSentIfIpFromRussia() {
        GeoService geoService = Mockito.mock(GeoService.class);
        when(geoService.byIp(Mockito.any(String.class)))
                .thenReturn(new Location(null, Country.RUSSIA, null, 0));

        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "0.0.0.0");

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, messageSender.send(headers));

    }

    @Test
    void thatOnlyEnglishTextIsSentIfIpFromUSA() {
        GeoService geoService = Mockito.mock(GeoService.class);
        when(geoService.byIp(Mockito.any(String.class)))
                .thenReturn(new Location(null, Country.USA, null, 0));

        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "0.0.0.0");

        String expected = "Welcome";

        Assertions.assertEquals(expected, messageSender.send(headers));

    }
}
