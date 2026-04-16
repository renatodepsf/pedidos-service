package com.renato.pedidos.controller;

import com.renato.pedidos.dto.request.PedidoRequest;
import com.renato.pedidos.dto.response.PedidoResponse;
import com.renato.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService pedidoService) {
        this.service = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody @Valid PedidoRequest request) {

        PedidoResponse response = service.criarPedido(request);
        URI uri = URI.create("/pedidos/" + response.getId());

//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(response.getId())
//                .toUri();

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPedidoPorId(@PathVariable Long id) {
        PedidoResponse response = service.buscarPedidoPorId(id);

        URI uri = URI.create("/pedidos/" + response.getId());

        return ResponseEntity
                .created(uri)
                .body(response);
    }
}
