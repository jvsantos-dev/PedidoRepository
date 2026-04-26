package br.com.fiap3ESPV.checkpoint2.controller;

import br.com.fiap3ESPV.checkpoint2.model.Pedido;
import br.com.fiap3ESPV.checkpoint2.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // 🔹 GET /pedidos → listar todos
    @GetMapping
    public List<Pedido> listar() {
        return service.listar();
    }

    // 🔹 GET /pedidos/{id} → buscar por id
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // 🔹 POST /pedidos → criar novo pedido
    @PostMapping
    public Pedido criar(@RequestBody @Valid Pedido pedido) {
        return service.salvar(pedido);
    }

    // 🔹 PUT /pedidos/{id} → atualizar
    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody @Valid Pedido pedidoAtualizado) {
        Pedido pedido = service.buscarPorId(id);

        pedido.setClienteNome(pedidoAtualizado.getClienteNome());
        pedido.setValorTotal(pedidoAtualizado.getValorTotal());

        return service.salvar(pedido);
    }

    // 🔹 DELETE /pedidos/{id} → deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}