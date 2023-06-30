package org.learning.controller;

import org.learning.dto.CreatePresignedUrlDto;
import org.learning.service.AmazonS3Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal")
public class InternalController {

    private final AmazonS3Service amazonS3Service;

    public InternalController(AmazonS3Service service) {
        this.amazonS3Service = service;
    }

    @PostMapping("/presigned-url/{bucket}")
    public String getPresignedUrlWithBucket(@PathVariable String bucket,
                                            @RequestBody CreatePresignedUrlDto dto) {
        return amazonS3Service.generatePresignedUrl(dto.fileName(), bucket);
    }
}
