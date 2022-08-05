package miu.edu.AlumniTrackingSystem.controller;

import miu.edu.AlumniTrackingSystem.service.JobAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobattachment")
@CrossOrigin("*")
public class JobAttachmentController {
    @Autowired
    private JobAttachmentService jobAttachmentService;

    @GetMapping("/{advertisement_id}")
    public ResponseEntity<Resource> readFileByAdvertisement(@PathVariable int advertisement_id) {
        String filename = jobAttachmentService.getFileNameById(advertisement_id);
        Resource file = jobAttachmentService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "inline; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
