package apap.uts.service;

import apap.uts.model.PustakawanModel;

import java.util.List;

public interface PustakawanService {
    void addPustakawan(PustakawanModel pustakawan);
    void deletePustakawan(PustakawanModel pustakawan);
    PustakawanModel changePustakawan(PustakawanModel pustakawan, String targetNip);
    PustakawanModel getPustakawanById(Integer pustakawanId);
    PustakawanModel getPustakawanByNIP(String pustakawanNip);
    List<PustakawanModel> getListPustakawan();
}