package br.com.otero.BarberShop.service;

import br.com.otero.BarberShop.model.Venda;
import br.com.otero.BarberShop.model.dto.VendaResponse;
import br.com.otero.BarberShop.repository.ProdutoRepository;
import br.com.otero.BarberShop.repository.VendaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public Optional<Venda> buscaId(Long id) {
        return this.vendaRepository.findById(id);

    }


    public List<Venda> historico() {
        return this.vendaRepository.findAll();
    }

    public VendaResponse agendamento(Long id_fun, Long id_cli) {
        Venda venda = Venda.builder()
                .id_Funcionario(id_fun)
                .id_Cliente(id_cli)
                .id_agendamento(new Date())
                .pago(false)
                .build();


        this.vendaRepository.save(venda);
        return VendaResponse.builder()
                .horarioMarcado(new Date())
                .build();
    }


    public void pagamento(Long id) throws NotFoundException {
        Venda venda = this.vendaRepository.findById(id).orElseThrow(() -> new NotFoundException("id: " + id + " Não encontrado"));
        venda.setPago(true);
        this.vendaRepository.save(venda);
    }


//    public Venda comanda(/*Optional<Venda> id,*/ Venda produtos) {
//        List<Long> ids = produtos.getProdutos().stream().map(Produto::getId).collect(Collectors.toList());
//        List<Produto> listaProdutos = produtoRepository.findByIds(ids);
//
//
//        return Venda.builder()
//                .id(produtos.getId())
////                .produtos(listaProdutos)
//                .valorTotal(listaProdutos.stream().mapToDouble(Produto::getPreco).sum())
//                .build();
//    }
//

    public Double calculaValorVenda() {

        return null;


    }

//    public Double calculaComanda(Venda produtos){
//        List<Long> ids = produtos.getProdutos().stream().map(Produto::getId).collect(Collectors.toList());
//        List<Produto> listaProdutos = produtoRepository.findByIds(ids);
//        Double preco =0D;
//        Long idProduto = this.produtoRepository.getById(listaProdutos);
//
//        Produto collect = listaProdutos.stream().map(produto -> (
//
//           preco =  this.produtoRepository.valorProduto(idProduto);
//
//                calculaValorProduto(produto.buscaId(),produto.getQtdProdutos() );
//
//        ).collect(Collectors.toList()));
//
//
//        calculaValorProduto(collect);
//
//        return null;
//    }


    public Double valorProduto(Long id, Integer qtd) {

        Double valor = this.produtoRepository.precoProduto(id);
        return valor * qtd;

    }

}
