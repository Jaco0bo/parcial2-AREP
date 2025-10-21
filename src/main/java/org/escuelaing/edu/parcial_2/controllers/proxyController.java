package org.escuelaing.edu.parcial_2.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class proxyController {
    private final List<String> backendUrls;
    private final AtomicInteger currentIndex = new AtomicInteger();

    public proxyController(@Value("${BACKEND_URLS}") List<String> backendUrlsEnv) {
        if (backendUrlsEnv.isEmpty()) {
            throw new IllegalArgumentException("No backend urls found");
        }
        this.backendUrls = backendUrlsEnv;
    }

    @GetMapping("/proxy/factores")
    public Object forwardRequest(@RequestParam int value) {
        String backendUrl = getNextBackendUrl();
        String url = backendUrl + "/factores?value=" + value;
        return new RestTemplate().getForObject(url, Object.class);
    }

    public String getNextBackendUrl() {
        int index = currentIndex.getAndUpdate(i -> (i + 1) % backendUrls.size());
        return backendUrls.get(index);
    }
}
