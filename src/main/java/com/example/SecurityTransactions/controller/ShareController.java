package com.example.SecurityTransactions.controller;

import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.entity.Transaction;
import com.example.SecurityTransactions.service.ShareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {
    private final ShareService shareService;

    public ShareController(ShareService shareService) {
        this.shareService = shareService;
    }

    @GetMapping("/all")
    public List<Share> getAllShares() {
        return shareService.findAllShare();
    }

    @PostMapping("/add")
    public void addShare(@RequestBody Share share) {
        shareService.addShare(share);
    }

    @PutMapping("/update")
    public Share updateShare(@RequestBody Share theShare) {
        Share updatedShare = shareService.updateShare(theShare);
        return updatedShare;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Share> getShareByTransactionId(@PathVariable("id") Long id) {
        Share foundShare = shareService.findByTransactionId(id);
        return new ResponseEntity<>(foundShare, HttpStatus.OK);
    }

}