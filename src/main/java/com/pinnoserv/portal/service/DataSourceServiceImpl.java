package com.pinnoserv.portal.service;

import com.pinnoserv.portal.custommodels.apiresponsedto.CreateUpdateDeleteResponseDto;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceById;
import com.pinnoserv.portal.custommodels.apiresponsedto.DataSourceGetAll;
import com.pinnoserv.portal.entity.DataSource;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.DataSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.pinnoserv.portal.custommodels.responseutils.ResponseUtil.*;

@Slf4j
@Service
public class DataSourceServiceImpl implements DataSourceService{
    @Autowired
    DataSourceRepository dataSourceRepository;
    @Override
    public DataSourceById findById(DataSource dataSource) {

        DataSource dataSourceResponse = null;
        try {
            Long id = dataSource.getId();
            if(dataSourceRepository.existsById(id)) {
                dataSourceResponse = dataSourceRepository.findById(id).get();
                DataSourceById dataSourceById = DataSourceById.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .dataSource(dataSourceResponse)
                        .build();
                return dataSourceById;
            }
            if(!dataSourceRepository.existsById(id)){
                dataSourceRepository.deleteById(id);
                DataSourceById dataSourceById = DataSourceById.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(DATA_SOURCE_NOT_EXIST)
                        .dataSource(null)
                        .build();
                return dataSourceById;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        DataSourceById dataSourceById = DataSourceById.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(DATA_SOURCE_NOT_EXIST)
                .dataSource(null)
                .build();
        return dataSourceById;
    }

    @Override
    public DataSourceGetAll findAll() {
        List<DataSource> listDatasource = null;
        try {
            listDatasource = dataSourceRepository.findAll();
            if(listDatasource != null){
                DataSourceGetAll dataSourceGetAll = DataSourceGetAll.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .dataSources(listDatasource)
                        .build();
                return dataSourceGetAll;
            }
        } catch (Exception e) {
        }
        DataSourceGetAll dataSourceGetAll = DataSourceGetAll.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(DATA_SOURCE_NOT_EXIST)
                .dataSources(null)
                .build();
        return dataSourceGetAll;
    }

    @Override
    public CreateUpdateDeleteResponseDto createDataSource(DataSource dataSource) {
        try {
            log.info("Begin Create Datasource Service");
            Long id = dataSource.getId();
            if(dataSourceRepository.existsById(id)) {
                DataSource createDatasource = DataSource.builder()
                        .name(dataSource.getName())
                        .dataSourceUrl(dataSource.getDataSourceUrl())
                        .dateCreated(LocalDateTime.now())
                        .inTrash("No")
                        .excelUrl(dataSource.getExcelUrl())
                        .dataSourceType(dataSource.getDataSourceType())
                        .dataUsage(dataSource.getDataUsage())
                        .status(dataSource.getStatus())
                        .action(dataSource.getAction())
                        .excelPath(dataSource.getExcelPath())
                        .expiry(dataSource.getExpiry())
                        .kycId(dataSource.getKycId())
                        .maxApprovals(dataSource.getMaxApprovals())
                        .approvalStatus(dataSource.getApprovalStatus())
                        .approvalLevel(dataSource.getApprovalLevel())
                        .updateCycle(dataSource.getUpdateCycle())
                        .scoringDataSize(dataSource.getScoringDataSize())
                        .organisationIdFk(dataSource.getOrganisationIdFk())
                        .build();
                dataSourceRepository.save(createDatasource);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(DATA_SOURCE_CREATED)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(DATA_SOURCE_NOT_CREATED)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto updataDataSource(DataSource dataSource) {
        DataSource updateDataSource = null;
        try {

            Long id = dataSource.getId();
            if (dataSourceRepository.existsById(id)) {

                DataSource dbDataSource = dataSourceRepository.findById(id).get();

                String name = dataSource.getName();
                String dataSourceUrl = dataSource.getDataSourceUrl();
                String excelUrl = dataSource.getExcelUrl();
                String dataSourceType = dataSource.getDataSourceType();
                String dataUsage = dataSource.getDataUsage();
                int status = dataSource.getStatus();
                String action = dataSource.getAction();
                String excelPath = dataSource.getExcelPath();
                String expiry = dataSource.getExpiry();
                int kycId = dataSource.getKycId();
                int maxApprovals = dataSource.getMaxApprovals();
                int approvalStatus = dataSource.getApprovalStatus();
                int approvalLevel = dataSource.getApprovalLevel();
                int updateCycle = dataSource.getUpdateCycle();
                int scoringDataSize = dataSource.getScoringDataSize();



                if (!name.isEmpty() && !name.equalsIgnoreCase(dbDataSource.getName())) {
                    dbDataSource.setName(name);
                }
                if (!dataSourceUrl.isEmpty() && !dataSourceUrl.equalsIgnoreCase(dbDataSource.getDataSourceType())) {
                    dbDataSource.setName(dataSourceUrl);
                }
                if (!excelUrl.isEmpty() && !excelUrl.equalsIgnoreCase(dbDataSource.getExcelUrl())) {
                    dbDataSource.setExcelUrl(excelUrl);
                }
                if (!dataSourceType.isEmpty() && !dataSourceType.equalsIgnoreCase(dbDataSource.getDataSourceType())){
                    dbDataSource.setExcelUrl(dataSourceType);
                }
                if (!excelPath.isEmpty() && !excelPath.equalsIgnoreCase(dbDataSource.getExcelPath())){
                    dbDataSource.setExcelPath(excelPath);
                }
                if (!expiry.isEmpty() && !expiry.equalsIgnoreCase(dbDataSource.getExpiry())){
                    dbDataSource.setExpiry(expiry);
                }
                if (!dataUsage.isEmpty() && !dataUsage.equalsIgnoreCase(dbDataSource.getDataUsage())){
                    dbDataSource.setDataUsage(dataUsage);
                }
                if (status != 0 && status != dbDataSource.getStatus()){
                    dbDataSource.setStatus(status);
                }
                if (!action.isEmpty() && !action.equalsIgnoreCase(dbDataSource.getAction())){
                    dbDataSource.setAction(action);
                }
                if (kycId != 0 && kycId != dbDataSource.getKycId()){
                    dbDataSource.setKycId(kycId);
                }
                if (maxApprovals != 0 && maxApprovals != dbDataSource.getMaxApprovals()){
                    dbDataSource.setMaxApprovals(maxApprovals);
                }
                if (approvalStatus != 0 && approvalStatus != dbDataSource.getApprovalStatus()){
                    dbDataSource.setApprovalStatus(approvalStatus);
                }
                if (approvalLevel != 0 && approvalLevel != dbDataSource.getApprovalLevel()){
                    dbDataSource.setApprovalLevel(approvalLevel);
                }
                if (updateCycle != 0 && updateCycle != dbDataSource.getUpdateCycle()){
                    dbDataSource.setUpdateCycle(updateCycle);
                }
                if (scoringDataSize != 0 && scoringDataSize != dbDataSource.getScoringDataSize()){
                    dbDataSource.setScoringDataSize(scoringDataSize);
                }

                updateDataSource = dataSourceRepository.save(dbDataSource);

                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(DATA_SOURCE_UPDATED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;

            }
            if(!dataSourceRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(DATA_SOURCE_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(SUCCESS_RESPONSE)
                .ResponseMessage(DATA_SOURCE_UPDATED_SUCCESSFULLY)
                .build();
        return createUpdateDeleteResponseDto;
    }

    @Override
    public CreateUpdateDeleteResponseDto deleteDataSource(DataSource dataSource) {
        try{
            Long id = dataSource.getId();
            if(dataSourceRepository.existsById(id)){
            dataSourceRepository.deleteById(id);
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(SUCCESS_RESPONSE)
                        .ResponseMessage(DATA_SOURCE_DELETED_SUCCESSFULLY)
                        .build();
                return createUpdateDeleteResponseDto;
            }
            if(!dataSourceRepository.existsById(id)){
                CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                        .ResponseCode(UNSUCCESS_RESPONSE)
                        .ResponseMessage(DATA_SOURCE_NOT_EXIST)
                        .build();
                return createUpdateDeleteResponseDto;
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        CreateUpdateDeleteResponseDto createUpdateDeleteResponseDto = CreateUpdateDeleteResponseDto.builder()
                .ResponseCode(UNSUCCESS_RESPONSE)
                .ResponseMessage(DATA_SOURCE_NOT_DELETED)
                .build();
        return createUpdateDeleteResponseDto;

    }
}
