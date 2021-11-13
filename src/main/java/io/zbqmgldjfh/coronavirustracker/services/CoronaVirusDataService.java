package io.zbqmgldjfh.coronavirustracker.services;

import io.zbqmgldjfh.coronavirustracker.models.LocationStats;

import java.io.IOException;
import java.util.List;

public interface CoronaVirusDataService {

    public List<LocationStats> getAllStats();
    public void fetchVirusData() throws IOException, InterruptedException;

}
