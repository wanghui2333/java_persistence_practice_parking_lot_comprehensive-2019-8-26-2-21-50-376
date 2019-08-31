DROP TABLE IF EXISTS employee ;


CREATE TABLE employee (
  parkingBoyID INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
) ;


DROP TABLE IF EXISTS parkingLot ;
CREATE TABLE parkingLot (
parkingLotID int(10) NOT NULL,
availablePositionCount int(3) NULL,
capacity int(3) NULL,
parkingBoyID int(3) NULL
);

insert into employee values(0,'tom',13);
insert into employee values(1,'cat',17);


insert into parkingLot values(0,13,10,0);
insert into parkingLot values(1,10,10,1);

