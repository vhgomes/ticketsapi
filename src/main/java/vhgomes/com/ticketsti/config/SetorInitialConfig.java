package vhgomes.com.ticketsti.config;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vhgomes.com.ticketsti.models.Setor;
import vhgomes.com.ticketsti.repositories.SetorRepository;

@Configuration
public class SetorInitialConfig implements CommandLineRunner {

    private SetorRepository setorRepository;

    public SetorInitialConfig(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        long count = setorRepository.count();

        if (count >= 2) {
            System.out.println("Já existem 2 ou mais setores cadastrados. Nenhum setor adicional será criado.");
            return;
        }

        var setor1 = new Setor();
        setor1.setDescription("Teste Setor 1");
        setor1.setNome("Financeiro");
        setorRepository.save(setor1);

        var setor2 = new Setor();
        setor2.setDescription("Teste Setor 2");
        setor2.setNome("Recursos Humanos");
        setorRepository.save(setor2);

        System.out.println("Setores criados com sucesso.");
    }
}
