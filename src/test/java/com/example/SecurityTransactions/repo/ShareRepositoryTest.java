package com.example.SecurityTransactions.repo;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.entity.Share;
import jakarta.persistence.Column;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ShareRepositoryTest {
    @Autowired
    private ShareRepository shareRepository;
    @AfterEach
    void tearDown(){
        shareRepository.deleteAll();
    }
    @Test
    public void canFindBySymbol() {
        //Given
        Share share = new Share();
        share.setId(10L);
        share.setCompanyName("Microsoft Corporation");
        share.setShareName("Microsoft");
        share.setSymbol("MSFT");
        share.setCountry("US");
        share.setEconomicField("Technology");
        share.setCurrency("USD");


        //Saving the share to the database
        shareRepository.save(share);

        //When
        String shareSymbol = share.getSymbol();
        Optional<Share> foundShare = shareRepository.findBySymbol(shareSymbol);

        //Then
        assertTrue(foundShare.isPresent());
        assertEquals(share.getSymbol(), foundShare.get().getSymbol());
    }

}