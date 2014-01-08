drop table admin_params;
drop table admin_col;
drop table admin_tbl;
drop table admin_notice;

create table admin_tbl (
	tbl_nm varchar(50) not null,
	dspl_nm varchar(100) not null,
	short_desc varchar(500) not null,
	view_ind varchar(1) not null,
	view_nm varchar(50),
	lang_ind varchar(1),
	lang_col_nm varchar(30),
	sort_ind varchar(1),
	constraint pk_admin_tbl primary key (tbl_nm)
);

create table admin_col (
	tbl_nm varchar(50) not null,
	col_nm varchar(50) not null,
	dspl_nm varchar(100) not null,
	dspl_ord integer not null,
	data_type varchar(25) not null,
	sort_ind varchar(1),
	sort_ord integer,
	sort_dir varchar(5),
	srch_ind varchar(1),
	key_ind varchar(1),
	meta_ind varchar(1),
	meta_type varchar(25),
	render_type varchar(25),
	render_params varchar(255),
	constraint pk_admin_col primary key (tbl_nm, col_nm),
	constraint fg_admin_tbl foreign key (tbl_nm) references admin_tbl(tbl_nm)
);

create table admin_params (
	param_nm varchar(25) not null,
	param_val varchar(255) not null
);
	
CREATE TABLE admin_notice (
  note_id int(11) NOT NULL,
  note_type varchar(25) NOT NULL,
  note_msg varchar(255) NOT NULL,
  note_usr int(11) NOT NULL DEFAULT 0,
  note_dt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  constraint pk_admin_noticed PRIMARY KEY (note_id)
);