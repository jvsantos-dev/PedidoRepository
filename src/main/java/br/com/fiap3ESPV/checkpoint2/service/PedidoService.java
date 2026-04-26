package br.com.fiap3ESPV.checkpoint2.service;

import br.com.fiap3ESPV.checkpoint2.model.Pedido;
import br.com.fiap3ESPV.checkpoint2.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido salvar(Pedido pedido) {
        return repository.save(pedido);
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}