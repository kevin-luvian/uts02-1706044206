package apap.uts.controller;

import apap.uts.model.PustakawanModel;
import apap.uts.service.PustakawanService;
import apap.uts.service.PustakawanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PustakawanController {
    @Autowired
    private PustakawanService pustakawanService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String home(Model model) {
        List<Map> pustakawanList = new ArrayList<>();
        for (PustakawanModel pustakawan : pustakawanService.getListPustakawan()) {
            Map pustakawanMap = PustakawanServiceImpl.parsePustakawanModel(pustakawan);
            pustakawanList.add(pustakawanMap);
        }
        model.addAttribute("pustakawanList", pustakawanList);
        return "home";
    }

    @RequestMapping(value = "/pustakawan/add", method = RequestMethod.GET)
    public String addPustakawanFormPage(Model model) {
        PustakawanModel newPustakawan = new PustakawanModel();
        model.addAttribute("pustakawan", newPustakawan);
        return "form-add-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/add", method = RequestMethod.POST)
    private String addPustakawanSubmit(@ModelAttribute PustakawanModel pustakawan, Model model){
        pustakawanService.addPustakawan(pustakawan);
        model.addAttribute("pustakawan", pustakawan);
        return "add-pustakawan";
    }

    @RequestMapping(value="/pustakawan/{pustakawanNip}", method=RequestMethod.GET)
    public String viewPustakawan(
        @PathVariable String pustakawanNip,
        Model model
    ) {
        PustakawanModel pustakawanModel = pustakawanService.getPustakawanByNIP(pustakawanNip);

        model.addAttribute("pustakawan", PustakawanServiceImpl.parsePustakawanModel(pustakawanModel));
        return "view-pustakawan";
    }

    @RequestMapping(value="/pustakawan/update/{pustakawanNip}", method=RequestMethod.GET)
    public String updatePustakawanFormPage(
        @PathVariable String pustakawanNip,
        Model model
    ) {
        PustakawanModel pustakawanModel = pustakawanService.getPustakawanByNIP(pustakawanNip);

        model.addAttribute("pustakawan", pustakawanModel);
        return "form-update-pustakawan";
    }

    @RequestMapping(value="/pustakawan/update/{pustakawanNip}", method=RequestMethod.POST)
    public String updatePustakawanFormSubmit(
        @PathVariable String pustakawanNip,
        @ModelAttribute PustakawanModel pustakawan,
        Model model
    ) {
        PustakawanModel updatedPustakawan = pustakawanService.changePustakawan(pustakawan, pustakawanNip);

        model.addAttribute("pustakawan", PustakawanServiceImpl.parsePustakawanModel(updatedPustakawan));
        return "update-pustakawan";
    }
}