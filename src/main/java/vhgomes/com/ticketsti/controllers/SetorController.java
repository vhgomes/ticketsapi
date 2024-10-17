package vhgomes.com.ticketsti.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vhgomes.com.ticketsti.dtos.CreateSetorDTO;
import vhgomes.com.ticketsti.services.SetorService;

@RestController("")
public class SetorController {
    private final SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @GetMapping("/setor")
    public ResponseEntity<?> getAllSetores() {
        return ResponseEntity.ok(setorService.getAllSetores());
    }

    @GetMapping("/setor/{setorId}")
    public ResponseEntity<?> getSetorById(@PathVariable Long setorId) {
        return ResponseEntity.ok(setorService.getSetorById(setorId));
    }

    @PostMapping("/setor")
    public ResponseEntity<?> addSetor(@RequestBody CreateSetorDTO createSetorDTO) {
        return setorService.createSetor(createSetorDTO);
    }

    @DeleteMapping("/setor/{setorId}")
    public ResponseEntity<?> deleteSetorById(@PathVariable Long setorId) {
        return setorService.deleteSetorById(setorId);
    }
}
