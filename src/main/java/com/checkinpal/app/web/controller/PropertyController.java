// src/main/java/com/checkinpal/app/web/controller/PropertyController.java
package com.checkinpal.app.web.controller;

import com.checkinpal.app.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProperty(@RequestPart("address") String address,
                               @RequestPart("hutNumber") String hutNumber,
                               @RequestPart("capacity") int capacity,
                               @RequestPart("document") MultipartFile document) throws IOException {
        // For now, we'll hardcode the host ID to 1 since we don't have login yet.
        // This assumes the first user you created has ID=1.
        propertyService.createProperty(address, hutNumber, capacity, document, 1L);
    }
}