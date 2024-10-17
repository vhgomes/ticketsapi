package vhgomes.com.ticketsti.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vhgomes.com.ticketsti.dtos.CreateStatusDTO;
import vhgomes.com.ticketsti.models.Status;
import vhgomes.com.ticketsti.repositories.StatusRepository;

import java.util.Optional;

@Service
public class StatusService {
    private StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public ResponseEntity<?> createStatus(CreateStatusDTO dto) {
        if (dto.status().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Status status = convertFromDTO(dto);

        try {
            statusRepository.save(status);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok(status);
    }

    public ResponseEntity<?> getStatusById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        
        if (status.isPresent()) {
            return ResponseEntity.ok(status.get());
        }

        return ResponseEntity.notFound().build();
    }

    private Status convertFromDTO(CreateStatusDTO dto) {
        return new Status(dto.status(), dto.description());
    }

}
