package com.example.studentstest.service.impl;

import com.example.studentstest.dtos.FacultateDto;
import com.example.studentstest.entities.Facultate;
import com.example.studentstest.repositories.FacultateRepository;
import com.example.studentstest.repositories.StudentRepository;
import com.example.studentstest.service.FacultateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultateServiceImpl implements FacultateService {

    private final ModelMapper modelMapper;
    private final FacultateRepository facultateRepository;


    @Override
    public Facultate saveFacultate(FacultateDto facultateDto) {
        Facultate facultate = modelMapper.map(facultateDto,Facultate.class);
        return facultateRepository.save(facultate);
    }
}
