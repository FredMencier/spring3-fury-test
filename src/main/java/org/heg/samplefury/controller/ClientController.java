package org.heg.samplefury.controller;

import org.heg.samplefury.service.ClientManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private static final Logger LOG = Logger.getLogger(ClientController.class.getName());

    private final ClientManager clientManager;

    public ClientController(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @GetMapping(path = "/serialize")
    public void getSerializeObject() {
        clientManager.serializeObject();
    }
}
