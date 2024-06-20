package vn.codegym.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Province;
import vn.codegym.repository.IProvinceRepository;
import vn.codegym.service.IProvinceService;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public Optional<Province> findById(Long id) {
        /*TODO:
         *   Thay vi tra ve mot doi tuong,
         *   thi CRUD interface tra ve ket
         *  qua la 1 Optional -> phai .get()
         *   de lay doi tuong Generic
         *   - self-note
         * */
        return iProvinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }
}
