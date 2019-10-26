package apap.uts.repository;

import apap.uts.model.PustakawanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PustakawanDb extends JpaRepository<PustakawanModel, Integer>{
    PustakawanModel findByNip(String nip);
}