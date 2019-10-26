package apap.uts.service;

import apap.uts.model.PustakawanModel;
import apap.uts.repository.PustakawanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService{
    @Autowired
    PustakawanDb pustakawanDb;

    public static Map parsePustakawanModel(PustakawanModel pustakawan) {
        Map<String, String> map = new HashMap<String, String>();
        if(pustakawan == null){
            map.put("id", "");
            map.put("nama", "");
            map.put("nip", "");
            map.put("jenisKelamin", "");
            map.put("tanggalLahir", "");
            map.put("alamat", "");
            map.put("noHp", "");
            map.put("status", "");
            map.put("spesialisasi", "");
        } else {
            map.put("id", pustakawan.getId()+"");
            map.put("nama", pustakawan.getNama());
            map.put("nip", pustakawan.getNip());
            map.put("jenisKelamin", pustakawan.toStringJenisKelamin());
            map.put("tanggalLahir", pustakawan.toStringTanggalLahir());
            map.put("alamat", pustakawan.getAlamat());
            map.put("noHp", pustakawan.getNoHp());
            map.put("status", pustakawan.toStringStatus());
            map.put("spesialisasi", pustakawan.getSpesialisasi());
        }
        return map;
    }

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

    @Override
    public PustakawanModel changePustakawan(PustakawanModel pustakawan, String targetNip) {
        PustakawanModel targetPustakawan = getPustakawanByNIP(targetNip);
        targetPustakawan.setNip(pustakawan.getNip());
        targetPustakawan.setNama(pustakawan.getNama());
        targetPustakawan.setJenisKelamin(pustakawan.getJenisKelamin());
        targetPustakawan.setTanggalLahir(pustakawan.getTanggalLahir());
        targetPustakawan.setAlamat(pustakawan.getAlamat());
        targetPustakawan.setNoHp(pustakawan.getNoHp());
        targetPustakawan.setSpesialisasi(pustakawan.getSpesialisasi());
        targetPustakawan.setStatus(pustakawan.getStatus());

        addPustakawan(targetPustakawan);
        return targetPustakawan;
    }
}
