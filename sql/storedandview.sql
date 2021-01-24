﻿USE QLST
GO
--Strored

--XEM DOANH THU THEO NGAY-THANG-NAM
CREATE PROCEDURE DOANH_THU_THEO_NGAY  @date VARCHAR(30) AS
SELECT HDB.MA_HD,NV.TEN_NV,HDB.NGAY_BAN,MH.TEN_MH,CTHD.SL_BAN,LH.GIA_BAN,LH.GIA_BAN*CTHD.SL_BAN AS TONG_TIEN
FROM HOA_DON_BAN HDB join CHI_TIET_HOA_DON CTHD
ON HDB.MA_HD=CTHD.MA_HD
JOIN NHAN_VIEN NV
ON NV.MA_NV=HDB.MA_NV
JOIN LO_HANG LH
ON CTHD.MA_LO=LH.MA_LO
JOIN MAT_HANG MH
ON MH.MA_MH=LH.MA_MH
WHERE HDB.NGAY_BAN=@date

GO

CREATE PROCEDURE DOANH_THU_THEO_THANG @date VARCHAR(30) AS
SELECT HDB.MA_HD,NV.TEN_NV,HDB.NGAY_BAN,MH.TEN_MH,CTHD.SL_BAN,LH.GIA_BAN,LH.GIA_BAN*CTHD.SL_BAN AS TONG_TIEN
FROM HOA_DON_BAN HDB join CHI_TIET_HOA_DON CTHD
ON HDB.MA_HD=CTHD.MA_HD
JOIN NHAN_VIEN NV
ON NV.MA_NV=HDB.MA_NV
JOIN LO_HANG LH
ON CTHD.MA_LO=LH.MA_LO
JOIN MAT_HANG MH
ON MH.MA_MH=LH.MA_MH
WHERE MONTH(HDB.NGAY_BAN)=MONTH(@date)
GO

CREATE PROCEDURE DOANH_THU_THEO_NAM @date varchar(30) AS
select HDB.MA_HD,NV.TEN_NV,HDB.NGAY_BAN,MH.TEN_MH,CTHD.SL_BAN,LH.GIA_BAN,LH.GIA_BAN*CTHD.SL_BAN as TONG_TIEN
FROM HOA_DON_BAN HDB join CHI_TIET_HOA_DON CTHD
ON HDB.MA_HD=CTHD.MA_HD
JOIN NHAN_VIEN NV
ON NV.MA_NV=HDB.MA_NV
JOIN LO_HANG LH
ON CTHD.MA_LO=LH.MA_LO
JOIN MAT_HANG MH
ON MH.MA_MH=LH.MA_MH
WHERE YEAR(HDB.NGAY_BAN)=YEAR(@date)
GO

--Danh sách chi tiết phiếu theo mã id phiếu
CREATE PROCEDURE DS_CHI_TIET_PHIEU_NHAP @id INT AS
	SELECT CTPN.MA_CT_PHIEU,PNH.MA_PHIEU,CTPN.SL_NHAP,CTPN.GIA_NHAP,LH.MA_LO,MH.TEN_MH,NCC.MA_CUNG_CAP, NCC.TEN_CUNG_CAP
	FROM PHIEU_NHAP_HANG PNH 
		JOIN CHI_TIET_PHIEU_NHAP CTPN ON PNH.MA_PHIEU=CTPN.MA_PHIEU
		JOIN NHA_CUNG_CAP NCC ON NCC.MA_CUNG_CAP=CTPN.MA_CUNG_CAP
		JOIN LO_HANG LH ON LH.MA_LO=CTPN.MA_LO
		JOIN MAT_HANG MH ON MH.MA_MH=LH.MA_MH
	WHERE PNH.MA_PHIEU=@id
GO
-- Danh sách mặt hàng hết hạn
CREATE PROCEDURE DS_MH_HET_HAN @count INT AS
SELECT MA_LO, DATEADD(month, @count, GETDATE()) AS NGAY_BD,HSD,MH.TEN_MH,LH.SL,GIA_BAN FROM LO_HANG LH
JOIN MAT_HANG MH
ON MH.MA_MH = LH.MA_MH
WHERE HSD < DATEADD(MONTH, @count, GETDATE()) AND LH.ENABLE=1
ORDER BY HSD ASC
GO
-- Danh sách mặt hàng theo mã hóa đơn
CREATE PROCEDURE DANH_SACH_MAT_HANG_THEO_MAHD @id INT
AS
SELECT MH.TEN_MH,CTHD.SL_BAN,LH.GIA_BAN,LH.GIA_BAN*CTHD.SL_BAN AS TONG_TIEN
FROM HOA_DON_BAN HDB join CHI_TIET_HOA_DON CTHD
ON HDB.MA_HD=CTHD.MA_HD
JOIN LO_HANG LH
ON CTHD.MA_LO=LH.MA_LO
JOIN MAT_HANG MH
ON MH.MA_MH=LH.MA_MH
WHERE HDB.MA_HD= @id
GO
--KIỂM KÊ
CREATE PROCEDURE DS_CT_PHIEU_KIEM_KE @id int AS
SELECT CHI_TIET_KIEM_KE.MA_CT_KIEM,MAT_HANG.TEN_MH,LO_HANG.SL,CHI_TIET_KIEM_KE.SO_LUONG_TON,CHI_TIET_KIEM_KE.SO_LUONG_TON-LO_HANG.SL AS TONTAI FROM PHIEU_KIEM_KE 
INNER JOIN CHI_TIET_KIEM_KE ON PHIEU_KIEM_KE.MA_PHIEU_KIEM = CHI_TIET_KIEM_KE.MA_PHIEU_KIEM
INNER JOIN LO_HANG ON
LO_HANG.MA_LO = CHI_TIET_KIEM_KE.MA_LO
INNER JOIN MAT_HANG ON LO_HANG.MA_MH = MAT_HANG.MA_MH
WHERE PHIEU_KIEM_KE.MA_PHIEU_KIEM=@id
ORDER BY CHI_TIET_KIEM_KE.MA_CT_KIEM DESC
-- Bán hàng
CREATE PROCEDURE TIM_KIEM_SAN_PHAM_THEO_MALO @id varchar(30) AS
		SELECT MAT_HANG.TEN_MH,LO_HANG.GIA_BAN,LO_HANG.MA_LO FROM MAT_HANG
        INNER JOIN LO_HANG
        ON MAT_HANG.MA_MH = LO_HANG.MA_MH
        WHERE LO_HANG.MA_LO=@id AND LO_HANG.ENABLE=1
-- view

CREATE VIEW DANH_SACH_HOA_DON AS
SELECT TOP(99.99) PERCENT HDB.MA_HD,NV.TEN_NV,HDB.NGAY_BAN
FROM HOA_DON_BAN HDB
JOIN NHAN_VIEN NV
ON NV.MA_NV=HDB.MA_NV
ORDER BY HDB.MA_HD DESC

GO
