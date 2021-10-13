package com.example.studentstest.service;

import com.example.studentstest.dtos.FacultateDto;
import com.example.studentstest.entities.Facultate;

public interface FacultateService {
    Facultate saveFacultate(FacultateDto facultateDto);
}
