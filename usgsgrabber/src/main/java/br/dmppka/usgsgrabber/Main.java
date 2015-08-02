package br.dmppka.usgsgrabber;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import br.dmppka.usgsgrabber.config.USGSRestConfigBuilder;

public class Main {

    public static void main(String[] args) {
        USGSRestConfig config = new USGSRestConfigBuilder()
                .withResponseFormat(ResponseFormat.XML)
                .withStartTime("20.03.1991 00:00:00")
                .withEndTime("21.03.1991 00:00:00")
                .withLimit(5)
                .withMinLatitude(-90)
                .withMaxLatitude(90)
                .withMinLongitude(-90)
                .withMaxLongitude(90)
                .withMinMagnitude(0)
                .withMaxMagnitude(10)
                .build();

        URIBuilder builder = new URIBuilder();
        String url = builder.build(config);
        System.out.println(url);
    }
}