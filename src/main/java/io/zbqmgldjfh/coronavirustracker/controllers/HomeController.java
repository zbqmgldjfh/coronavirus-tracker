package io.zbqmgldjfh.coronavirustracker.controllers;

import io.zbqmgldjfh.coronavirustracker.models.LocationStats;
import io.zbqmgldjfh.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    private final CoronaVirusDataService coronaVirusDataService;

    @Autowired
    public HomeController(CoronaVirusDataService service) {
        this.coronaVirusDataService = service;
    }

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalCases", totalCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
