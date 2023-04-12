DROP VIEW data_source_view;

create view credit_scoring.DATA_SOURCE_VIEW as select
`DATA_SOURCE_ID`,
`ACTION`,
`APPROVAL_LEVEL`,
`APPROVAL_STATUS`,
data_source.CREATED_BY,
`DATA_SOURCE_TYPE`,
`DATA_SOURCE_URL`,
`DATA_USAGE`,
data_source.DATE_CREATED ,
`EXCEL_PATH`,
`EXCEL_URL`,
`EXPIRY` ,
data_source.INTRASH,
`KYC_ID`,
`MAX_APPROVALS`,
data_source.NAME,
data_source.ORGANISATION,
data_source.ORGANISATION_ID_FK,
`SCORING_DATA_SIZE`,
data_source.STATUS,
`UPDATE_CYCLE`
from data_source
JOIN program
on data_source.ORGANISATION = program.ORGANISATION
and data_source.ORGANISATION_ID_FK = program.ORGANISATION_ID_FK;