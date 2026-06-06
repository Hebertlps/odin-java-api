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

    @Column(name = "VL_LATITUDE", nullable = false, precision = 9, scale = 6)
    private Double latitude;

    @Column(name = "VL_LONGITUDE", nullable = false, precision = 9, scale = 6)
    private Double longitude;

    @Column(name = "VL_ALTITUDE", nullable = false, precision = 10, scale = 2)
    private Double altitude;

    @Column(name = "VL_VELOCIDADE", nullable = false, precision = 10, scale = 2)
    private Double velocidade;
}
