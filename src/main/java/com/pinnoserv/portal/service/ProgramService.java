package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Program;

import java.util.List;

public interface ProgramService {
    void createProgram(Program program);
    Program getById(Program program);
    List<Program> getAll();
    void updateById(Program program);
    void deleteById(Program program);
}
