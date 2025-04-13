package com.lojacosmeticos.lojacosmeticos.Spring.service;

import com.lojacosmeticos.lojacosmeticos.Spring.exception.RecursoNaoEncontradoException;
import com.lojacosmeticos.lojacosmeticos.Spring.model.Cadastro;
import com.lojacosmeticos.lojacosmeticos.Spring.repository.CadastroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public Cadastro salvarCadastro(Cadastro cadastro) {
        try {
            validarSenha(cadastro.getSenha());
            validarIdade(cadastro.getDataNascimento());
            return cadastroRepository.save(cadastro);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cadastro: " + e.getMessage());
        }
    }

    public List<Cadastro> listarTodos() {
        try {
            return cadastroRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar cadastros: " + e.getMessage());
        }
    }

    public Cadastro buscarPorId(Long id) {
        try {
            return cadastroRepository.findById(id)
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Cadastro com ID " + id + " não encontrado!"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cadastro: " + e.getMessage());
        }
    }

    public void deletarCadastro(Long id) {
        try {
            Cadastro cadastro = buscarPorId(id);
            cadastroRepository.delete(cadastro);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar cadastro: " + e.getMessage());
        }
    }

    private void validarSenha(String senha) {
        if (senha == null || senha.length() != 8) {
            throw new IllegalArgumentException("A senha deve ter exatamente 8 caracteres.");
        }
    }

    private void validarIdade(Date dataNascimento) {
        LocalDate nascimento = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - nascimento.getYear();
        if (nascimento.plusYears(idade).isAfter(hoje)) {
            idade--;
        }
        if (idade < 18) {
            throw new IllegalArgumentException("O cliente precisa ter mais de 18 anos para se cadastrar.");
        }
    }
}
