CREATE TABLE cart (
        cartno  NUMBER(10)      NOT NULL PRIMARY KEY,
        id      VARCHAR2(10)    NULL,
            FOREIGN KEY (ID) REFERENCES member (ID)
);

drop table oder CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: 주문 */
/**********************************/
CREATE TABLE orders(
orderno                        NUMBER(10)  NOT NULL  PRIMARY KEY,
id                             VARCHAR2(10)  NOT NULL,
contentsno                     NUMBER(10)  NULL ,
cartno                         NUMBER(10)  NULL ,
odate                          DATE  NOT NULL,
quantity                       NUMBER(10)  NOT NULL,
total                          NUMBER(10)  NOT NULL,
payment                        VARCHAR2(50)  NOT NULL,
mname                          VARCHAR2(20)  NOT NULL,
pname                         VARCHAR2(50)  NOT NULL,
  FOREIGN KEY (contentsno) REFERENCES contents (contentsno),
  FOREIGN KEY (cartno) REFERENCES cart (cartno)
);
 
insert into orders(
orderno, cartno, contentsno, odate, quantity, total, payment, id, mname, pname)
values((select nvl(max(orderno),0)+1 from orders),null,1,sysdate,1,90000,'신용카드',
'test','홍길동','Mega Ripped Jeans');
 
insert into orders(
orderno, cartno, contentsno, odate, quantity, total, payment, id, mname, pname)
values((select nvl(max(orderno),0)+1 from orders),null,10,sysdate,1,33000,'신용카드',
'test','홍길동','Crocodile bag');


--(2) left outer join 문작성
select  m.id, m.mname, m.fname, m.zipcode, m.address1, m.address2,
         o.orderno,o.odate,o.pname,o.quantity,o.total,o.contentsno
 from  member m left outer join orders o
    on  m.id = o.id
where  m.id='test';