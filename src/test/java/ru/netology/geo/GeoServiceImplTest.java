package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

public class GeoServiceImplTest {

    @Test
    void testingMethodByIpFromGeoServiceImpl() {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);

        Country expected = Country.USA;

        Assertions.assertEquals(expected, geoService.byIp("96.0.0.0").getCountry());
    }
}
