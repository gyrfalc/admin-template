CREATE TABLE ADMIN_COL
(
  TBL_NM         VARCHAR2(50 BYTE)              NOT NULL,
  COL_NM         VARCHAR2(50 BYTE)              NOT NULL,
  DSPL_NM        VARCHAR2(100 BYTE)             NOT NULL,
  DSPL_ORD       NUMBER(3)                      NOT NULL,
  DATA_TYPE      VARCHAR2(25 BYTE)              NOT NULL,
  MAX_LEN        NUMBER(4)                      NOT NULL,
  SORT_IND       VARCHAR2(1 BYTE),
  SORT_ORD       NUMBER(3),
  SORT_DIR       VARCHAR2(5 BYTE),
  DSPL_TBL_IND   VARCHAR2(1 BYTE),
  KEY_IND        VARCHAR2(1 BYTE),
  SRCH_IND       VARCHAR2(1 BYTE),
  META_IND       VARCHAR2(1 BYTE),
  META_TYPE      VARCHAR2(25 BYTE),
  RENDER_TYPE    VARCHAR2(25 BYTE)              NOT NULL,
  RENDER_PARAMS  VARCHAR2(255 BYTE),
  COL_DESC       VARCHAR2(255 BYTE),
  REQ_IND        VARCHAR2(1 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_DATA_TYPE
(
  DATA_TYPE    VARCHAR2(25 BYTE),
  DESCRIPTION  VARCHAR2(200 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_LST
(
  LST_NM    VARCHAR2(50 BYTE)                   NOT NULL,
  VW_NM     VARCHAR2(50 BYTE)                   NOT NULL,
  LANG_IND  VARCHAR2(1 BYTE)                    NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_META_TYPE
(
  META_TYPE    VARCHAR2(25 BYTE),
  DESCRIPTION  VARCHAR2(200 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_NOTICE
(
  NOTE_ID    NUMBER                             NOT NULL,
  NOTE_TYPE  VARCHAR2(25 BYTE)                  NOT NULL,
  NOTE_MSG   VARCHAR2(255 BYTE)                 NOT NULL,
  NOTE_USR   NUMBER                             DEFAULT 0                     NOT NULL,
  NOTE_DT    DATE                               DEFAULT SYSDATE               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_PARAMS
(
  PARAM_NM   VARCHAR2(25 BYTE)                  NOT NULL,
  PARAM_VAL  VARCHAR2(255 BYTE)                 NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_RENDER_TYPE
(
  RENDER_TYPE  VARCHAR2(25 BYTE),
  DESCRIPTION  VARCHAR2(200 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_TBL
(
  TBL_NM            VARCHAR2(50 BYTE)           NOT NULL,
  TBL_TYPE          VARCHAR2(10 BYTE)           NOT NULL,
  DSPL_NM           VARCHAR2(100 BYTE)          NOT NULL,
  URL_NM            VARCHAR2(30 BYTE)           NOT NULL,
  SHORT_DESC        VARCHAR2(500 BYTE)          NOT NULL,
  VIEW_IND          VARCHAR2(1 BYTE)            NOT NULL,
  VIEW_NM           VARCHAR2(50 BYTE),
  LANG_IND          VARCHAR2(1 BYTE),
  SORT_IND          VARCHAR2(1 BYTE),
  LANG_COL_NM       VARCHAR2(30 BYTE),
  SURROGATE_KEY_NM  VARCHAR2(30 BYTE)           NOT NULL,
  INSTR_ADD         VARCHAR2(1000 BYTE),
  INSTR_EDIT        VARCHAR2(1000 BYTE),
  INSTR_DEL         VARCHAR2(255 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE ADMIN_TBL_TYPE
(
  TBL_TYPE     VARCHAR2(10 BYTE),
  DESCRIPTION  VARCHAR2(200 BYTE)
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX UNDX_ADMIN_TBL ON ADMIN_TBL
(URL_NM)
LOGGING
NOPARALLEL;

alter table admin_lst add (
	primary key (lst_nm)
	enable validate);

ALTER TABLE ADMIN_COL ADD (
  PRIMARY KEY
  (TBL_NM, COL_NM)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_DATA_TYPE ADD (
  PRIMARY KEY
  (DATA_TYPE)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_META_TYPE ADD (
  PRIMARY KEY
  (META_TYPE)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_NOTICE ADD (
  PRIMARY KEY
  (NOTE_ID)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_PARAMS ADD (
  PRIMARY KEY
  (PARAM_NM)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_RENDER_TYPE ADD (
  PRIMARY KEY
  (RENDER_TYPE)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_TBL ADD (
  PRIMARY KEY
  (TBL_NM)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_TBL_TYPE ADD (
  PRIMARY KEY
  (TBL_TYPE)
  ENABLE VALIDATE);

ALTER TABLE ADMIN_COL ADD (
  CONSTRAINT FK_COL_DATA_TYPE 
  FOREIGN KEY (DATA_TYPE) 
  REFERENCES ADMIN_DATA_TYPE (DATA_TYPE)
  ENABLE VALIDATE,
  CONSTRAINT FK_COL_META_TYPE 
  FOREIGN KEY (META_TYPE) 
  REFERENCES ADMIN_META_TYPE (META_TYPE)
  ENABLE VALIDATE,
  CONSTRAINT FK_COL_RENDER_TYPE 
  FOREIGN KEY (RENDER_TYPE) 
  REFERENCES ADMIN_RENDER_TYPE (RENDER_TYPE)
  ENABLE VALIDATE,
  CONSTRAINT FK_COL_TBL_NM 
  FOREIGN KEY (TBL_NM) 
  REFERENCES ADMIN_TBL (TBL_NM)
  ON DELETE CASCADE
  ENABLE VALIDATE);

ALTER TABLE ADMIN_TBL ADD (
  CONSTRAINT FK_TBL_TYPE 
  FOREIGN KEY (TBL_TYPE) 
  REFERENCES ADMIN_TBL_TYPE (TBL_TYPE)
  ENABLE VALIDATE);

  /* Formatted on 1/23/2014 9:36:10 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW VW_ADMIN_COL
(
   ID,
   TBL_NM,
   COL_NM,
   DSPL_NM,
   DSPL_ORD,
   DATA_TYPE,
   MAX_LEN,
   SORT_IND,
   SORT_ORD,
   SORT_DIR,
   DSPL_TBL_IND,
   KEY_IND,
   SRCH_IND,
   META_IND,
   META_TYPE,
   RENDER_TYPE,
   RENDER_PARAMS,
   COL_DESC,
   REQ_IND
)
AS
   SELECT TBL_NM || ':' || COL_NM AS ID,
          TBL_NM,
          COL_NM,
          DSPL_NM,
          DSPL_ORD,
          DATA_TYPE,
          MAX_LEN,
          SORT_IND,
          SORT_ORD,
          SORT_DIR,
          DSPL_TBL_IND,
          KEY_IND,
          SRCH_IND,
          META_IND,
          META_TYPE,
          RENDER_TYPE,
          RENDER_PARAMS,
          COL_DESC,
          REQ_IND
     FROM ADMIN_COL;

  
  /* Formatted on 1/23/2014 9:22:11 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_ADMIN_DATA_TYPE
(
   ID,
   NAME
)
AS
     SELECT data_type AS id, description AS name
       FROM admin_data_type
   ORDER BY description;

   
/* Formatted on 1/23/2014 9:22:49 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_ADMIN_META_TYPE
(
   ID,
   NAME
)
AS
     SELECT meta_type AS id, description AS name
       FROM admin_meta_type
   ORDER BY description;

/* Formatted on 1/23/2014 9:23:13 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_ADMIN_RENDER_TYPE
(
   ID,
   NAME
)
AS
     SELECT render_type AS id, description AS name
       FROM admin_render_type
   ORDER BY description;

/* Formatted on 1/23/2014 9:24:06 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_ADMIN_TBL
(
   ID,
   NAME
)
AS
     SELECT tbl_nm AS id, tbl_nm AS name
       FROM admin_tbl
   ORDER BY tbl_nm;

/* Formatted on 1/23/2014 9:24:25 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_ADMIN_TBL_TYPE
(
   ID,
   NAME
)
AS
     SELECT tbl_type AS id, description AS name
       FROM admin_tbl_type
   ORDER BY description;
   
/* Formatted on 1/23/2014 9:25:57 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_SORT
(
   ID,
   NAME
)
AS
   SELECT 'asc' AS id, 'ascending' AS name FROM DUAL
   UNION
   SELECT 'desc', 'descending' FROM DUAL;

/* Formatted on 1/23/2014 9:26:28 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_STATUS
(
   ID,
   NAME
)
AS
   SELECT 'ACT' AS id, 'Active' AS name FROM DUAL
   UNION
   SELECT 'INACT', 'Inactive' FROM DUAL;

/* Formatted on 1/23/2014 9:26:52 AM (QP5 v5.185.11230.41888) */
CREATE OR REPLACE FORCE VIEW LST_YES_NO
(
   ID,
   NAME
)
AS
   SELECT 'Y' AS id, 'Yes' AS name FROM DUAL
   UNION
   SELECT 'N', 'No' FROM DUAL;
   

/* Formatted on 1/23/2014 9:24:59 AM (QP5 v5.185.11230.41888) */
/* ADD A BOGUS LANGUAGE TABLE IF THE DATABASE DOES NOT HAVE ONE */
/*

create table language(lang_cd varchar2(5) not null primary key, lang_desc varchar2(25) not null);
insert into language values ('en', 'English');
commit;

*/
CREATE OR REPLACE FORCE VIEW LST_LANGUAGE
(
   ID,
   NAME
)
AS
     SELECT lang_cd AS id, lang_desc AS name
       FROM language
   ORDER BY lang_desc;

   