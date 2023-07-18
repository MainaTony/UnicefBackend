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
        return null;
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

//    @Override
//    public DataSource updataDataSource(DataSource dataSource) {
//        DataSource updateDataSource = null;
//        try {
//
//            Long id = dataSource.getId();
//            Integer code = dataSource.getDatasourceCode();
//            log.info("Update Id : {}", code);
//
//            if (dataSourceRepository.existsById(code)) {
//
//                DataSource dbDataSource = dataSourceRepository.findById(id);
//
//                String orgName = organisation.getOrganisationName();
//                String organisationCode = organisation.getOrganisationCode();
//                int businessType = organisation.getBusinessType();
//                String organisationAddress = organisation.getOrganisationAddress();
//                String organisationPhone = organisation.getOrganisationPhone();
//                String organisationEmail = organisation.getOrganisationEmail();
//
//                log.info("My Update Data : {}", orgName);
//
//                if (!orgName.isEmpty() && !orgName.equalsIgnoreCase(dbOrganisation.getOrganisationName())) {
//                    dbOrganisation.setOrganisationName(orgName);
//                }
//                if (!organisationCode.isEmpty() && !organisationCode.equalsIgnoreCase(dbOrganisation.getOrganisationCode())){
//                    dbOrganisation.setOrganisationCode(organisationCode);
//                }
//                if (businessType != 0) {
//                    dbOrganisation.setBusinessType(businessType);
//                }
//                if (!organisationAddress.isEmpty() && !organisationAddress.equalsIgnoreCase(dbOrganisation.getOrganisationAddress())) {
//                    dbOrganisation.setOrganisationAddress(organisationAddress);
//                }
//                if (!organisationPhone.isEmpty() && !organisationPhone.equalsIgnoreCase(dbOrganisation.getOrganisationPhone())) {
//                    dbOrganisation.setOrganisationPhone(organisationPhone);
//                }
//                if (!organisationEmail.isEmpty() && !organisationEmail.equalsIgnoreCase(dbOrganisation.getOrganisationEmail())) {
//                    dbOrganisation.setOrganisationEmail(organisationEmail);
//                }
//                organisationRepository.save(dbOrganisation);
//            }
//        } catch (Exception e) {
//
//        }
//        return dbOrganisation;
//    }

    @Override
    public void deleteDataSource(int id) {

    }
}
