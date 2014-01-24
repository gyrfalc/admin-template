SET DEFINE OFF;

Insert into ADMIN_TBL_TYPE
   (TBL_TYPE, DESCRIPTION)
 Values
   ('edit', 'editable (table)');
Insert into ADMIN_TBL_TYPE
   (TBL_TYPE, DESCRIPTION)
 Values
   ('view', 'read only (table or view)');
Insert into ADMIN_TBL_TYPE
   (TBL_TYPE, DESCRIPTION)
 Values
   ('meta', 'meta table (admin tool)');
COMMIT;

Insert into ADMIN_DATA_TYPE
   (DATA_TYPE, DESCRIPTION)
 Values
   ('char', 'Character');
Insert into ADMIN_DATA_TYPE
   (DATA_TYPE, DESCRIPTION)
 Values
   ('date', 'Date');
Insert into ADMIN_DATA_TYPE
   (DATA_TYPE, DESCRIPTION)
 Values
   ('int', 'Integer');
Insert into ADMIN_DATA_TYPE
   (DATA_TYPE, DESCRIPTION)
 Values
   ('dbl', 'Decimal');
COMMIT;

Insert into ADMIN_META_TYPE
   (META_TYPE, DESCRIPTION)
 Values
   ('lang', 'language');
Insert into ADMIN_META_TYPE
   (META_TYPE, DESCRIPTION)
 Values
   ('updusr', 'update user id');
Insert into ADMIN_META_TYPE
   (META_TYPE, DESCRIPTION)
 Values
   ('upddt', 'update date');
Insert into ADMIN_META_TYPE
   (META_TYPE, DESCRIPTION)
 Values
   ('insusr', 'insert user id');
Insert into ADMIN_META_TYPE
   (META_TYPE, DESCRIPTION)
 Values
   ('insdt', 'insert date');
COMMIT;

Insert into ADMIN_RENDER_TYPE
   (RENDER_TYPE, DESCRIPTION)
 Values
   ('hidden', 'hidden field');
Insert into ADMIN_RENDER_TYPE
   (RENDER_TYPE, DESCRIPTION)
 Values
   ('text', 'text input field');
Insert into ADMIN_RENDER_TYPE
   (RENDER_TYPE, DESCRIPTION)
 Values
   ('textarea', 'textarea field');
Insert into ADMIN_RENDER_TYPE
   (RENDER_TYPE, DESCRIPTION)
 Values
   ('list', 'selection list');
COMMIT;

Insert into ADMIN_NOTICE
   (NOTE_ID, NOTE_TYPE, NOTE_MSG, NOTE_USR, NOTE_DT)
 Values
   (1, 'INFO', 'Example informational notification', 0, TO_DATE('01/16/2014 15:10:57', 'MM/DD/YYYY HH24:MI:SS'));
Insert into ADMIN_NOTICE
   (NOTE_ID, NOTE_TYPE, NOTE_MSG, NOTE_USR, NOTE_DT)
 Values
   (2, 'WARN', 'Example warning message.', 0, TO_DATE('01/16/2014 15:10:57', 'MM/DD/YYYY HH24:MI:SS'));
Insert into ADMIN_NOTICE
   (NOTE_ID, NOTE_TYPE, NOTE_MSG, NOTE_USR, NOTE_DT)
 Values
   (3, 'ERROR', 'Example error message', 0, TO_DATE('01/16/2014 15:10:57', 'MM/DD/YYYY HH24:MI:SS'));
COMMIT;

Insert into ADMIN_TBL
   (TBL_NM, TBL_TYPE, DSPL_NM, URL_NM, SHORT_DESC, 
    VIEW_IND, VIEW_NM, LANG_IND, SORT_IND, LANG_COL_NM, 
    SURROGATE_KEY_NM, INSTR_ADD, INSTR_EDIT, INSTR_DEL)
 Values
   ('admin_col', 'meta', 'Admin Column Definitions', 'admincol', 'Column definitions for automatic data administration.', 
    'Y', 'vw_admin_col', 'N', 'Y', NULL, 
    'id', '<span class="warning">Warning!</span> Modifying column meta-data will affect the Admin Console functionality.', '<span class="warning">Warning!</span> Modifying column meta-data will affect the Admin Console functionality.  It is safe to updated column descriptions, but know what you are doing before attempting to update any other field.', 'Warning!  Deleting column meta-data will affect the Admin Console functionality.  Make sure you know what you are doing.');
Insert into ADMIN_TBL
   (TBL_NM, TBL_TYPE, DSPL_NM, URL_NM, SHORT_DESC, 
    VIEW_IND, VIEW_NM, LANG_IND, SORT_IND, LANG_COL_NM, 
    SURROGATE_KEY_NM, INSTR_ADD, INSTR_EDIT, INSTR_DEL)
 Values
   ('admin_tbl', 'meta', 'Admin Table Definitions', 'admintbl', 'Table definitions for automatic data administration.', 
    'N', NULL, 'N', 'Y', NULL, 
    'tbl_nm', NULL, NULL, NULL);
Insert into ADMIN_TBL
   (TBL_NM, TBL_TYPE, DSPL_NM, URL_NM, SHORT_DESC, 
    VIEW_IND, VIEW_NM, LANG_IND, SORT_IND, LANG_COL_NM, 
    SURROGATE_KEY_NM, INSTR_ADD, INSTR_EDIT, INSTR_DEL)
 Values
   ('admin_lst', 'meta', 'Admin Lists', 'adminlst', 'Lists are used by the admin tool to present users with select lists for data entry. Give each list a name, and map it to a database view.  Lists are assigned in the "Render Type" and "Render Params" fields of the given column.  See existing examples.', 
    'N', NULL, 'N', 'Y', NULL, 
    'lst_nm', 'When creating a list, make sure your database view has these fields: id, name, and optional lang_cd.', 'When creating a list, make sure your database view has these fields: id, name, and optional lang_cd.', '');
COMMIT;


Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'tbl_nm', 'Table Name', 0, 'char', 
    50, 'Y', 1, 'asc', 'Y', 
    'Y', 'Y', 'N', NULL, 'list', 
    'list=admin_tbl', 'Parent table for this column.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'col_nm', 'Column Name', 1, 'char', 
    50, 'Y', 3, 'asc', 'Y', 
    'Y', 'Y', 'N', NULL, 'text', 
    NULL, 'Column name as defined in the database.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'dspl_nm', 'Display Name', 2, 'char', 
    100, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    'class=large', 'Column name as displayed to the user in the ADMIN TOOL.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'dspl_ord', 'Display Order', 3, 'int', 
    3, 'Y', 2, 'asc', 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    'class=small', 'Column order as displayed to the user in the ADMIN TOOL.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'data_type', 'Data Type', 4, 'char', 
    25, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=admin_data_type', 'Column data type as aliased in the ADMIN TOOL.  Does not have to match DB.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'max_len', 'Maximum Length', 5, 'int', 
    22, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    'class=small', 'Maximum field length - will not allow users to enter data exceeding this value.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'sort_ind', 'Sort on this Field?', 8, 'char', 
    1, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'Controls record sorting in the ADMIN TOOL.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'sort_ord', 'Sort Order', 9, 'char', 
    2, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'text', 
    'class=small', 'Relative position of the column in the order by clause.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'sort_dir', 'Sort Direction', 10, 'char', 
    5, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=sort', NULL, 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'dspl_tbl_ind', 'Display on Index Table?', 11, 'char', 
    1, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'Columns marked here will show up on the index page for the table.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'key_ind', 'Key Field?', 6, 'char', 
    1, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'Key fields uniquely identify the record. <span class="warning">Important!</span> DO NOT MARK LANGUAGE as a key field, even if it is part of the database primary key.  Language is treated as meta-data by the admin tool.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'srch_ind', 'Search on this Field?', 12, 'char', 
    1, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'Fields that are searchable will appear on the Search screen.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'meta_ind', 'Meta-data Field', 13, 'char', 
    1, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'Meta-data are data about the record: last update date, modified by user, etc.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'meta_type', 'Meta-data Type', 14, 'char', 
    25, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=admin_meta_type', 'Identify the type of meta-data stored in this column.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'render_type', 'Render Type', 15, 'char', 
    25, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=admin_render_type', 'HTML rendering type for this field.  Works in partnership with Render Params.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'render_params', 'Render Params', 16, 'char', 
    255, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'textarea', 
    NULL, 'See Admin Builder documentation for appropriate use of render params.  To apply a style: style=font-weight:bold (no quotes), to apply a style class: class=xyz (no quotes); to use html editor: html=true; to specify a list:  list=list_name.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'col_desc', 'Column Description', 99, 'char', 
    255, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'textarea', 
    'html=true', 'Provide short help text or meaningful column description for the user.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_col', 'req_ind', 'Required Field?', 7, 'char', 
    1, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', '<span class="warning">Important!</span> Only mark fields that are required entry BY THE USER.  The system automatically handles meta data fields.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'tbl_nm', 'Table Name', 1, 'char', 
    50, 'Y', 1, 'asc', 'Y', 
    'Y', 'Y', 'N', NULL, 'text', 
    NULL, 'Table name as defined in the database.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'tbl_type', 'Table Type', 2, 'char', 
    10, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=admin_tbl_type', 'edit = table is editable.  view = table (or view) is read only (for query only).   meta = table is used by the admin tool itself.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'dspl_nm', 'Display Name', 3, 'char', 
    100, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    'class=large', 'Table name as displayed to the admin user.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'url_nm', 'URL Name', 4, 'char', 
    30, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    NULL, 'How this table should appear in the admin tool URL. Use lower case, do not use spaces, do not use underscores.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'short_desc', 'Short Description', 11, 'char', 
    500, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'textarea', 
    'html=true', 'Short table description to display to the user on the index page.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'view_ind', 'Use Surrogate View?', 5, 'char', 
    1, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'If your table has more than one primary key (excluding language), you MUST define a companion view and create a surrogate key in that view.  See surrogate key field name.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'view_nm', 'Surrogate View Name', 6, 'char', 
    50, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    NULL, 'The name of the surrogate view, if used.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'lang_ind', 'Language Enabled?', 9, 'char', 
    1, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'Choose "Yes" if this table stores records in multiple languages.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'sort_ind', 'Sort the Rows?', 8, 'char', 
    1, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'list', 
    'list=yes_no', 'If you choose yes, you must identify one or more sortable columns in the ADMIN_COL table.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'lang_col_nm', 'Language Column', 10, 'char', 
    30, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    NULL, 'Name of the language column as defined in the database.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'surrogate_key_nm', 'Surrogate or Primary Key Name', 7, 'char', 
    30, 'N', NULL, NULL, 'Y', 
    'N', 'Y', 'N', NULL, 'text', 
    NULL, 'If the table has a single primary key, enter the name of the key field.  If the table has multiple keys, you must use a view and create a surrogate key.  Enter the name of the surrogate key field from the view.', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'instr_add', 'Insert Instructions', 12, 'char', 
    1000, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'textarea', 
    'html=true', 'Instructions to display on the screen when the user is adding a new record.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'instr_edit', 'Edit Instructions', 13, 'char', 
    1000, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'textarea', 
    'html=true', 'Instructions to display to the user when editing an existing record.', 'N');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, META_TYPE, RENDER_TYPE, 
    RENDER_PARAMS, COL_DESC, REQ_IND)
 Values
   ('admin_tbl', 'instr_del', 'Delete Instructions', 14, 'char', 
    255, 'N', NULL, NULL, 'N', 
    'N', 'Y', 'N', NULL, 'textarea', 
    'html=true', 'Warning or other instructions to provide the user when they delete a record.', 'N');
COMMIT;
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, DSPL_TBL_IND, KEY_IND, SRCH_IND, 
    META_IND, RENDER_TYPE, COL_DESC, REQ_IND)
 Values
   ('admin_lst', 'lang_ind', 'Language Enabled?', 3, 'char', 
    1, 'N', 'Y', 'N', 'Y', 
    'N', 'text', 'Does this list require a language parameter?', 'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, SORT_ORD, SORT_DIR, DSPL_TBL_IND, 
    KEY_IND, SRCH_IND, META_IND, RENDER_TYPE, COL_DESC, 
    REQ_IND)
 Values
   ('admin_lst', 'lst_nm', 'List Name', 1, 'char', 
    50, 'Y', 1, 'asc', 'Y', 
    'Y', 'Y', 'N', 'text', 'This is the name of the list as used by the admin tool in the "Render Params" field of any given column.  See render params documentation.', 
    'Y');
Insert into ADMIN_COL
   (TBL_NM, COL_NM, DSPL_NM, DSPL_ORD, DATA_TYPE, 
    MAX_LEN, SORT_IND, DSPL_TBL_IND, KEY_IND, SRCH_IND, 
    META_IND, RENDER_TYPE, COL_DESC, REQ_IND)
 Values
   ('admin_lst', 'vw_nm', 'Database View Name', 2, 'char', 
    50, 'N', 'Y', 'N', 'Y', 
    'N', 'text', 'Lists must be rendered as database views with the following columns:  id, name, and optional lang_cd', 'Y');
COMMIT;



INSERT INTO ADMIN_TBL (
   TBL_NM, 
   TBL_TYPE, 
   DSPL_NM, 
   URL_NM, 
   SHORT_DESC, 
   VIEW_IND, 
   VIEW_NM, 
   LANG_IND, 
   SORT_IND, 
   LANG_COL_NM, 
   SURROGATE_KEY_NM, 
   INSTR_ADD, 
   INSTR_EDIT, 
   INSTR_DEL) 
select lower(t.table_name), 
    'edit', 
    replace(t.table_name, '_', ' '),
    lower(replace(t.table_name, '_', '')),
    'Add table description here...',
    'N',
    null,
    'N',
    'Y',
    null,
    lower(column_name),
    'Add or remove insert instructions here...',
    'Add or remove edit instructions here...',
    'Add or remove delete instructions here...' 
from user_tab_columns c, user_tables t
where t.table_name = c.table_name 
and column_id = 1
and t.table_name not in (select upper(tbl_nm) from admin_tbl)
and t.table_name not in (
	'ADMIN_COL','ADMIN_DATA_TYPE','ADMIN_LST','ADMIN_META_TYPE',
	'ADMIN_NOTICE','ADMIN_PARAMS','ADMIN_RENDER_TYPE',
	'ADMIN_TBL','ADMIN_TBL_TYPE'
)
order by t.table_name;
commit;
    
update admin_tbl set lang_ind = 'Y', lang_col_nm = 'lang_cd'
where tbl_nm in (
    select lower(table_name) 
    from user_tab_columns
    where column_name = 'LANG_CD'
);
commit;


INSERT INTO ADMIN_COL (
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
   REQ_IND) 
select lower(t.table_name),
    lower(column_name),
    replace(column_name, '_', ' '), -- remove underscores for display
    column_id, -- default: display order same as column order
    decode(data_type, 'VARCHAR2', 'char', 'NUMBER', 'int', 'DATE', 'date', 'char'),
    data_length,
    decode(column_id, 1, 'Y', 'N'),  -- default:  sort on first column
    decode(column_id, 1, 1, null),   
    decode(column_id, 1, 'asc', null),
    decode(trunc(column_id/6), 0, 'Y', 'N'), -- default: display first five columns
    decode(column_id, 1, 'Y', 'N'), --default: assume first column is key field
    decode(column_name, 'LANG_CD', 'N','MOD_BY', 'N', 'MOD_DT', 'N', 'Y'),
    decode(column_name, 'LANG_CD', 'Y','MOD_BY', 'Y', 'MOD_DT', 'Y', 'N'),
    decode(column_name, 'LANG_CD', 'lang','MOD_BY', 'updusr', 'MOD_DT', 'upddt', null),
    decode(trunc(data_length / 101), 0, 'text', 'textarea'),  -- display large fields as textarea
    null,
    'add or remove column description here...',
    decode(nullable, 'Y', 'N', 'Y') -- reverse of nullable
from user_tab_columns c, user_tables t
where t.table_name = c.table_name 
and t.table_name not in (select upper(tbl_nm) from admin_col)
and t.table_name not in (
	'ADMIN_COL','ADMIN_DATA_TYPE','ADMIN_LST','ADMIN_META_TYPE',
	'ADMIN_NOTICE','ADMIN_PARAMS','ADMIN_RENDER_TYPE',
	'ADMIN_TBL','ADMIN_TBL_TYPE'
)
order by t.table_name, column_id;
commit;
    

