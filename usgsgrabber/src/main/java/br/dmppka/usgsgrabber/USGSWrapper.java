package br.dmppka.usgsgrabber;

import br.dmppka.usgsgrabber.config.USGSRestConfig;
import br.dmppka.usgsgrabber.model.Earthquake;

import java.util.List;

public interface USGSWrapper {

    List<Earthquake> getEarthquakes(USGSRestConfig config);
}