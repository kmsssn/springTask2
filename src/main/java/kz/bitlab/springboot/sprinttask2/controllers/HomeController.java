package kz.bitlab.springboot.sprinttask2.controllers;

import kz.bitlab.springboot.sprinttask2.entities.ApplicationRequests;
import kz.bitlab.springboot.sprinttask2.services.RequestService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RequestService requestService;

    @GetMapping(value = "/")
    public String indexPage(Model model){
        List<ApplicationRequests> applicationRequestsList=requestService.getAllItems();
        model.addAttribute("request", applicationRequestsList);
        return "index";
    }

    @GetMapping(value = "/add")
    public String addRequest(){
        return "addRequest";
    }

    @PostMapping(value="/addSuccess")
    public String addSuccess(ApplicationRequests applicationRequests){
        requestService.addReq(applicationRequests);
        return "redirect:/";
    }

    @GetMapping(value="/details/{idReq}")
    public String detailsPage(Model model, @PathVariable(name="idReq") Long id){
        ApplicationRequests request=requestService.getReqById(id);
        model.addAttribute("request", request);
        return "details";
    }

    @PostMapping(value="/updateReq")
    public String updateReq(@RequestParam(name = "id", defaultValue = "0") Long id,
                            @RequestParam(name="userName", defaultValue = "Not founded") String userName,
                            @RequestParam(name = "courseName", defaultValue = "0") String courseName,
                            @RequestParam(name="phone", defaultValue = "0") String phone,
                            @RequestParam(name = "commentary", defaultValue = "0") String commentary,
                            @RequestParam(name="handled", defaultValue = "0") boolean handled){
        ApplicationRequests applicationRequests=requestService.getReqById(id);
        if(applicationRequests!=null){
            applicationRequests.setUserName(userName);
            applicationRequests.setCourseName(courseName);
            applicationRequests.setPhone(phone);
            applicationRequests.setCommentary(commentary);
            applicationRequests.setHandled(handled);
            requestService.updateReq(applicationRequests);
        }
        return "redirect:/";
    }

    @GetMapping("/delReq/{id}")
    public String deleteReq(@PathVariable("id") Long requestId) {
        ApplicationRequests request = requestService.getReqById(requestId);
        if (request != null) {
            requestService.deleteReq(request);
        }
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newReq(Model model){
        List<ApplicationRequests> newRequests=requestService.getReqByBool(true);

        model.addAttribute("newRequests", newRequests);
        return "newReqs";
    }
    
    @GetMapping("/checked")
    public String checkedReq(Model model){
        List<ApplicationRequests> checkedRequest=requestService.getReqByBool(false);

        model.addAttribute("checkedRequest", checkedRequest);

        return "checkedReqs";
    }
}
