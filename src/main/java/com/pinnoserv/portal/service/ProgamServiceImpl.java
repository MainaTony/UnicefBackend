package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.Program;
import com.pinnoserv.portal.repositories.ProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ProgamServiceImpl implements ProgramService{
    @Autowired
    ProgramRepository programRepository;

    @Override
    public void createProgram(Program program) {
        try{
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

        } catch (Exception e){

        }
    }

    @Override
    public Program getById(Program program) {
        Program idProgram =null;
        try{
            Long id = program.getId();
            if(programRepository.existsById(id))
             idProgram = programRepository.findById(id).get();
            }
        catch (Exception e){

        }
        return idProgram;
    }

    @Override
    public List<Program> getAll() {
        List<Program> allPrograms = null;
        try{
            allPrograms = programRepository.findAll();
        }
        catch (Exception e){

        }
        return allPrograms;
    }

    @Override
    public void updateById(Program program) {
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
            }
        }
        catch (Exception e){

        }

    }

    @Override
    public void deleteById(Program program) {
        try{
            Long id = program.getId();
            if(programRepository.existsById(id)){
                programRepository.deleteById(id);
            }
        } catch (Exception e){

        }

    }
}
