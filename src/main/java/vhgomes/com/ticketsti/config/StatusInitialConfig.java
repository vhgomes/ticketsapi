package vhgomes.com.ticketsti.config;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vhgomes.com.ticketsti.models.Status;
import vhgomes.com.ticketsti.repositories.StatusRepository;

@Configuration
@Transactional
public class StatusInitialConfig implements CommandLineRunner {

    private final StatusRepository statusRepository;

    public StatusInitialConfig(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long statusCount = statusRepository.count();

        if (statusCount < 3) {
            var status1 = new Status();
            status1.setStatus("Completo");
            status1.setDescription("Description1");
            statusRepository.save(status1);

            var status2 = new Status();
            status2.setStatus("Em andamento");
            status2.setDescription("Description2");
            statusRepository.save(status2);

            var status3 = new Status();
            status3.setStatus("Não iniciado");
            status3.setDescription("Description3");
            statusRepository.save(status3);

            System.out.println("Status criados com sucesso.");
        } else {
            System.out.println("Já existem 3 ou mais status cadastrados. Nenhum status adicional será criado.");
        }
    }
}
