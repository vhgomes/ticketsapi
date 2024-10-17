package vhgomes.com.ticketsti.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vhgomes.com.ticketsti.dtos.CreateTicketDTO;
import vhgomes.com.ticketsti.dtos.UpdateTicketDTO;
import vhgomes.com.ticketsti.services.TicketService;

@RestController()
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/tickets")
    public ResponseEntity<?> createTicket(@RequestBody CreateTicketDTO ticketDTO) {
        return ticketService.createTicket(ticketDTO);
    }

    @GetMapping("/tickets")
    public ResponseEntity<?> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PutMapping("/tickets/{ticketId}")
    public ResponseEntity<?> updateTicket(@PathVariable("ticketId") Long ticketId, @RequestBody UpdateTicketDTO updateTicketDTO) {
        return ticketService.updateTicket(updateTicketDTO, ticketId);
    }

    @DeleteMapping("/tickets/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable("ticketId") Long ticketId) {
        return ticketService.deleteTicket(ticketId);
    }

    @GetMapping("/tickets/setor/{setorId}")
    public ResponseEntity<?> getTicketBySetorId(@PathVariable("setorId") Long setorId) {
        return ticketService.getAllTicketsBySetor(setorId);
    }

    @GetMapping("/tickets/status/{statusId}")
    public ResponseEntity<?> getTicketByStatusId(@PathVariable("statusId") Long statusId) {
        return ticketService.getAllTicketsByStatus(statusId);
    }
}
