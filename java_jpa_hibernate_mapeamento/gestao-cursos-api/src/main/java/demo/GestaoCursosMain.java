package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.Date;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) {
        // Criando professor
        Professor professor = new Professor();
        professor.setNomeCompleto("Marcos Galvão");
        professor.setEmail("mgalvao@ciandt.com");
        professor.setMatricula("matriculado");

        // Criando material do curso
        MaterialCurso material = new MaterialCurso();
        material.setUrl("www.goolge.com");

        // Criando curso
        Curso curso = new Curso();
        curso.setNome("Bootcamp Java");
        curso.setSigla("BTCJ");
        // Relacionamentos do curso
        curso.setProfessor(professor);
        curso.setMaterial(material);

        // Criando Telefone
        Telefone telefone = new Telefone();
        telefone.setDDD("081");
        telefone.setNumero("993817977");

        //Criando Endereço
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Somewhere");
        endereco.setEndereco("Rua ruada");
        endereco.setNumero("111");
        endereco.setBairro("Japalão");
        endereco.setCidade("Da Rocha");
        endereco.setEstado("Duralex");
        endereco.setCep(12345789);

        //Criando aluno
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Marcos galvão Junior");
        aluno.setMatricula("123456789");
        aluno.setNascimento(new Date("30/01/2000"));
        aluno.setEmail("mgalvao@ciandt.com");
        // Relacionamentos de aluno
        aluno.setTelefones(List.of(telefone));
        aluno.setEnderecos(List.of(endereco));

        // Relacionamento curso e aluno
        aluno.setCurso(curso);

        // -----------------------------------------------------------------
        // -----------------------------------------------------------------
        // -----------------------------------------------------------------


        // CursoModel
        CursoModel cursoModel = new CursoModel();
        cursoModel.create(curso);

        // AlunoModel
        AlunoModel alunoModel = new AlunoModel();
        alunoModel.create(aluno);

    }
}
