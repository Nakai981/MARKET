package com.phan.market.controllers;

import com.phan.market.config.DBconfig;
import com.phan.market.entity.Bill;
import com.phan.market.entity.Employee;
import com.phan.market.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private String user;
    private int idUser;
    private String idShipment;
    private int idBill=0;
    private int count=0;
    List<Bill> bills;
    private float sumPrice=0;
    private String type="";

    @GetMapping
    public String _default_1(ModelMap modelMap, Principal principal){
        idBill=0;
        bills = new ArrayList<>();
        user=principal.getName();
        modelMap.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/create")
    public String _default(ModelMap modelMap, Principal principal){
        bills = new ArrayList<>();
        sumPrice=0;
        idShipment="";
        count =1;
      //  user=principal.getName();
        try {
            Employee emp = DBconfig.connectEmployeeDao().getIdEmpolyeeByName(user);
            idUser = emp.getId();
            int index = 0;
            index=DBconfig.connectBillDao().addBill(idUser);
            if (index>0){
                Bill bill;
                bill = DBconfig.connectBillDao().getIdBill();
                idBill = bill.getId();
            }
        }catch (Exception e){

        }
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("idBill",idBill);
        modelMap.addAttribute("sumPrice",sumPrice);
        return "user";
    }
    @GetMapping(value={"api/item/bill","user/api/item/bill"}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String searchItemNameByBill(@RequestParam String txtName){
        String html="";
        List<Bill> billList = DBconfig.connectBillDao().selectItemBySearchAPI(txtName);
        if(billList.size()>0){
            for(Bill imp:billList){
                html+= "<li onclick='show("+imp.getName_employee()+")'>"+imp.getName_item()+"</li>";
            }
        }else{
            html = html + "<i style='margin-left:5px'>Không có dữ liệu</i>";
        }

        return html;
    }
    @GetMapping("/tg")
    public String _bill_tg(ModelMap modelMap, @RequestParam int count1,@RequestParam String idLo ){
        if(bills.size()>0){
            for(Bill b: bills){
                if(b.getName_employee().equals(idLo)){
                    b.setCount(count1);
                    b.setSum_price();
                }
            }
        }
        sumPrice=sumPrice();
        modelMap.addAttribute("listBill",bills);
        modelMap.addAttribute("idBill",idBill);
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("sumPrice",sumPrice);
        return "redirect:/user/tg1";
    }
    @GetMapping("/tg1")
    public String _bill_tg1(ModelMap modelMap){
        modelMap.addAttribute("b",bills.size());
        modelMap.addAttribute("listBill",bills);
        modelMap.addAttribute("idBill",idBill);
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("sumPrice",sumPrice);
        return "user";
    }
    @GetMapping("insert")
    public String _bill_insert(ModelMap modelMap){
        int index=0;
        if(bills.size()>0){
            try{
                for(Bill b: bills){
                   int in = DBconfig.connectBillDao().addDetailBill(b,idBill);
                   index+=in;
                }
            }catch (Exception e){
            }
        }
        String alert="";
        if(index ==0){
             alert=" <script type=\"text/javascript\">\n" +
                    "          swal(\"Không thành công!\", \"Xem lại các bước sử dụng\", \"warning\")\n" +
                    "          .then((value) => {\n" +
                    "            window.location=\"/user/tg1\";\n" +
                    "          });     \n" +
                    "     </script>";

        }else{
            alert=" <script type=\"text/javascript\">\n" +
                    "          swal(\"Thanh toán thành công\", \"Đơn hàng số: "+idBill+"\", \"success\")\n" +
                    "          .then((value) => {\n" +
                    "            window.location=\"/user\";\n" +
                    "          });     \n" +
                    "     </script>";
        }
        modelMap.addAttribute("type",alert);
        modelMap.addAttribute("b",bills.size());
        modelMap.addAttribute("listBill",bills);
        modelMap.addAttribute("idBill",idBill);
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("sumPrice",sumPrice);
         return "user";

    }
    @GetMapping("/listitem")
    public String _bill_adđ(ModelMap modelMap, @RequestParam String idLo){
        try {
            idShipment=idLo;
            List<Bill> bill = DBconfig.connectBillDao().getBillbyIdShipment(idLo);
            bill.get(0).setCount(count);
            bill.get(0).setSum_price();
            bills.add(bill.get(0));
            sumPrice=sumPrice();
        }catch (Exception e){}



//        modelMap.addAttribute("listBill",bills);
//        modelMap.addAttribute("idBill",idBill);
//        modelMap.addAttribute("user",user);
//        modelMap.addAttribute("sumPrice",sumPrice);
        return "redirect:/user/tg1";
    }
    @GetMapping("/del")
    public String _bill_dell(ModelMap modelMap, @RequestParam String idLo){
        if(bills.size()>0){
            for(int i=0;i<bills.size();i++){
                if(bills.get(i).getName_employee().equals(idLo)){
                    bills.remove(i);
                }
            }
        }
        sumPrice=sumPrice();
//        modelMap.addAttribute("listBill",bills);
//        modelMap.addAttribute("idBill",idBill);
//        modelMap.addAttribute("user",user);
//        modelMap.addAttribute("sumPrice",sumPrice);
        return "redirect:/user/tg1";
    }
    @GetMapping("/cancel")
    public String _bill_cancel(ModelMap modelMap){
        bills=new ArrayList<>();
        return "redirect:/user/tg1";
    }
    public float sumPrice(){
        float sum=0;
        if(bills.size()>0){
            for(Bill b: bills){
                sum += b.getSum_price();
            }
        }else{
            sum=0;
        }
        return sum;
    }
}
