package com.mikipmax.controlador;

import com.mikipmax.dto.MedicoDto;
import com.mikipmax.modelo.Medico;
import com.mikipmax.servicio.IMedicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/medicos")
@RequiredArgsConstructor
public class MedicoControlador {

    private final IMedicoServicio medicoServicio;
   
    @Qualifier("medicoMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MedicoDto>> listarTodos() throws Exception {
        List<MedicoDto> listaMedico = medicoServicio.listarTodos().stream().map(medico -> modelMapper.map(medico, MedicoDto.class)).toList();
        return ResponseEntity.ok(listaMedico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDto> buscarPorId(@PathVariable("id") Long id) throws Exception {
        Medico medico = medicoServicio.buscarPorId(id);
        return ResponseEntity.ok(modelMapper.map(medico, MedicoDto.class));
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@Valid @RequestBody MedicoDto medicoRequest) throws Exception {
        Medico medico = medicoServicio.guardar(modelMapper.map(medicoRequest, Medico.class));
        URI localizacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(localizacion).build();
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@RequestBody MedicoDto medicoRequest) throws Exception {
        Medico medico = medicoServicio.actualizar(medicoRequest.getId(), modelMapper.map(medicoRequest, Medico.class));
        URI localizacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(localizacion).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception {
        medicoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<MedicoDto> buscarPorIdHateoas(@PathVariable("id") Long id) throws Exception {
        EntityModel<MedicoDto> entityModel = EntityModel.of(modelMapper.map(medicoServicio.buscarPorId(id), MedicoDto.class));
        //Se extrae la ruta con methodon
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(getClass()).buscarPorId(id));
        //Se asocia al recurso
        entityModel.add(linkBuilder.withRel("info-medico"));
        return entityModel;
    }

}
