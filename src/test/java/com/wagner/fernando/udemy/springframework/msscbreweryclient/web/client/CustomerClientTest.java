package com.wagner.fernando.udemy.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.wagner.fernando.udemy.springframework.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
public class CustomerClientTest {
	
	@Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
    	CustomerDto dto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void testSaveNewCustomer() {
        //given
    	CustomerDto customerDto = CustomerDto.builder().customerName("James").build();

        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateCustomer() {
        //given
    	CustomerDto customerDto = CustomerDto.builder().customerName("James").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }

}
