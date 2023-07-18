package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Program;
import com.pinnoserv.portal.repositories.ProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProgamServiceImpl implements ProgramService{
    @Autowired
    ProgramRepository programRepository;

    @Override
    public Program createProgram(Program program) {
        return null;
    }

    @Override
    public Program getById(Program program) {
        return null;
    }

    @Override
    public List<Program> getAll() {
        return null;
    }

    @Override
    public void updateById(Program program) {

    }

    @Override
    public void deleteById(Program program) {

    }
}
