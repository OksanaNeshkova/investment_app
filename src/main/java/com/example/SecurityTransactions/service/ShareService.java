package com.example.SecurityTransactions.service;

import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.repo.ShareRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShareService {
    private final ShareRepository shareRepository;

    @Autowired
    public ShareService(ShareRepository shareRepository) {
        this.shareRepository = shareRepository;
    }

    public List<Share> findAllShare() {
        return shareRepository.findAll();
    }

    public Share addShare(Share share) {
        return shareRepository.save(share);
    }

    public Share updateShare(Share share) {
        return shareRepository.save(share);
    }

    public Share findByTransactionId (Long transactionId){
        List<Share>shares = shareRepository.findAll();
        Optional<Share> optionalShare = shares.stream()
                .filter(share -> share.getStockTransactions().stream()
                        .anyMatch(transaction -> transaction.getId().equals(transactionId)))
                .findFirst();
        return optionalShare.orElse(null);
    }
}
