package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProgramById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProgramGetAll;
import com.pinnoserv.portal.entity.Program;

import java.util.List;

public interface ProgramService {
    ApiResponse createProgram(Program program);
    ApiResponse getById(Program program);
    ApiResponse getAll();
    ApiResponse updateById(Program program);
    ApiResponse deleteById(Program program);
}
