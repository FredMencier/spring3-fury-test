package org.heg.samplefury.service;

import org.apache.fury.BaseFury;
import org.heg.samplefury.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ClientManager {

    private static final Logger LOG = Logger.getLogger(ClientManager.class.getName());

    private final BaseFury fury;

    public ClientManager(BaseFury fury) {
        this.fury = fury;
    }

    public void serializeObject() {
        ClientDto clientDto = new ClientDto(1L, "Victor", "Hugo", "France");
        byte[] serializedData = fury.serialize(clientDto);
        LOG.info("Serialized ClientDto: " + new String(serializedData));
    }
}
