CREATE TABLE ENTRY (
  ENTR_ID bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'The entry ID.',
  ENTR_CALC_TYPE varchar(45) NOT NULL COMMENT 'The calculation type for the entry.',
  ENTR_VALUE int(11) NOT NULL COMMENT 'The entry value.',
  ENTR_ITER int(11) NOT NULL COMMENT 'The number of iterations for the entry.',
  PRIMARY KEY (ENTR_ID)
);

CREATE TABLE RESULT (
  RES_ID bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'The result id.',
  ENTR_ID bigint(11) NOT NULL COMMENT 'The entry id.',
  RES_CALC_TYPE varchar(45) NOT NULL COMMENT 'The calculation type of the result.',
  RES_VALUE bigint(11) NOT NULL COMMENT 'The result value.',
  RES_TIME int(11) NOT NULL COMMENT 'The spent time of calculation in milliseconds.',
  RES_DATE datetime NOT NULL COMMENT 'The date of calculation.',
  PRIMARY KEY (RES_ID),
  KEY RESULT_FK_ENTRY_idx (ENTR_ID),
  CONSTRAINT RESULT_FK_ENTRY FOREIGN KEY (ENTR_ID) REFERENCES ENTRY (ENTR_ID) ON DELETE CASCADE ON UPDATE NO ACTION
);
