package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ComponentMapper;
import ir.kamalkarimi.warehousing.repository.ComponentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentService {

    private final ComponentMapper componentMapper;

    private final ComponentManager componentManager;

    @Autowired
    public ComponentService(ComponentMapper componentMapper, ComponentManager componentManager) {
        this.componentMapper = componentMapper;
        this.componentManager = componentManager;
    }

}
