package vhgomes.com.ticketsti.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vhgomes.com.ticketsti.dtos.CreateTicketDTO;
import vhgomes.com.ticketsti.dtos.UpdateTicketDTO;
import vhgomes.com.ticketsti.models.Setor;
import vhgomes.com.ticketsti.models.Status;
import vhgomes.com.ticketsti.models.Ticket;
import vhgomes.com.ticketsti.repositories.SetorRepository;
import vhgomes.com.ticketsti.repositories.StatusRepository;
import vhgomes.com.ticketsti.repositories.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final SetorRepository setorRepository;
    private final StatusRepository statusRepository;

    public TicketService(TicketRepository ticketRepository, SetorRepository setorRepository, StatusRepository statusRepository) {
        this.ticketRepository = ticketRepository;
        this.setorRepository = setorRepository;
        this.statusRepository = statusRepository;
    }

    public ResponseEntity<?> createTicket(CreateTicketDTO createTicketDTO) {
        Optional<Setor> setorOptional = setorRepository.findById(createTicketDTO.setor());
        Optional<Status> statusOptional = statusRepository.findById(3L);

        if (setorOptional.isEmpty() || statusOptional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Setor setor = setorOptional.get();
        Status status = statusOptional.get();

        Ticket ticket = new Ticket();

        ticket.setSetor(setor);
        ticket.setTitle(createTicketDTO.title());
        ticket.setDescription(createTicketDTO.description());
        ticket.setStatus(status);
        ticket.setCategory(createTicketDTO.category());

        ticketRepository.save(ticket);

        return ResponseEntity.ok(ticket);
    }

    public ResponseEntity<?> updateTicket(UpdateTicketDTO dto, Long ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        Optional<Status> optionalStatus = statusRepository.findById(dto.status());
        if (optionalTicket.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Ticket ticket = optionalTicket.get();
        ticket.setCategory(dto.category());
        ticket.setDescription(dto.description());
        ticket.setTitle(dto.title());
        ticket.setStatus(optionalStatus.get());

        ticketRepository.save(ticket);

        return ResponseEntity.ok(ticket);
    }


    public ResponseEntity<?> deleteTicket(Long ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            ticketRepository.delete(ticket.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return ResponseEntity.ok(tickets);
    }

    public ResponseEntity<?> getAllTicketsBySetor(Long setorId) {
        var setor = setorRepository.findById(setorId);

        if (setor.isPresent()) {
            var tickets = ticketRepository.findAllBySetorId(setorId);
            return ResponseEntity.ok(tickets);
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> getAllTicketsByStatus(Long statusId) {
        var status = statusRepository.findById(statusId);
        if (status.isPresent()) {
            var tickets = ticketRepository.findAllByStatusId(statusId);
            return ResponseEntity.ok(tickets);
        }

        return ResponseEntity.notFound().build();
    }

    private Ticket convertFromDto(CreateTicketDTO createTicketDTO, Setor setor, Status status) {
        return new Ticket(createTicketDTO.title(), createTicketDTO.description(), createTicketDTO.category(), status, setor);
    }
}