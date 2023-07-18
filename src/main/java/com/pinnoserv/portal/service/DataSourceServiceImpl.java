package com.pinnoserv.portal.service;

import com.pinnoserv.portal.entity.DataSource;
import com.pinnoserv.portal.entity.Organisation;
import com.pinnoserv.portal.repositories.DataSourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
public class DataSourceServiceImpl implements DataSourceService{
    @Autowired
    DataSourceRepository dataSourceRepository;
    @Override
    public DataSource findById(DataSource dataSource) {

        DataSource dataSourceResponse = null;
        try {
            Long id = dataSource.getId();
            dataSourceResponse = dataSourceRepository.findById(id).get();
            log.info("Db datasource {}",dataSourceResponse);
        } catch (Exception e) {

        }
        return dataSourceResponse;
    }

    @Override
    public List<DataSource> findAll() {
        List<DataSource> listDatasource = null;
        try {
            listDatasource = dataSourceRepository.findAll();
        } catch (Exception e) {
        }
        return listDatasource;
    }

    @Override
    public void createDataSource(DataSource dataSource) {
        try {
            log.info("Begin Create Datasource Service");
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
        }catch (Exception e){
        }
    }

    @Override
    public DataSource updataDataSource(DataSource dataSource) {
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

            }
        } catch (Exception e) {

        }
        return updateDataSource;
    }

    @Override
    public void deleteDataSource(int id) {

    }
}
