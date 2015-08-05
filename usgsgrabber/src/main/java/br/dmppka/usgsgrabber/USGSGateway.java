package br.dmppka.usgsgrabber;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import br.dmppka.usgsgrabber.model.Earthquake;
import br.dmppka.usgsgrabber.model.xml.USGSXMLResponse;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class USGSGateway {

    private static USGSGateway instance = new USGSGateway();
    private Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    public static USGSGateway getInstance() {
        return instance;
    }

    private USGSGateway() {}

    public List<Earthquake> findEarthquakes(USGSRestConfig config) {
        USGSXMLResponse xmlResponse = getXMLResponse(config);
        // We haven't get correct response. No need to convert.
        if (xmlResponse == null) return newArrayList();

        return mapper.map(xmlResponse, List.class);
    }

    USGSXMLResponse getXMLResponse(USGSRestConfig config) {
        String uri = new URIBuilder().build(config);
        RestTemplate template = new RestTemplate(getConverters());
        return template.getForObject(uri, USGSXMLResponse.class);
    }

    List<HttpMessageConverter<?>> getConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new MappingJackson2XmlHttpMessageConverter());
        return converters;
    }
}
