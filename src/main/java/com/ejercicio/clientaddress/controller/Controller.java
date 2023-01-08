package com.ejercicio.clientaddress.controller;

import com.ejercicio.clientaddress.dto.OrderRequest;
import com.ejercicio.clientaddress.dto.OrderResponse;
import com.ejercicio.clientaddress.entity.Address;
import com.ejercicio.clientaddress.entity.Client;
import com.ejercicio.clientaddress.repository.AddressRepository;
import com.ejercicio.clientaddress.repository.ClientRepository;
import com.ejercicio.clientaddress.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientService clientService;

    //Crear un nuevo cliente
    @PostMapping("/placeAddress")
    public Client placeAddress(@RequestBody OrderRequest request){
        return clientService.addClient(request);
    }


    //Obtener Listado de clientes
    @GetMapping("/findAllClients")
    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }



//    direcciones de todos los clientes
    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInfo(){
        return clientService.getAddresses();
    }


//    direcciones por id
    @GetMapping("/getInfo/{id}")
    public List<OrderResponse> findAddressByClientId(@PathVariable int id){
        return clientRepository.findClientByAddresses(id);
    }

    //borrar por id
    @DeleteMapping("/clientDelete/{id}")
    public String deleteClient(@PathVariable int id){
        return clientService.deleteClient(id);
    }

    //Buscar Cliente por Id
    @GetMapping("/getbyId/{rid}")
    public Client findClientbyId(@PathVariable int rid){
        return clientService.getClientById(rid);
    }

    //Update
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    //ADD NEW ADDRESES
    @PutMapping("/addAddress")
    public Client addNewAddresses(@RequestBody Client client){
        return clientService.addAddresses(client);
    }

    //Find client by name
    @GetMapping("/client/{name}")
    public Client findClientbyName(@PathVariable String name){
        return clientService.findClientbyName(name);
    }
}
