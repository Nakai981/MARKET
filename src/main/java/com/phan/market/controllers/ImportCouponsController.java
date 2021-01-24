package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Employee;
import com.phan.market.entity.ImpCouponDetail;
import com.phan.market.entity.ImportCoupon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/coupons")
public class ImportCouponsController {
    List<ImportCoupon> importCouponList;
    List<ImpCouponDetail> importCouponDetail;
    private String accountName="";
    private int idCoupon=0;
    private float sumPrice;
    private int status;

    public void totalCoupons(){
        sumPrice =0;
        if (importCouponDetail.size()>0){
            for(ImpCouponDetail im: importCouponDetail){
                sumPrice+=im.getPrice();
            }
        }

    }

    @GetMapping
    public String _coupons(ModelMap modelMap, Principal principal){
        try{
            status= 0;
            accountName = principal.getName();
            importCouponList =  DBconfig.connectImportCouponDao().importCouponList();
            idCoupon=importCouponList.get(0).getId();
            importCouponDetail=DBconfig.connectImportCouponDao().importDetailCouponList(idCoupon);
            totalCoupons();
        }catch (Exception e){

        }
        modelMap.addAttribute("func","Thêm mới");
        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("idCoupon",idCoupon);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("total",sumPrice);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        return "coupons";
    }

    @GetMapping("/detail")
    public String _coupons_detail(ModelMap modelMap,@RequestParam int id){

        try{
            idCoupon=id;
            importCouponDetail=DBconfig.connectImportCouponDao().importDetailCouponList(idCoupon);
            totalCoupons();
        }catch (Exception ex){}
        modelMap.addAttribute("func","Thêm mới");
        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        modelMap.addAttribute("total",sumPrice);
        return "coupons";
    }
    @GetMapping("/detail/add")
    public String _coupons_detail_add(ModelMap modelMap,@RequestParam String txtMaLo,@RequestParam int txtNCC,@RequestParam float txtDonGia,@RequestParam int txtSL){

        try{
            if(status==0){
                ImpCouponDetail impCouponDetail = new ImpCouponDetail(idCoupon,txtSL,txtDonGia,txtMaLo,txtNCC);
                int index = DBconfig.connectImportCouponDao().addDetailCoupon(impCouponDetail);
            }else{
                ImpCouponDetail impCouponDetail = new ImpCouponDetail(idCoupon,txtSL,txtDonGia,txtMaLo,txtNCC);
                impCouponDetail.setId(idDetail);
                int index = DBconfig.connectImportCouponDao().updateDetailCoupon(impCouponDetail);
                status=0;
                idDetail=0;
            }

        }catch (Exception ex){}

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        return "redirect:/admin/coupons/detail?id="+idCoupon;
    }
    @GetMapping("/detail/del")
    public String _coupons_detail_dell(ModelMap modelMap,@RequestParam int id){
        int index=0;
        try{
            index = DBconfig.connectImportCouponDao().delDetailCoupon(id);
        }catch (Exception ex){}
        String alert="";
        if(index==0){
            alert=" <script type=\"text/javascript\">\n" +
                    "         alert('Hàng này đã được bán. Không thể xóa!')" +
                    "     </script>";
            modelMap.addAttribute("func","Thêm mới");
            modelMap.addAttribute("user",accountName);
            modelMap.addAttribute("importCoupons",importCouponList);
            modelMap.addAttribute("importCouponsDetail",importCouponDetail);
            modelMap.addAttribute("idCoupon",idCoupon);
            modelMap.addAttribute("total",sumPrice);
            modelMap.addAttribute("alert",alert);
            return "coupons";
        }

        return "redirect:/admin/coupons/detail?id="+idCoupon;
    }
    private int idDetail=0;
    @GetMapping("/detail/update1")
    public String _coupons_detail_update_1(ModelMap modelMap,@RequestParam int txtMaDetail){
        status=1;
        ImpCouponDetail impCouponDetail = new ImpCouponDetail();
        if(importCouponDetail.size()>0)  {
            for(ImpCouponDetail impd: importCouponDetail){
                if(impd.getId() == txtMaDetail){
                    impCouponDetail = impd;
                }
            }
            idDetail = impCouponDetail.getId();
        }
        modelMap.addAttribute("func","Chỉnh sửa");
        modelMap.addAttribute("imp",impCouponDetail);
        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        return "coupons";
    }
    @GetMapping("/add")
    public String _coupons_add(ModelMap modelMap){

        try{
            Employee employee = DBconfig.connectEmployeeDao().getIdEmpolyeeByName(accountName);
            int index = DBconfig.connectImportCouponDao().addCoupon(employee.getId());

        }catch (Exception ex){}

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        return "redirect:/admin/coupons";
    }
    @GetMapping("/del")
    public String _coupons_del(ModelMap modelMap,@RequestParam int id){

        try{
            int index = DBconfig.connectImportCouponDao().delCoupon(id);
        }catch (Exception ex){}

        modelMap.addAttribute("user",accountName);
        modelMap.addAttribute("importCoupons",importCouponList);
        modelMap.addAttribute("importCouponsDetail",importCouponDetail);
        modelMap.addAttribute("idCoupon",idCoupon);
        return "redirect:/admin/coupons";
    }
}
