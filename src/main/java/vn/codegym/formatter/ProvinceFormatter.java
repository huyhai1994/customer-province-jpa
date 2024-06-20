package vn.codegym.formatter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import vn.codegym.model.Province;
import vn.codegym.service.IProvinceService;

import java.util.Locale;
import java.util.Optional;

/*TODO: Bước 4: Xây dựng fommater cho Province
    - Để hỗ trợ DataBinding từ view, cần xây dựng lớp ProvinceFormatter để chuyển từ id của province
        thành đối tượng Province và ngược lại.

- Lớp ProvinceFormatter:*/
public class ProvinceFormatter implements Formatter<Province> {

    private final IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) {
        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
