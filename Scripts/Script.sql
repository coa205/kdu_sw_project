select * from software;
select * from supply_company;
select * from client;
select * from sale_detail;
select * from sale;

select clntName from client;

drop table software;
drop table supply_company;
drop table client;
drop table sale;
drop table post;

delete from supply_company where compNo = 'SC006';

delete from sale_detail where saleNo = 'SL011';

delete from sale where saleNo = 'SL011';

select count(*) from sale;

select swNo from software where swName='아마겟돈';

insert into sale_detail(saleNo) values((select swNo from software where swName='아마겟돈'));

insert into sale_detail(saleNo) values((select clntNo from client where clntName='재밌는 게임방'));

insert into sale(saleNo, clntNo, swNo, sellingAmount, isDeposit, orderDate) values
('SL011', (select clntNo from client where clntName='재밌는 게임방'),
(select swNo from software where swName='아마겟돈'), 25, 1, '2010-09-11');

CREATE TRIGGER tri_SaleDetail_Insert
AFTER INSERT ON sale
FOR EACH ROW 
BEGIN SET
   /*판매 금액*/     @sellingPrice   = (SELECT swPrice FROM software s WHERE s.swNo=NEW.swNo)       * NEW.sellingAmount,
   /*공급 금액*/     @supplyPrice   = (SELECT swSupplyPrice FROM software s WHERE s.swNo=NEW.swNo)    * NEW.sellingAmount,
   /*마진액*/        @margin         = @sellingPrice - @supplyPrice,
   /*세금*/        @tax         = @sellingPrice * 0.1,
   /*총 납부금액*/ @totalPrice      = @sellingPrice + @tax,
   /*미수금*/        @outstanding   = @totalPrice    * NEW.isDeposit;
   INSERT INTO sale_detail VALUES (NEW.saleNo, @sellingPrice, @supplyPrice, @margin, @outstanding, @tax, @totalPrice);
END ;

CREATE TRIGGER tri_SaleDetail_Update
AFTER UPDATE ON sale
FOR EACH ROW 
BEGIN SET
   /*미수금*/   @outstanding    = @totalPrice * !(NEW.isDeposit);
UPDATE sale_detail SET outstanding= @outstanding where saleNo=new.saleNo;
END ;

ALTER TABLE sw_project.category CHANGE groupt `group` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ;

-- ==================== 공급회사 등록 ====================
insert into supply_company(comp_code, comp_name, comp_addr, comp_tel, comp_isleave) values
('CC001', '알럽소프트','경기도 부천시 계산동', '02-930-4551',true),
('CC002', '인디넷','경기도 수원시 제포동', '032-579-4512',true),
('CC003', '참빛소프트','경기도 파주군 은빛아파트', '032-501-4503',true),
('CC004', '소프트마켓','서울특별시 광진구 자양동', '02-802-4564',true),
('CC005', '크라이스','경기도 고양시 대자동 서영아파트', '032-659-3215',false),
('CC006', '프로그램캠프','경기도 부천시 오정구', '032-659-3215',false);

select * from supply_company;
select * from supply_company where comp_code = 'CC001';

update supply_company 
set comp_name = '유비소프트웨어', comp_addr = '서울특별시 마포구 서교동', comp_tel = '1661-9507', comp_isleave = false 
where comp_code = 'CC001';

delete from supply_company where comp_code = 'CC006';


-- ==================== 분류 등록 ====================
insert into category(group_code, `group`)values
('GC001', '게임'),
('GC002', '사무'),
('GC003', '그래픽');

select * from category;
delete from category where group_code = 'GC009';

-- ==================== 소프트웨어 등록 ====================
insert into software(sw_code, group_code, sw_name, sale_price, sw_inven, sw_issale) values
('SC001', 'GC001', '바람의제국', 40000, 500, true),
('SC002', 'GC002', '국제무역', 48000, 300, true),
('SC003', 'GC001', 'FIFA2015', 40500, 200, true),
('SC004', 'GC001', '삼국지', 48000, 300, true),
('SC005', 'GC001', '아마겟돈', 50750, 300, true),
('SC006', 'GC002', '한컴오피스', 1918000, 100, false),
('SC007', 'GC003', '포토샵', 1519000, 100, false),
('SC008', 'GC003', '오토캐드2015', 3978000, 200, true),
('SC009', 'GC003', '인디자인', 2180400, 200, false),
('SC010', 'GC002', 'Windows10', 3334500, 100, false);

select * from software;
select `group` from category;
select * from software where sw_code = 'SC001';

select s.*, c.`group`
from software s inner join category c on c.group_code = s.group_code
order by sw_code;

update software
set group_code = 'GC002', sw_name = 'eclipse', sale_price = 10000, sw_inven = 500, sw_issale = false
where sw_code = 'SC001';

delete from software where sw_code = 'SC010';





