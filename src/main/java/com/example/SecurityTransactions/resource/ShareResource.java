package com.example.SecurityTransactions.resource;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.service.EmployeeService;
import com.example.SecurityTransactions.service.ShareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareResource {
    private final ShareService shareService;

    public ShareResource (ShareService shareService){
        this.shareService = shareService;
    }
    @GetMapping("/all")
    public List<Share> getAllShares() {
        return shareService.findAllShare();
    }

    @PostMapping("/add")
    public void addShare(@RequestBody Share share){
        shareService.addShare(share);
    }
}