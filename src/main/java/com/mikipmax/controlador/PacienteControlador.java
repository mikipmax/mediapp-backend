package com.mikipmax.controlador;

import com.mikipmax.dto.PacienteDto;
import com.mikipmax.modelo.Paciente;
import com.mikipmax.servicio.IPacienteServicio;
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
@RequestMapping("/v1/pacientes")
@RequiredArgsConstructor
public class PacienteControlador {

    private final IPacienteServicio pacienteServicio;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PacienteDto>> listarTodos() throws Exception {
        List<PacienteDto> listaPaciente = pacienteServicio.listarTodos().stream().map(paciente -> modelMapper.map(paciente, PacienteDto.class)).toList();
        return ResponseEntity.ok(listaPaciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPorId(@PathVariable("id") Long id) throws Exception {
        Paciente paciente = pacienteServicio.buscarPorId(id);
        return ResponseEntity.ok(modelMapper.map(paciente, PacienteDto.class));
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@Valid @RequestBody PacienteDto pacienteRequest) throws Exception {
        Paciente paciente = pacienteServicio.guardar(modelMapper.map(pacienteRequest, Paciente.class));
        URI localizacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(localizacion).build();
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@RequestBody PacienteDto pacienteRequest) throws Exception {
        Paciente paciente = pacienteServicio.actualizar(pacienteRequest.getId(), modelMapper.map(pacienteRequest, Paciente.class));
        URI localizacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(localizacion).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception {
        pacienteServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<PacienteDto> buscarPorIdHateoas(@PathVariable("id") Long id) throws Exception {
        EntityModel<PacienteDto> entityModel = EntityModel.of(modelMapper.map(pacienteServicio.buscarPorId(id), PacienteDto.class));
        //Se extrae la ruta con methodon
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(getClass()).buscarPorId(id));
        //Se asocia al recurso
        entityModel.add(linkBuilder.withRel("info-paciente"));
        return entityModel;
    }
     
}
