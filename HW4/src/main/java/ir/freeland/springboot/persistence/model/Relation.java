package ir.freeland.springboot.persistence.model;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Relation {

    @PersistenceContext
    private EntityManager etityMsnsger;

    @Transactional
    public void sampleRun() {
        Items item = new Items();
        item.setName("rouge");
        item.setCataloge("makeup");
        item.setPrice(429.89);

        Citems corruptedItem = new Citems();
        corruptedItem.setProblem("melted");
        corruptedItem.setName("rouge");
        etityMsnsger.persist(item);

        //find item
        List<Citems> allCorruptedItem = etityMsnsger.createQuery("from CorruptedItem ", Citems.class).getResultList();
        allCorruptedItem.stream().forEach(s -> System.out.println(s));

        //update
        allCorruptedItem.get(0).setProblem("Broken");

    }


}