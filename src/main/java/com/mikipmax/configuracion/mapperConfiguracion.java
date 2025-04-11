package com.mikipmax.configuracion;

import com.mikipmax.dto.MedicoDto;
import com.mikipmax.modelo.Medico;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapperConfiguracion {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean("medicoMapper")
    public ModelMapper medicoMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //Escritura
        TypeMap<MedicoDto, Medico> tipoMapDtoAEntidad = modelMapper.createTypeMap(MedicoDto.class, Medico.class);
        tipoMapDtoAEntidad.addMapping(MedicoDto::getPathFoto, (destino, v) -> destino.setUrlFoto((String) v));
        //Lectura
        TypeMap<Medico, MedicoDto> tipoMapEntidadADto = modelMapper.createTypeMap(Medico.class, MedicoDto.class);
        tipoMapEntidadADto.addMapping(Medico::getUrlFoto, (destino, v) -> destino.setPathFoto((String) v));

        return modelMapper;
    }
}
