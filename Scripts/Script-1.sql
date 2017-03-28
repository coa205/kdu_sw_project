-- SW프로젝트
DROP SCHEMA IF EXISTS sw_project;

-- SW프로젝트
CREATE SCHEMA sw_project;

-- 납품
CREATE TABLE sw_project.delivery (
	del_no        VARCHAR(6) NOT NULL, -- 납품번호
	comp_code     VARCHAR(6) NOT NULL, -- 공급회사번호
	sw_code       VARCHAR(6) NOT NULL, -- 품목번호
	supply_price  INTEGER    NOT NULL, -- 공급가격
	supply_amount INTEGER    NOT NULL, -- 공급수량
	order_date    DATE       NOT NULL  -- 납품날짜
);

-- 납품
ALTER TABLE sw_project.delivery
	ADD CONSTRAINT PK_delivery -- 납품 기본키
		PRIMARY KEY (
			del_no -- 납품번호
		);

-- 공급회사
CREATE TABLE sw_project.supply_company (
	comp_code    VARCHAR(6)  NOT NULL, -- 공급회사번호
	comp_name    VARCHAR(20) NOT NULL, -- 공급회사명
	comp_addr    VARCHAR(50) NULL,     -- 공급회사주소
	comp_tel     VARCHAR(15) NULL,     -- 공급회사전화번호
	comp_isleave BOOLEAN     NOT NULL  -- 탈퇴여부
);

-- 공급회사
ALTER TABLE sw_project.supply_company
	ADD CONSTRAINT PK_supply_company -- 공급회사 기본키
		PRIMARY KEY (
			comp_code -- 공급회사번호
		);

-- 소프트웨어
CREATE TABLE sw_project.software (
	sw_code    VARCHAR(6)  NOT NULL, -- 품목번호
	group_code VARCHAR(6)  NOT NULL, -- 분류코드
	sw_name    VARCHAR(50) NOT NULL, -- 품목명
	sale_price INTEGER     NOT NULL, -- 판매가격
	sw_inven   INTEGER     NOT NULL, -- 재고
	sw_issale  BOOLEAN     NOT NULL  -- 판매가능여부
);

-- 소프트웨어
ALTER TABLE sw_project.software
	ADD CONSTRAINT PK_software -- 소프트웨어 기본키
		PRIMARY KEY (
			sw_code -- 품목번호
		);

-- 분류
CREATE TABLE sw_project.category (
	group_code VARCHAR(6)  NOT NULL, -- 분류코드
	groupt     VARCHAR(20) NOT NULL  -- 분류
);

-- 분류
ALTER TABLE sw_project.category
	ADD CONSTRAINT PK_category -- 분류 기본키
		PRIMARY KEY (
			group_code -- 분류코드
		);

-- 거래내역
CREATE TABLE sw_project.sale (
	sale_no      VARCHAR(6) NOT NULL, -- 주문번호
	clnt_no      VARCHAR(6) NOT NULL, -- 거래회사번호
	sw_code      VARCHAR(6) NOT NULL, -- 품목번호
	sale_amount  INTEGER    NOT NULL, -- 판매수량
	isdeposit    BOOLEAN    NOT NULL, -- 입금여부
	order_date   DATE       NOT NULL, -- 주문날짜
	supply_price INTEGER    NOT NULL, -- 공급가
	sale_price   INTEGER    NOT NULL  -- 판매가
);

-- 거래내역
ALTER TABLE sw_project.sale
	ADD CONSTRAINT PK_sale -- 거래내역 기본키
		PRIMARY KEY (
			sale_no -- 주문번호
		);

-- 거래회사
CREATE TABLE sw_project.client (
	clnt_no      VARCHAR(6)  NOT NULL, -- 거래회사번호
	clnt_name    VARCHAR(20) NOT NULL, -- 거래회사이름
	clnt_addr    VARCHAR(50) NULL,     -- 거래회사주소
	clnt_tel     VARCHAR(15) NULL,     -- 거래회사전화번호
	clnt_isleave BOOLEAN     NOT NULL  -- 탈퇴여부
);

-- 거래회사
ALTER TABLE sw_project.client
	ADD CONSTRAINT PK_client -- 거래회사 기본키
		PRIMARY KEY (
			clnt_no -- 거래회사번호
		);

-- 납품
ALTER TABLE sw_project.delivery
	ADD CONSTRAINT FK_supply_company_TO_delivery -- 공급회사 -> 납품
		FOREIGN KEY (
			comp_code -- 공급회사번호
		)
		REFERENCES sw_project.supply_company ( -- 공급회사
			comp_code -- 공급회사번호
		);

-- 납품
ALTER TABLE sw_project.delivery
	ADD CONSTRAINT FK_software_TO_delivery -- 소프트웨어 -> 납품
		FOREIGN KEY (
			sw_code -- 품목번호
		)
		REFERENCES sw_project.software ( -- 소프트웨어
			sw_code -- 품목번호
		);

-- 소프트웨어
ALTER TABLE sw_project.software
	ADD CONSTRAINT FK_category_TO_software -- 분류 -> 소프트웨어
		FOREIGN KEY (
			group_code -- 분류코드
		)
		REFERENCES sw_project.category ( -- 분류
			group_code -- 분류코드
		);

-- 거래내역
ALTER TABLE sw_project.sale
	ADD CONSTRAINT FK_software_TO_sale -- 소프트웨어 -> 거래내역
		FOREIGN KEY (
			sw_code -- 품목번호
		)
		REFERENCES sw_project.software ( -- 소프트웨어
			sw_code -- 품목번호
		);

-- 거래내역
ALTER TABLE sw_project.sale
	ADD CONSTRAINT FK_client_TO_sale -- 거래회사 -> 거래내역
		FOREIGN KEY (
			clnt_no -- 거래회사번호
		)
		REFERENCES sw_project.client ( -- 거래회사
			clnt_no -- 거래회사번호
		);