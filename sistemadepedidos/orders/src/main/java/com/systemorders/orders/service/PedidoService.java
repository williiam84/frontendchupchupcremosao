package com.systemorders.orders.service;

import com.systemorders.orders.dto.ItensPedidosDTO;
import com.systemorders.orders.dto.PedidoDTO;
import com.systemorders.orders.service.taxa.TaxaFixaTres;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private List<PedidoDTO> listaPedidos = new ArrayList<>();
    private List<ItensPedidosDTO> listaItensPedidos = new ArrayList<>();

    int contador = 0;
    //const taxas = {
    //  "novo horizonte": 3,
    //  "maria manteiga": 3,
    //  "santana": 4,
    //  "quilombo novo": 4,
    //  "quilombo": 4,
    //  "antonio lopez": 4
    //};
    public PedidoDTO CriarPedido(PedidoDTO pedidoDTO){
        contador++;
        pedidoDTO.setId(contador);
        String bairro = pedidoDTO.getBairro().toLowerCase();
        Double total = pedidoDTO.getProduto().stream().mapToDouble(item -> item.getQuantidade() * item.getPreco()).sum();
        Double totalfinal = total;
        if (bairro.equals("maria manteiga") || bairro.equals("novo horizonte")) {
            totalfinal += 3;
        } else if (bairro.equals("santana") || bairro.equals("quilombo novo") || bairro.equals("quilombo") || bairro.equals("antonio lopez")) {
            totalfinal += 4;
        }else if (total >= 21  && total <=35){
           totalfinal += 2;
        }
        pedidoDTO.setTotal(totalfinal);
        listaPedidos.add(pedidoDTO);
        return pedidoDTO;
    }

    //BUSCAR POR I

    public List<PedidoDTO> getListaPedidos(){
        return listaPedidos;
    }

    public PedidoDTO buscarPorID(Integer id){
        return listaPedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public PedidoDTO atualizarStatus(Integer id) {
        for (PedidoDTO pedido : listaPedidos) {
            if (pedido.getId().equals(id)) {

                if (pedido.getStatus().equals("PENDENTE")) {
                    pedido.setStatus("PREPARANDO");
                } else if (pedido.getStatus().equals("PREPARANDO")) {
                    pedido.setStatus("SAIU");
                } else {
                    pedido.setStatus("ENTREGUE");
                }

                return pedido;
            }
        }
        throw new RuntimeException("Pedido não encontrado");
    }

    public List<ItensPedidosDTO> deleteItenspedido(Integer id) {
        PedidoDTO pedidoDTO = buscarPorID(id);
        listaItensPedidos.remove(pedidoDTO);
        return listaItensPedidos;
    }

    public int pedidosdoDia(){
        return listaPedidos.size();
    }

    public void LimparDados(){
         listaPedidos.clear();
    }

    //SOMAR TOTAL DE VENDA DO DIA

    public Double LucroDoDia(){
        return listaPedidos.stream().mapToDouble(PedidoDTO::getTotal).sum();
    }
}
