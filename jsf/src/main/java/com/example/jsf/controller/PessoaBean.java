package com.example.jsf.controller;

import com.example.jsf.model.Pessoa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
    private List<Pessoa> pessoas = new ArrayList<>();
    private Pessoa pessoa = new Pessoa();

    public void adicionar() {
        Pessoa novaPessoa = new Pessoa(pessoa.getNome(), pessoa.getEmail());
        pessoas.add(novaPessoa);
        pessoa = new Pessoa(); // Limpar os campos após adicionar uma pessoa
    }

    public void editarPessoa(String nome) throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath() + "/paginas/Sucesso.xhtml?nome=" + nome);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
