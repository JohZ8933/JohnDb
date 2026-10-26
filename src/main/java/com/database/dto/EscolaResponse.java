package com.database.dto;

import java.time.LocalTime;

public record EscolaResponse(Long id, LocalTime tempoComeco, boolean provaCompleta) {}
