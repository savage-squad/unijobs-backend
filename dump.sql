create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table produto (id_produto integer not null auto_increment, created_at datetime, updated_at datetime, ativo bit, descricao varchar(255), id_usuario integer, miniatura varchar(255), prazo integer, preco double precision, titulo varchar(255), id_tipo_produto integer, primary key (id_produto)) engine=InnoDB;
create table servicos (id_servico integer not null auto_increment, created_at datetime, updated_at datetime, ativo bit not null, descricao varchar(255), miniatura varchar(255), prazo integer, preco double precision, titulo varchar(255), id_tipo_servico integer not null, primary key (id_servico)) engine=InnoDB;
create table tipo_produto (id_tipo_produto integer not null auto_increment, descricao varchar(255), nome varchar(255), primary key (id_tipo_produto)) engine=InnoDB;
create table tipos_servico (id_tipo_servico integer not null auto_increment, descricao varchar(255), nome varchar(255), primary key (id_tipo_servico)) engine=InnoDB;
create table tipo_usuario (id integer not null auto_increment, nome varchar(255) not null, primary key (id)) engine=InnoDB;
create table usuario (id integer not null, celular varchar(255), email varchar(255), nome varchar(255) not null, ra varchar(255), senha varchar(255), tipo_usuario_id integer, primary key (id)) engine=InnoDB;
alter table produto add constraint FKfvtpnuf809q6o6n0eqmeb2o1o foreign key (id_tipo_produto) references tipo_produto (id_tipo_produto);
alter table servicos add constraint FKdjoludfon864bqw2epbvxvh3x foreign key (id_tipo_servico) references tipos_servico (id_tipo_servico);
alter table usuario add constraint FKe581tp719p3d7o5u2w9sre10b foreign key (tipo_usuario_id) references tipo_usuario (id);
