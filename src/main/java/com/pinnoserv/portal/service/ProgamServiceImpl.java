package com.pinnoserv.portal.service;

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
    @Autowired
    ProgramRepository programRepository;

    @Override
    public CreateUpdateDeleteResponseDto createProgram(Program program) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(programRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_EXISTS)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(PROGRAM_EXISTS)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public ProgramById getById(Program program) {
        Program idProgram =null;
        try{
            Long id = program.getId();
            if(programRepository.existsById(id)) {
                idProgram = programRepository.findById(id).get();
                ProgramById programById = ProgramById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .program(idProgram)
                        .build();
                return programById;
            }
            if(!programRepository.existsById(id)) {
                ProgramById programById = ProgramById.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_NOT_EXIST)
                        .program(null)
                        .build();
                return programById;
            }
            }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        ProgramById programById = ProgramById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .program(null)
                .build();
        return programById;
    }

    @Override
    public ProgramGetAll getAll() {
        List<Program> allPrograms = null;
        try{
            allPrograms = programRepository.findAll();
            if(allPrograms != null){
                ProgramGetAll programGetAll = ProgramGetAll.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_NOT_EXIST)
                        .programs(null)
                        .build();
                return programGetAll;
            }
                ProgramGetAll programGetAll = ProgramGetAll.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .programs(allPrograms)
                        .build();
                return programGetAll;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CreateUpdateDeleteResponseDto updateById(Program program) {
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
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!programRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteById(Program program) {
        try{
            Long id = program.getId();
            if(programRepository.existsById(id)){
                programRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!programRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(PROGRAM_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .build();
        return createUpdateDeleteResponseDto;
    }
}
