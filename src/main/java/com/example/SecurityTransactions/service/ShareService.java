package com.example.SecurityTransactions.service;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.repo.ShareRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ShareService {
    private final ShareRepository shareRepository;

    @Autowired
    public ShareService (ShareRepository shareRepository){
        this.shareRepository = shareRepository;
    }

    public List<Share> findAllShare() {
        return shareRepository.findAll();
    }
    public Share addShare(Share share){
        return shareRepository.save(share);
    }
}
