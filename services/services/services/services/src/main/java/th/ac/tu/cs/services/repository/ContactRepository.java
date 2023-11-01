package th.ac.tu.cs.services.repository;
import th.ac.tu.cs.services.model.contact;

import java.util.List;

public interface ContactRepository {
    int save(contact customer);

    contact findById(String id);

    List<contact> findAll();

    int deleteById(String id);

    int deleteAll();

    int update(contact customer);
}
