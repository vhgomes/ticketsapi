package vhgomes.com.ticketsti.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vhgomes.com.ticketsti.dtos.CreateSetorDTO;
import vhgomes.com.ticketsti.models.Setor;
import vhgomes.com.ticketsti.repositories.SetorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {

    private SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public ResponseEntity<?> createSetor(CreateSetorDTO createSetorDTO) {

        if (createSetorDTO.nome().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Setor setor = convertFromDTO(createSetorDTO);

        try {
            setorRepository.save(setor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(setor);
    }

    public ResponseEntity<?> getSetorById(Long id) {
        Optional<Setor> setor = setorRepository.findById(id);

        if (setor.isPresent()) {
            return ResponseEntity.ok(setor.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<?> deleteSetorById(Long id) {
        Optional<Setor> setor = setorRepository.findById(id);

        if (setor.isPresent()) {
            setorRepository.delete(setor.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<?> getAllSetores() {
        List<Setor> setors = setorRepository.findAll();

        if (setors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(setors);
        }
    }

    public Setor convertFromDTO(CreateSetorDTO dto) {
        return new Setor(dto.nome(), dto.description());
    }
}


