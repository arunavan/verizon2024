create database bms;
use bms;
CREATE TABLE customer
   (
       custid VARCHAR(6),
       fname VARCHAR(30),
       mname VARCHAR(30),
       ltname VARCHAR(30),
       city VARCHAR(15),
       mobileno VARCHAR(10),
       occupation VARCHAR(10),
       dob DATE,
      CONSTRAINT customer_custid_pk PRIMARY KEY(custid)   
   );   


 CREATE TABLE branch
   (
    bid VARCHAR(6),
    bname VARCHAR(30),
    bcity VARCHAR(30),
    CONSTRAINT branch_bid_pk PRIMARY KEY(bid) 
   );



CREATE TABLE account
   (
      acnumber VARCHAR(6),
      custid  VARCHAR(6),
      bid VARCHAR(6),
      opening_balance INT(7),
      aod DATE,
      atype VARCHAR(10),
      astatus VARCHAR(10),
      CONSTRAINT account_acnumber_pk PRIMARY KEY(acnumber),
      CONSTRAINT account_custid_fk FOREIGN KEY(custid) REFERENCES customer(custid),
      CONSTRAINT account_bid_fk FOREIGN KEY(bid) REFERENCES branch(bid) 
    );



CREATE TABLE trandetails
    (   
     tnumber VARCHAR(6),
     acnumber VARCHAR(6),
     dot DATE,
     medium_of_transaction VARCHAR(20),
     transaction_type VARCHAR(20),
     transaction_amount INT(7),    
     CONSTRAINT trandetails_tnumber_pk PRIMARY KEY(tnumber),
     CONSTRAINT trandetails_acnumber_fk FOREIGN KEY(acnumber) REFERENCES account(acnumber)  
    );



CREATE TABLE loan
   (
   
    custid VARCHAR(6),
    bid VARCHAR(6),
    loan_amount INT(7),
    CONSTRAINT loan_customer_custid_bid_pk PRIMARY KEY(custid,bid),
    CONSTRAINT loan_custid_fk FOREIGN KEY(custid) REFERENCES  customer(custid),
    CONSTRAINT loan_bid_fk FOREIGN KEY(bid) REFERENCES  branch(bid)
   );


INSERT INTO customer VALUES('C00001','Ramesh','Chandra','Sharma','Delhi','9543198345','Service','1976-12-06');
INSERT INTO customer VALUES('C00002','Avinash','Sunder','Minha','Delhi','9876532109','Service','1974-10-16');
INSERT INTO customer VALUES('C00003','Rahul',null,'Rastogi','Delhi','9765178901','Student','1981-09-26');
INSERT INTO customer VALUES('C00004','Parul',null,'Gandhi','Delhi','9876532109','Housewife','1976-11-03');
INSERT INTO customer VALUES('C00005','Naveen','Chandra','Aedekar','Mumbai','8976523190','Service','1976-09-19');
INSERT INTO customer VALUES('C00006','Chitresh',null,'Barwe','Mumbai','7651298321','Student','1992-11-06');
INSERT INTO customer VALUES('C00007','Amit','Kumar','Borkar','Mumbai','9875189761','Student','1981-09-06');
INSERT INTO customer VALUES('C00008','Nisha',null,'Damle','Mumbai','7954198761','Service','1975-12-03');
INSERT INTO customer VALUES('C00009','Abhishek',null,'Dutta','Kolkata','9856198761','Service','1973-05-22');
INSERT INTO customer  VALUES('C00010','Shankar',null,'Nair','Chennai','8765489076','Service','1976-07-12');



INSERT INTO branch VALUES('B00001','Asaf ali road','Delhi');
INSERT INTO branch VALUES('B00002','New delhi main branch','Delhi');
INSERT INTO branch VALUES('B00003','Delhi cantt','Delhi');
INSERT INTO branch VALUES('B00004','Jasola','Delhi');
INSERT INTO branch VALUES('B00005','Mahim','Mumbai');
INSERT INTO branch VALUES('B00006','Vile parle','Mumbai');
INSERT INTO branch VALUES('B00007','Mandvi','Mumbai');
INSERT INTO branch VALUES('B00008','Jadavpur','Kolkata');
INSERT INTO branch VALUES('B00009','Kodambakkam','Chennai');



INSERT INTO account VALUES('A00001','C00001','B00001',1000,'2012-12-15','Saving','Active');
INSERT INTO account VALUES('A00002','C00002','B00001',1000,'2012-06-12','Saving','Active');
INSERT INTO account VALUES('A00003','C00003','B00002',1000,'2012-05-17','Saving','Active');
INSERT INTO account VALUES('A00004','C00002','B00005',1000,'2013-01-27','Saving','Active');
INSERT INTO account VALUES('A00005','C00006','B00006',1000,'2012-12-17','Saving','Active');
INSERT INTO account VALUES('A00006','C00007','B00007',1000,'2010-08-12','Saving','Suspended');
INSERT INTO account VALUES('A00007','C00007','B00001',1000,'2012-10-02','Saving','Active');
INSERT INTO account VALUES('A00008','C00001','B00003',1000,'2009-11-09','Saving','Terminated');
INSERT INTO account VALUES('A00009','C00003','B00007',1000,'2008-11-30','Saving','Terminated');
INSERT INTO account VALUES('A00010','C00004','B00002',1000,'2013-03-01','Saving','Active');


INSERT INTO trandetails VALUES('T00001','A00001','2013-01-01','Cheque','Deposit',2000);
INSERT INTO trandetails VALUES('T00002','A00001','2013-02-01','Cash','Withdrawal',1000);
INSERT INTO trandetails VALUES('T00003','A00002','2013-01-01','Cash','Deposit',2000);
INSERT INTO trandetails VALUES('T00004','A00002','2013-02-01','Cash','Deposit',3000);
INSERT INTO trandetails VALUES('T00005','A00007','2013-01-11','Cash','Deposit',7000);
INSERT INTO trandetails VALUES('T00006','A00007','2013-01-13','Cash','Deposit',9000);
INSERT INTO trandetails VALUES('T00007','A00001','2013-03-13','Cash','Deposit',4000);
INSERT INTO trandetails VALUES('T00008','A00001','2013-03-14','Cheque','Deposit',3000);
INSERT INTO trandetails VALUES('T00009','A00001','2013-03-21','Cash','Withdrawal',9000);
INSERT INTO trandetails VALUES('T00010','A00001','2013-03-22','Cash','Withdrawal',2000);
INSERT INTO trandetails VALUES('T00011','A00002','2013-03-25','Cash','Withdrawal',7000);
INSERT INTO trandetails VALUES('T00012','A00007','2013-03-26','Cash','Withdrawal',2000);





INSERT INTO loan VALUES('C00001','B00001',100000);
INSERT INTO loan VALUES('C00002','B00002',200000);
INSERT INTO loan VALUES('C00009','B00008',400000);
INSERT INTO loan VALUES('C00010','B00009',500000);
INSERT INTO loan VALUES('C00001','B00003',600000);
INSERT INTO loan VALUES('C00002','B00001',600000);


select * from account;
select * from branch;
select * from customer;
select * from loan;
select * from trandetails;
-- --- easy ----
-- 1
select custid,fname,dob from customer order by extract(year from dob),fname;

-- 2
select custid,concat(fname,' ',coalesce(mname,ltname)) cust_name from customer;


-- 3
select c.custid,c.fname,c.ltname,a.acnumber,a.aod from account a join customer c on a.custid=c.custid;


-- 4
select count(custid) cust_account from customer where city='delhi' group by city;


-- 5
select c.custid,c.fname,a.acnumber from customer c 
join account a on a.custid=c.custid where extract(day from a.aod)>15;

select extract(day from aod) from account;


-- 6
select c.fname,c.city,a.acnumber from account a join
customer c on a.custid=c.custid where c.occupation not in('business' , 'service' , 'student');


-- 7
select bcity,count(bname)  count_branch from branch group by bcity;

-- 8
select a.acnumber,c.fname,c.ltname from customer c 
join account a on c.custid=a.custid where a.astatus='Active';

-- 9
select c.fname,l.custid,l.bid,l.loan_amount from customer c 
join loan l on l.custid=c.custid;

-- 10
select a.acnumber,a.custid,c.fname from customer c
join account a on a.custid=c.custid where a.astatus='terminated';

-- -----hard-----

-- 1
select acnumber from trandetails group by acnumber having count(transaction_type)
>=ALL(select count(transaction_type) from trandetails group by acnumber);


-- 2
select bname,bcity from branch where bid=
(select bid from account group by bid having count(custid)>=
ALL(select count(custid) from account group by bid));


-- 3
select ((select sum(transaction_amount) 
from trandetails where transaction_type='deposit' and acnumber='A00001' group by acnumber)-
(select sum(transaction_amount) from trandetails where transaction_type='withdrawal' 
and acnumber='A00001' group by acnumber)+(select a.acnumber,a.opening_balance from account a join trandetails t on a.acnumber=t.acnumber)) net_amount ; 

-- 4
select a-b cal,k.acnumber from 
(select sum(transaction_amount) a,acnumber 
from trandetails where transaction_type='deposit'  group by acnumber) m, 
(select sum(transaction_amount) b ,acnumber from trandetails where transaction_type='withdrawal' 
group by acnumber) k  where m.acnumber=k.acnumber having cal<0;


-- 5
select custid,fname,ltname from customer where custid in (select custid from loan having sum(loan_amount)
>=ALL(select sum(loan_amount) from loan group by custid));


SELECT c.custid,c.fname,c.ltname from customer c join loan l using(custid) group by c.custid 
having sum(l.loan_amount)>=all(select sum(loan_amount) from loan group by custid having count(bid)>=2 );

-- ------average-----


-- 1
select acnumber from trandetails group by acnumber having count(transaction_type) 
<=ALL(select count(transaction_type) from trandetails group by acnumber);


-- 2

select c.custid,c.fname,

-- 3

select c.custid,c.fname,c.ltname from customer c 
join loan l on c.custid=l.custid group by l.custid having count(l.custid) 
>=ALL(select count(bid) from loan group by custid);

-- 4
select count(custid) count from loan where bid not in
(select a.bid from account a join loan l on a.custid=l.custid where a.bid=l.bid) ;


-- 5
select t.acnumber,sum(t.transaction_amount)+a.opening_balance Deposit_Amount 
from trandetails t join account a on a.acnumber=t.acnumber 
where transaction_type='Deposit' group by acnumber;


-- 6
select count(custid) count from customer where custid  not in(select custid from account);


-- 7
select count(a.custid) count from account a right join branch b on a.bid=b.bid group by b.bcity,b.bid;


-- 8
select custid,fname from customer where custid in
(select custid from account group by custid having count(acnumber) in 
(select count(acnumber) from account   group by custid having count(acnumber)>1));


-- 9
select custid,fname from customer where custid in
(select custid from account group by custid having count(acnumber) in 
(select count(acnumber) from account   group by custid having count(acnumber)>1)) and custid in
(select custid from account group by custid having count(bid) in 
(select count(bid) from account   group by custid having count(bid)>=2));


-- 10
COMPLEX-------4------ select dd.acnumber,deposit,withdrawal,dd.opening_balance,(deposit-withdrawal+dd.opening_balance)as balance 
from 
(select sum(transaction_amount)as Deposit,b.Opening_balance,a.acnumber from trandetails a,account b
where b.acnumber=a.acnumber and transaction_type='Deposit' group by a.acnumber)dd,
(select sum(transaction_amount)as Withdrawal,a.acnumber  from trandetails a,account b
where b.acnumber=a.acnumber and transaction_type='Withdrawal' group by a.acnumber)ww
where dd.acnumber=ww.acnumber group by dd.acnumber;
