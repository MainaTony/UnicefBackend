package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProgramById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProgramGetAll;
import com.pinnoserv.portal.entity.Program;

import java.util.List;

public interface ProgramService {
    CreateUpdateDeleteResponseDto createProgram(Program program);
    ProgramById getById(Program program);
    ProgramGetAll getAll();
    CreateUpdateDeleteResponseDto updateById(Program program);
    CreateUpdateDeleteResponseDto deleteById(Program program);
}
