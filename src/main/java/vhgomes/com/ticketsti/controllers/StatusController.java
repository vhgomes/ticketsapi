package vhgomes.com.ticketsti.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vhgomes.com.ticketsti.dtos.CreateStatusDTO;
import vhgomes.com.ticketsti.services.StatusService;

@RestController()
public class StatusController {
    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/status/{statusId}")
    private ResponseEntity<?> getStatus(@PathVariable Long statusId) {
        return statusService.getStatusById(statusId);
    }

    @PostMapping("/status")
    private ResponseEntity<?> createStatus(@RequestBody CreateStatusDTO createStatusDTO) {
        return statusService.createStatus(createStatusDTO);
    }
}
