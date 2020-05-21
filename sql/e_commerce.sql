CREATE TABLE usuarios (
	id_usuario integer not null,
	cpf character varying(15) not null,
	nome character varying(50) not null,
	email character varying(50) not null,
	password character varying(20) not null,
	tipo_usuario smallint not null,
	constraint key_usuario primary key (id_usuario)
)

CREATE TABLE enderecos (
	id_endereco integer not null,
	id_foreign integer not null,
	cep character varying(10) not null,
	rua character varying(50) not null,
	cidade character varying(20) not null,
	complemento character varying(50),
	numero character varying(25) not null,
	constraint key_endereco primary key (id_endereco)
)

CREATE TABLE senhagerente (
	id_senha serial,
	password character varying(10) not null,
	constraint key_passgerente primary key (id_senha)
)

CREATE TABLE produtos (
	id_produto integer not null,
	id_foreign_produto integer not null,
	preco double precision not null,
	situacao smallint not null,
	nome character varying(50) not null,
	categoria character varying(50) not null,
	descricao character varying(255),
	constraint key_produto primary key (id_produto)
)

alter table usuarios alter column id_usuario set default nextval('id_sequence'::regclass)
alter table enderecos alter column id_endereco set default nextval('id_sequence'::regclass)
alter table produtos alter column id_produto set default nextval('id_sequence'::regclass)
alter table enderecos add foreign key (id_foreign) references usuarios (id_usuario)
alter table produtos add foreign key (id_foreign_produto) references usuarios(id_usuario)