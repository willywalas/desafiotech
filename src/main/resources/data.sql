CREATE TABLE tb_currency (
                      id          INTEGER PRIMARY KEY,
                      origin VARCHAR(64),
                      destinity VARCHAR(64),
                      exchange_rate   float);

insert into tb_currency (id,origin,destinity, exchange_rate)
values (1,'dolar','sol',4.02);
insert into tb_currency (id,origin,destinity, exchange_rate)
values (2,'sol','dolar',0.25);
insert into tb_currency (id,origin,destinity, exchange_rate)
values (3,'euro','dolar',1.14);
insert into tb_currency (id,origin,destinity, exchange_rate)
values (4,'dolar','euro',0.87);
insert into tb_currency (id,origin,destinity, exchange_rate)
values (5,'sol','euro',0.22);
insert into tb_currency (id,origin,destinity, exchange_rate)
values (6,'euro','sol',4.6);
insert into tb_currency (id,origin,destinity, exchange_rate)
values (7,'sol','yen',28.34);
insert into tb_currency (id,origin,destinity, exchange_rate)
values (8,'yen','sol',0.035);