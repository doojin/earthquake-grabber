package br.dmppka.usgsgrabber;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import br.dmppka.usgsgrabber.model.Earthquake;
import br.dmppka.usgsgrabber.model.xml.USGSXMLResponse;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class USGSGatewayTest {

    @InjectMocks
    private USGSGateway gateway;
    @Mock
    private Mapper mapper;

    @Test
    public void getConverters_returnedListShouldContainMappingJackson2XmlHttpMessageConverter() {
        List<HttpMessageConverter<?>> converters = gateway.getConverters();

        assertThat(converters.size(), equalTo(1));
        assertTrue(converters.get(0) instanceof MappingJackson2XmlHttpMessageConverter);
    }

    @Test
    public void findEarthquakes_shouldReturnEmptyArrayListIfXMLResponseIsNull() {
        USGSRestConfig config = new USGSRestConfig();
        gateway = spy(gateway);
        doReturn(null).when(gateway).getXMLResponse(config);

        List<Earthquake> earthquakes = gateway.findEarthquakes(config);

        assertThat(earthquakes.size(), equalTo(0));
    }

    @Test
    public void findEarthquakes_mapperShouldMapXMLResponseToListIfXMLResponseIsNotNull() {
        gateway = spy(gateway);
        USGSRestConfig config = new USGSRestConfig();
        USGSXMLResponse response = new USGSXMLResponse();
        doReturn(response).when(gateway).getXMLResponse(config);

        gateway.findEarthquakes(config);

        verify(mapper, times(1)).map(response, List.class);
    }
}