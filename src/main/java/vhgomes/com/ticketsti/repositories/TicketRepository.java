package vhgomes.com.ticketsti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vhgomes.com.ticketsti.models.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllBySetorId(Long setorId);

    List<Ticket> findAllByStatusId(Long statusId);
}
