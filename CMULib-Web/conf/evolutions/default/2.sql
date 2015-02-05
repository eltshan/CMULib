# --- Sample dataset

# --- !Ups
insert into computer (id,name,lastconnection,ipaddress,portnum) values (  1,'node1','120','192.168.1.2',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values (  2,'node2','78','192.168.4.2',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values (  3,'node3','2','192.168.1.6',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values (  4,'node4','64','192.168.1.4',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values (  5,'node5','52','192.168.1.8',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values (  6,'node6','0','192.168.10.2',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values (  8,'node8','0','192.168.9.3',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 10,'node10','10','192.168.8.9',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 11,'node11','21','192.168.5.2',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 15,'node15','21','192.168.1.10',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 16,'node16','12','192.168.1.9',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 17,'node17','65','192.168.5.12',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 20,'node20','42','192.168.9.11',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 25,'node25','11','192.168.1.37',8000);
insert into computer (id,name,lastconnection,ipaddress,portnum) values ( 27,'node27','2','192.168.1.40',8000);
# --- !Downs

delete from computer;
