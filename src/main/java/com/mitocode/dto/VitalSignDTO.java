package com.mitocode.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VitalSignDTO {

    @EqualsAndHashCode.Include
    private Integer idVitalSign;

    @NotNull
    private PatientDTO patient;

    @NotNull
    private String temperature;
    
    @NotNull
    private String pulse;
    
    @NotNull
    private String rhythm;

    @NotNull
    private LocalDateTime vitalSignDate;

}
