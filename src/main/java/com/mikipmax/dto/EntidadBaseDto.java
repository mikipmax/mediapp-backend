package com.mikipmax.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EntidadBaseDto {
    
    @EqualsAndHashCode.Include
    private Long id;
}
