insert into admin_tbl(tbl_nm, dspl_nm, short_desc, view_ind, view_nm, 
lang_ind, lang_col_nm, sort_ind)
values('fabric','Fabric','Fabric short description','N',null,'Y','lang_cd','Y');
commit;


insert into admin_col(tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, 
sort_ind, sort_ord, sort_dir, srch_ind, key_ind, 
meta_ind, meta_type, render_type, render_params)
values ('fabric','fabric_cd','Fabric Code',1,'char',
'N','','','Y','Y',
'N','','text','len=5,css=small'
);
insert into admin_col(tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, 
sort_ind, sort_ord, sort_dir, srch_ind, key_ind, 
meta_ind, meta_type, render_type, render_params)
values ('fabric','fabric_nm','Fabric Name',2,'char',
'Y','1','asc','Y','N',
'N','','text','len=100,css=large'
);
insert into admin_col(tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, 
sort_ind, sort_ord, sort_dir, srch_ind, key_ind, 
meta_ind, meta_type, render_type, render_params)
values ('fabric','fabric_desc','Fabric Description',3,'char',
'N','','','N','N',
'N','','textarea','len=255,html=true'
);
commit;