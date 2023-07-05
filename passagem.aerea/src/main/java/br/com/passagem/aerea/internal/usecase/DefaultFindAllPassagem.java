package br.com.passagem.aerea.internal.usecase;

import br.com.passagem.aerea.api.usecase.FindAllPassagem;
import br.com.passagem.aerea.internal.entity.Passagem;
import br.com.passagem.aerea.internal.entity.User;
import br.com.passagem.aerea.internal.repository.PassagemRepository;
import br.com.passagem.aerea.internal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DefaultFindAllPassagem implements FindAllPassagem {

    @Autowired
    private PassagemRepository passagemRepository;

    @Override
    public List<Passagem> execute() {
        return passagemRepository.findAll();
    }
}
