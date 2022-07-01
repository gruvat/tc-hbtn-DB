package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        boolean t1 = testProduto();
        boolean t2 = testPessoa();

        System.out.println("FINAL RESULT TESTS : ");
        System.out.println("    TEST 1 : " + t1);
        System.out.println("    TEST 2 : " + t2);
    }

    private static boolean testProduto() {
        try {
            ProdutoModel produtoModel = new ProdutoModel();

            Produto p1 = new Produto();
            p1.setNome("TV");
            p1.setPreco(300.0);
            p1.setQuantidade(100);
            p1.setStatus(true);

            // 1) Criando um produto
            produtoModel.create(p1);

            //2) Buscando todos os produtos na base de dados
            List<Produto> produtos = produtoModel.findAll();
            System.out.println("Qtde de produtos encontrados : " + produtos.size());

            //3) Buscando um produto da base de dados
            Produto produtoProcurado = produtoModel.findById(p1);
            System.out.println("Nome do produto encontrado : " + produtoProcurado.getNome());

            //4) Dando update em um produto
            p1.setNome("Computador");
            produtoModel.update(p1);
            System.out.println("Nome do produto atualizado : " + p1.getNome());

            //5) Remove produto
            produtoModel.delete(p1);
            System.out.println("Número de produtos na base : " + produtoModel.findAll().size());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean testPessoa() {
        try {
            PessoaModel pessoaModel = new PessoaModel();

            Pessoa p1 = new Pessoa();
            p1.setNome("Marcos");
            p1.setEmail("marcos@gmail.com");
            p1.setCpf("12345678957");
            p1.setIdade("30/01/3030");

            // 1) Criando um produto
            pessoaModel.create(p1);

            //2) Buscando todos os produtos na base de dados
            List<Pessoa> pessoas = pessoaModel.findAll();
            System.out.println("Qtde de pessoas encontrados : " + pessoas.size());

            //3) Buscando um produto da base de dados
            Pessoa pessoaProcurado = pessoaModel.findById(p1);
            System.out.println("Nome do produto encontrado : " + pessoaProcurado.getNome());

            //4) Dando update em um produto
            p1.setNome("Computador");
            pessoaModel.update(p1);
            System.out.println("Nome do produto atualizado : " + p1.getNome());

            //5) Remove produto
            pessoaModel.delete(p1);
            System.out.println("Número de produtos na base : " + pessoaModel.findAll().size());

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
