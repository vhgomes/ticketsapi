package vhgomes.com.ticketsti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vhgomes.com.ticketsti.models.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
}
