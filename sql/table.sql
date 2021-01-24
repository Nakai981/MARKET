﻿DROP DATABASE QLST

CREATE DATABASE QLST
GO
USE QLST
GO

/*	TẠO CÁC BẢNG TABLE TRONG SQL SERVER*/
CREATE TABLE MAT_HANG(
	MA_MH  INT IDENTITY PRIMARY KEY NOT NULL,
	TEN_MH NVARCHAR(30),
	DON_VI VARCHAR(10),
	ENABLE BIT
);
GO

CREATE TABLE LO_HANG(
	MA_LO VARCHAR(30) PRIMARY KEY NOT NULL,
	SL INT,
	HSD DATE,
	GIA_BAN FLOAT,CHECK (GIA_BAN >0),
	ENABLE BIT,
	MA_MH INT,CONSTRAINT FK_LH_MH 
	FOREIGN KEY (MA_MH) REFERENCES MAT_HANG(MA_MH)
);
GO
CREATE TABLE CHUC_VU(
	MA_CV INT IDENTITY PRIMARY KEY NOT NULL,
	TEN_CV NVARCHAR(50)
);
GO
CREATE TABLE NHAN_VIEN(
	MA_NV INT IDENTITY PRIMARY KEY NOT NULL,
	TEN_NV NVARCHAR(70) NOT NULL,
	GIOI_TINH INTEGER,
	CMND NUMERIC(11,0),
	SDT NUMERIC(10,0),
	DIACHI NVARCHAR(200),
	TEN_DANG_NHAP NVARCHAR(30),
	MAT_KHAU NVARCHAR(30),
	ENABLE BIT,
	MA_CV INT,CONSTRAINT FK_NV_CV 
	FOREIGN KEY (MA_CV) REFERENCES CHUC_VU(MA_CV)
);
GO


CREATE TABLE NHA_CUNG_CAP(
	MA_CUNG_CAP INT IDENTITY PRIMARY KEY NOT NULL,
	TEN_CUNG_CAP NVARCHAR(70),
	SDT NUMERIC(10,0),
	DIACHI NVARCHAR(200),
	ENABLE BIT
);
GO

CREATE TABLE PHIEU_NHAP_HANG(
	MA_PHIEU INT IDENTITY PRIMARY KEY NOT NULL,
	NGAY_NHAP DATE DEFAULT GETDATE(),
	ENABLE BIT,
	MA_NV INT, CONSTRAINT FK_PHIEU_NV 
	FOREIGN KEY (MA_NV) REFERENCES NHAN_VIEN (MA_NV),
);
GO

CREATE TABLE CHI_TIET_PHIEU_NHAP(
	MA_CT_PHIEU INT IDENTITY PRIMARY KEY,
	SL_NHAP INT, CHECK (SL_NHAP>0),
	GIA_NHAP FLOAT, CHECK (GIA_NHAP>0),
	MA_PHIEU INT, CONSTRAINT FK_CTPHIEU_P 
	FOREIGN KEY (MA_PHIEU)REFERENCES PHIEU_NHAP_HANG (MA_PHIEU),
	MA_CUNG_CAP INT, CONSTRAINT FK_CTPHIEU_NCC 
	FOREIGN KEY (MA_CUNG_CAP)REFERENCES NHA_CUNG_CAP (MA_CUNG_CAP),
	MA_LO VARCHAR(30), CONSTRAINT FK_CTPHIEU_MH 
	FOREIGN KEY (MA_LO)REFERENCES LO_HANG (MA_LO)
);
GO

CREATE TABLE PHIEU_KIEM_KE(
	MA_PHIEU_KIEM INT IDENTITY PRIMARY KEY NOT NULL,
	NGAY_LAP DATE DEFAULT GETDATE(),
	ENABLE BIT,
	MA_NV INT, CONSTRAINT FK_PHIEUKK_NV
	FOREIGN KEY (MA_NV) REFERENCES NHAN_VIEN (MA_NV),
); 
GO

CREATE TABLE CHI_TIET_KIEM_KE(
	MA_CT_KIEM INT IDENTITY PRIMARY KEY NOT NULL,
	SO_LUONG_TON INT, CHECK(SO_LUONG_TON>0),
	MA_LO VARCHAR(30), CONSTRAINT FK_CTKIEMKE_MH 
	FOREIGN KEY (MA_LO)REFERENCES LO_HANG (MA_LO),
	MA_PHIEU_KIEM INT, CONSTRAINT FK_CTKIEMKE_KK 
	FOREIGN KEY (MA_PHIEU_KIEM) REFERENCES PHIEU_KIEM_KE(MA_PHIEU_KIEM)
);
GO

CREATE TABLE HOA_DON_BAN(
	MA_HD INT IDENTITY PRIMARY KEY NOT NULL,
	NGAY_BAN DATE DEFAULT GETDATE(),
	ENABLE BIT,
	MA_NV INT, CONSTRAINT FK_HOADON_NV
	FOREIGN KEY (MA_NV) REFERENCES NHAN_VIEN (MA_NV)
);
GO

CREATE TABLE CHI_TIET_HOA_DON(
	MA_CT_HD INT IDENTITY PRIMARY KEY NOT NULL,
	SL_BAN INT, CHECK(SL_BAN>0),
	MA_HD INT, CONSTRAINT FK_CTHOADON_HD
	FOREIGN KEY (MA_HD) REFERENCES HOA_DON_BAN (MA_HD),
	MA_LO VARCHAR(30), CONSTRAINT FK_CTHOADON_MH
	FOREIGN KEY (MA_LO) REFERENCES LO_HANG (MA_LO)
);
GO

 