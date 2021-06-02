package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentManager extends BaseManagerImpl<Component>{

    private final ComponentRepository repository;

    @Autowired
    public ComponentManager(ComponentRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Component> getRepository() {
        return repository;
    }
}
