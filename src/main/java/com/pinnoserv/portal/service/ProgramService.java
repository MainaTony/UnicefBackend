package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Program;

import java.util.List;

public interface ProgramService {
    Program createProgram(Program program);
    Program getById(Program program);
    List<Program> getAll();
    void updateById(Program program);
    void deleteById(Program program);
}
