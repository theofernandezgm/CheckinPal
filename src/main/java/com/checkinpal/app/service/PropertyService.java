// src/main/java/com/checkinpal/app/service/PropertyService.java
package com.checkinpal.app.service;

import com.checkinpal.app.domain.HostAccount;
import com.checkinpal.app.domain.Property;
import com.checkinpal.app.repository.HostAccountRepository;
import com.checkinpal.app.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final S3Service s3Service;
    private final HostAccountRepository hostAccountRepository;

    public PropertyService(PropertyRepository propertyRepository, S3Service s3Service, HostAccountRepository hostAccountRepository) {
        this.propertyRepository = propertyRepository;
        this.s3Service = s3Service;
        this.hostAccountRepository = hostAccountRepository;
    }

    @Transactional
    public Property createProperty(String address, String hutNumber, int capacity, MultipartFile document, Long hostAccountId) throws IOException {
        // Step 1: Upload the document and get its key
        String documentKey = s3Service.uploadFile(document);

        // Step 2: Find the host account that this property belongs to
        // NOTE: Later, we will get the hostAccountId from the logged-in user. For now, we pass it in.
        HostAccount host = hostAccountRepository.findById(hostAccountId)
                .orElseThrow(() -> new IllegalStateException("Host account not found"));

        // Step 3: Create and save the new property
        Property newProperty = new Property();
        newProperty.setAddress(address);
        newProperty.setHutNumber(hutNumber);
        newProperty.setCapacity(capacity);
        newProperty.setDocumentsS3Key(documentKey);
        newProperty.setHost(host);

        return propertyRepository.save(newProperty);
    }
}