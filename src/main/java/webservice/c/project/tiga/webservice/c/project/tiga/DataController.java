/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.c.project.tiga.webservice.c.project.tiga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Fanky
 */
@Controller
public class DataController {
    
    @RequestMapping("/cariData")
    public String getData(Model model, HttpServletRequest params) {
        String cari = params.getParameter("cari");
        String button = params.getParameter("button");
        String status = "";
        
        ArrayList<List<String>> data = new ArrayList<>();
        
        data.add(Arrays.asList("Motor","Sapra"));
        data.add(Arrays.asList("Mobil","Nyaris"));
        data.add(Arrays.asList("Pesawat","Airbis"));
        
        ArrayList<List<String>> result = new ArrayList<>();
        
        if (button.equals("CARI")) {
            for (List<String> list : data) {
                if (list.get(0).toLowerCase().contains(cari.toLowerCase()) || list.get(1).toLowerCase().contains(cari.toLowerCase())) {
                    result.add(list);
                }
            }
        } else if (button.equals("HAPUS")) {
            result.addAll(data);
            for (List<String> list : data) {
                if (list.get(0).toLowerCase().contains(cari.toLowerCase()) || list.get(1).toLowerCase().contains(cari.toLowerCase())) {
                    result.remove(list);
                }
            }
        }
        
        if (result.isEmpty()) {
            status = "Data tidak ditemukan";
        }
        
        model.addAttribute("cari",cari);
        model.addAttribute("data",data);
        model.addAttribute("result",result);
        model.addAttribute("status",status);
        
        return "viewData";
    }
}
