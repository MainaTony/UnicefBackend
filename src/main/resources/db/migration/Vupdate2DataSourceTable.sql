--DROP TABLE DATA_SOURCE;
--
--
--CREATE TABLE `DATA_SOURCE` (
--  `DATA_SOURCE_ID` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
--  `ACTION` varchar(255) DEFAULT NULL,
--  `APPROVAL_LEVEL` int DEFAULT NULL,
--  `APPROVAL_STATUS` int DEFAULT NULL,
--  `CREATED_BY` int DEFAULT NULL,
--  `DATA_SOURCE_TYPE` varchar(255) DEFAULT NULL,
--  `DATA_SOURCE_URL` varchar(255) DEFAULT NULL,
--  `DATA_USAGE` varchar(255) DEFAULT NULL,
--  `DATE_CREATED` datetime DEFAULT NULL,
--  `EXCEL_PATH` varchar(255) DEFAULT NULL,
--  `EXCEL_URL` varchar(255) DEFAULT NULL,
--  `EXPIRY` datetime DEFAULT NULL,
--  `INTRASH` varchar(255) DEFAULT NULL,
--  `KYC_ID` int DEFAULT NULL,
--  `MAX_APPROVALS`int DEFAULT NULL,
--  `NAME` varchar(255) DEFAULT NULL,
--  `ORGANISATION_ID_FK` int DEFAULT NULL,
--  `SCORING_DATA_SIZE` int DEFAULT NULL,
--  `STATUS` int DEFAULT NULL,
--  `UPDATE_CYCLE` int DEFAULT NULL,
--  `ORGANISATION` varchar(255) DEFAULT NULL,
--FOREIGN KEY (`ORGANISATION_ID_FK`) REFERENCES `organisation` (`ORGANISATION_ID`)
--) ENGINE=InnoDB ;
