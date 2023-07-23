package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.ApiResponse;
import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProgramById;
import com.pinnoserv.portal.custommodels.apiresponsedto.ProgramGetAll;
import com.pinnoserv.portal.entity.Program;
import com.pinnoserv.portal.repositories.ProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Service
@Slf4j
public class ProgamServiceImpl implements ProgramService{
    ApiResponse apiResponse = new ApiResponse();
    @Autowired
    ProgramRepository programRepository;

    @Override
    public ApiResponse createProgram(Program program) {
        try{
            Long id = program.getId();
            if(!programRepository.existsById(id)){
                Program createProgram = Program.builder()
                        .createdBy(program.getCreatedBy())
                        .dataSourceIdFk(program.getDataSourceIdFk())
                        .dateCreated(LocalDateTime.now())
                        .description(program.getDescription())
                        .inTrash("No")
                        .name(program.getName())
                        .organisationIdFk(program.getOrganisationIdFk())
                        .primaryIdentityType(program.getPrimaryIdentityType())
                        .status(program.getStatus())
                        .dataSource(program.getDataSource())
                        .organisation(program.getOrganisation())
                        .build();
                programRepository.save(createProgram);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_CREATED);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(programRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_EXISTS);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(PROGRAM_EXISTS);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse getById(Program program) {
        Program idProgram =null;
        try{
            Long id = program.getId();
            if(programRepository.existsById(id)) {
                idProgram = programRepository.findById(id).get();
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_FETCHED);
                apiResponse.setEntity(idProgram);
                return apiResponse;
            }
            if(!programRepository.existsById(id)) {
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
        apiResponse.setResponseDescription(UNCAUGHT_ERROR);
        apiResponse.setEntity(null);
        return apiResponse;
    }

    @Override
    public ApiResponse getAll() {
        List<Program> allPrograms = null;
        try{
            allPrograms = programRepository.findAll();
            if(allPrograms != null){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_ALL_FETCHED);
                apiResponse.setEntity(allPrograms);
                return apiResponse;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse updateById(Program program) {
        try{
            Long id = program.getId();
            if(programRepository.existsById(id)){
                Program updateProgram = programRepository.findById(id).get();
                int dataSourceIdFk = program.getDataSourceIdFk();
                String description = program.getDescription();
                String name = program.getName();
                int organisationIdFk = program.getOrganisationIdFk();
                String primaryIdentityType = program.getPrimaryIdentityType();
                int status = program.getStatus();
                String dataSource = program.getDataSource();
                String organisation = program.getOrganisation();

                if (!description.isEmpty() && !description.equalsIgnoreCase(updateProgram.getDescription())){
                    updateProgram.setDescription(description);
                }
                if (!name.isEmpty() && !name.equalsIgnoreCase(updateProgram.getName())){
                    updateProgram.setName(name);
                }
                if (!primaryIdentityType.isEmpty() && !primaryIdentityType.equalsIgnoreCase(updateProgram.getPrimaryIdentityType())){
                    updateProgram.setPrimaryIdentityType(primaryIdentityType);
                }
                if (!dataSource.isEmpty() && !dataSource.equalsIgnoreCase(updateProgram.getDataSource())){
                    updateProgram.setDataSource(dataSource);
                }
                if (!organisation.isEmpty() && !organisation.equalsIgnoreCase(updateProgram.getOrganisation())){
                    updateProgram.setOrganisation(organisation);
                }
                if (status != 0 && status != updateProgram.getStatus()){
                    updateProgram.setStatus(status);
                }
                if (dataSourceIdFk != 0 && dataSourceIdFk != updateProgram.getStatus()){
                    updateProgram.setDataSourceIdFk(dataSourceIdFk);
                }
                if (organisationIdFk != 0 && organisationIdFk != updateProgram.getOrganisationIdFk()){
                    updateProgram.setOrganisationIdFk(organisationIdFk);
                }
                programRepository.save(updateProgram);
                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_UPDATED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!programRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
        }

    @Override
    public ApiResponse deleteById(Program program) {
        try{
            Long id = program.getId();
            if(programRepository.existsById(id)){
                programRepository.deleteById(id);

                apiResponse.setResponseCode(SUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_DELETED_SUCCESSFULLY);
                apiResponse.setEntity(null);
                return apiResponse;
            }
            if(!programRepository.existsById(id)){
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(PROGRAM_NOT_EXIST);
                apiResponse.setEntity(null);
                return apiResponse;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
                apiResponse.setResponseCode(UNSUCCESS_RESPONSE);
                apiResponse.setResponseDescription(UNCAUGHT_ERROR);
                apiResponse.setEntity(null);
                return apiResponse;
    }
}
