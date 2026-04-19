package com.systemorders.orders.controller;

import com.systemorders.orders.dto.ItensPedidosDTO;
import com.systemorders.orders.dto.PedidoDTO;
import com.systemorders.orders.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {
                "http://127.0.0.1:5500",
                "http://localhost:5500",
                "http://192.168.1.16:5500",
                "http://192.168.1.97:5500",
                "https://chupchupcremosao.com"
        },
        allowedHeaders = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)
@RestController
@RequestMapping("/admin/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // ==================== LISTAR PEDIDOS ====================
    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.getListaPedidos());
    }

    // ==================== CRIAR PEDIDO ====================
    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.CriarPedido(pedidoDTO));
    }

    // ==================== ATUALIZAR STATUS ====================
    @PutMapping("/status/{id}")
    public ResponseEntity<PedidoDTO> statusPedido(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.atualizarStatus(id));
    }

    // ==================== BUSCAR POR ID ====================
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.buscarPorID(id));
    }

    // ==================== DELETAR PEDIDO ====================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Integer id) {
        pedidoService.deleteItenspedido(id);
        return ResponseEntity.noContent().build();
    }

    // ==================== PEDIDOS DO DIA ====================
    @GetMapping("/resumo/quantidade")
    public ResponseEntity<Integer> pedidosDoDia() {
        return ResponseEntity.ok(pedidoService.pedidosdoDia());
    }

    // ==================== TOTAL DO DIA ====================
    @GetMapping("/resumo/total")
    public ResponseEntity<Double> totalPedido() {
        return ResponseEntity.ok(pedidoService.LucroDoDia());
    }

    // ==================== LIMPAR PEDIDOS ====================
    @DeleteMapping("/resumo/limpar")
    public ResponseEntity<Void> limparPedidos() {
        pedidoService.LimparDados();
        return ResponseEntity.noContent().build();
    }
}