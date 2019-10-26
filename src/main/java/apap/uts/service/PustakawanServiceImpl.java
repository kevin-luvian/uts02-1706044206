package apap.uts.service;

import apap.uts.model.PustakawanModel;
import apap.uts.repository.PustakawanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService{
    @Autowired
    PustakawanDb pustakawanDb;

    @Override
    public void addPustakawan(PustakawanModel pustakawan) {
        pustakawanDb.save(pustakawan);
    }

    @Override
    public void deletePustakawan(PustakawanModel pustakawan) {
        pustakawanDb.delete(pustakawan);
    }

    @Override
    public PustakawanModel getPustakawanById(Integer pustakawanId) {
        return pustakawanDb.findById(pustakawanId).get();
    }

    @Override
    public PustakawanModel getPustakawanByNIP(String pustakawanNip) {
        return pustakawanDb.findByNip(pustakawanNip);
    }

    @Override
    public List<PustakawanModel> getListPustakawan() {
        return pustakawanDb.findAll();
    }
}
