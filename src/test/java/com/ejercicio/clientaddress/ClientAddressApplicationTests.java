package com.ejercicio.clientaddress;

import com.ejercicio.clientaddress.entity.Address;
import com.ejercicio.clientaddress.entity.Client;
import com.ejercicio.clientaddress.repository.ClientRepository;
import com.ejercicio.clientaddress.service.ClientService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class ClientAddressApplicationTests {

	@Autowired
	private ClientService clientService;

	@MockBean
	private ClientRepository clientRepository;

	@BeforeEach
	void setup(){
		Address newAddres = new Address(23,"A","B","C");
		List<Address> addList = new ArrayList<>(Arrays.asList(newAddres));
		Optional<Client> client= Optional.of(new Client(1, "RUC", "8787", "abc", "pin@mail", "4598", "guayakill", "Guayas", "la 8",  addList ));
		Mockito.when(clientRepository.findById(1)).thenReturn(client);

	}
	@Test
	public void testGetClientById(){
		String client_name="abc";
		Client clientById=clientService.getClientById(1);
		Assertions.assertEquals(client_name,clientById.getName());
	}

	@Test
	public void testUpdate(){
		Address newAddres = new Address(23,"A","B","C");
		List<Address> addList = new ArrayList<>(Arrays.asList(newAddres));
		Client clientB= (new Client(1, "RUC", "8787", "abc", "pin@mail", "4598", "guayakill", "Guayas", "la 8",  addList ));
		Client clientById=clientService.updateClient(clientB);
		Assertions.assertNotEquals(clientB,clientById);

	}

//	@Test
//	public void testDelete(){
//		Address newAddres = new Address(23,"A","B","C");
//		List<Address> addList = new ArrayList<>(Arrays.asList(newAddres));
//		Client clientB= (new Client(1, "RUC", "8787", "abc", "pin@mail", "4598", "guayakill", "Guayas", "la 8",  addList ));
//		String clientById=clientService.deleteClient(1);
//		Assertions.assertNull(clientB);
//	}


}
