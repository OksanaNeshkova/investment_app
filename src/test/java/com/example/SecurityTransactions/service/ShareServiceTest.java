package com.example.SecurityTransactions.service;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.repo.EmployeeRepository;
import com.example.SecurityTransactions.repo.ShareRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ShareServiceTest {

    @Mock
    private ShareRepository shareRepository;
    @InjectMocks
    private ShareService underTest;

    @BeforeEach
    void setup(){
        underTest = new ShareService(shareRepository);
    }
    @Test
    void findAllShare() {
        underTest.findAllShare();
        verify(shareRepository).findAll();
    }

    @Test
    void addShare() {
        Share testShare = new Share(1L, "CompanyName",
                "ShareName", "AAPL", "US",
                "Technology", "USD", new ArrayList<>());
        underTest.addShare(testShare);
        ArgumentCaptor<Share> shareArgumentCaptor = ArgumentCaptor.forClass(Share.class);
        verify(shareRepository).save(shareArgumentCaptor.capture());
        Share capturedShare = shareArgumentCaptor.getValue();

        assertThat(capturedShare).isEqualTo(testShare);
    }

    @Test
    void updateShare() {

    }

    @Test
    void findByTransactionId() {
    }

    @Test
    void getBookPrice() {
    }

    @Test
    void getCurrentBalance() {
    }
}