package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;

public interface ICustomerService extends IGenerateService<Customer> {

    /*TODO:
     *   Chuyển data type return của findAll() từ Iterable<Customer> thành       Page<Customer>:
     * Đối tượng Pageable: là một đối tượng có chứa 3 thuộc tính cơ bản:
            page: chỉ định số trang hiện tại
            size: số lượng phần tử trong trang
           sort: sắp xếp trang
            Pageable sẽ được tự động ánh xạ tư request.
           Lưu ý: import đúng lớp Pageable từ thư viện
            org.springframework.data.domain.Pageable.
            Page<> là đối tượng chứa danh sách các
            *thực thể và thuộc tính của trang.
            * Page<> được trả về trong response.
     * */
    Iterable<Customer> findAllByProvince(Province province);


    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(Pageable pageable, String name);
}
