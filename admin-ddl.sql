drop table admin_params;
drop table admin_col;
drop table admin_tbl;

create table admin_tbl (
	tbl_nm varchar(50) not null,
	dspl_nm varchar(100) not null,
	short_desc varchar(500) not null,
	use_view varchar(1) not null,
	view_nm varchar(50),
	user_lang varchar(1),
	constraint pk_admin_tbl primary key (tbl_nm)
);

create table admin_col (
	tbl_nm varchar(50) not null,
	col_nm varchar(50) not null,
	dspl_nm varchar(100) not null,
	data_type varchar(25) not null,
	max_length integer,
	col_ord integer,
	sort_ord integer,
	sort_dir varchar(5),
	is_key varchar(1) not null,
	is_meta varchar(1) not null,
	meta_type varchar(25),
	is_list varchar(1) not null,
	list_view_nm varchar(50),
	constraint pk_admin_col primary key (tbl_nm, col_nm)
);

create table admin_params (
	param_nm varchar(25) not null,
	param_val varchar(255) not null
);
	