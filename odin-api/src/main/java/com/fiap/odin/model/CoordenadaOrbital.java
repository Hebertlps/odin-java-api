package com.fiap.odin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordenadaOrbital {

    @Column(name = "VL_LATITUDE", nullable = false)
    private Double latitude;

    @Column(name = "VL_LONGITUDE", nullable = false)
    private Double longitude;

    @Column(name = "VL_ALTITUDE", nullable = false)
    private Double altitude;

    @Column(name = "VL_VELOCIDADE", nullable = false)
    private Double velocidade;
}
