﻿USE QLST
GO

-- Chức vụ
INSERT INTO CHUC_VU VALUES ('ROLE_ADMIN'),('ROLE_USER');
GO
--Nhân viên
INSERT INTO NHAN_VIEN VALUES (N'Phan Huy Hoàng',0,8282821,038372637,N'NGHỆ AN','hoangpn','{noop}123456',1,1);
INSERT INTO NHAN_VIEN VALUES (N'Phan Huy Hoàng',0,8282821,038372637,N'NGHỆ AN','hoangpn','{noop}123456',1,2);
INSERT INTO NHAN_VIEN VALUES (N'Trần Trung Kiên',0,5362832,02546589,N'HÀ GIANG','KienTt','{noop}123456',1,2);
INSERT INTO NHAN_VIEN VALUES (N'Nguyễn Phương Nhất Linh',1,5648996,0255648,N'HÀ NỘI','LinhNpn','{noop}123456',1,1);
GO
-- Mặt hàng
INSERT INTO MAT_HANG VALUES (N'Bánh mỳ pháp','Cái',1)
INSERT INTO MAT_HANG VALUES (N'Sting','Chai',1)
INSERT INTO MAT_HANG VALUES (N'Kem sữa dừa','Cái',1)
INSERT INTO MAT_HANG VALUES (N'Coca 1.5l','Chai',1)
INSERT INTO MAT_HANG VALUES (N'Coca 750ml','Chai',1)
INSERT INTO MAT_HANG VALUES (N'Mì Kokomi','Gói',1)
INSERT INTO MAT_HANG VALUES (N'Bánh CoSy','Gói',1)
GO

-- Nhà cung cấp

INSERT INTO NHA_CUNG_CAP VALUES (N'CTy Cổ phần Sting',09878763,'Vĩnh long',1)
INSERT INTO NHA_CUNG_CAP VALUES (N'CTy TNTT Bánh mỳ',087637423,'Hà Nội',1)
INSERT INTO NHA_CUNG_CAP VALUES (N'CTy 1 thành viên Tràng An',093872727,'Nghệ An',1)
INSERT INTO NHA_CUNG_CAP VALUES (N'CTy mì tôm',0736363,'Bắc Ninh',1)
GO