package vn.codegym.model;

import javax.persistence.*;

/*TODO:
*   - Quản lý tỉnh thành tương tự như quản lý khách hàng. Bao gồm:
     - Entity Province
     - Interface IProvinceRepository
     - ProvinceService
     - ProvinceController
     - Và các view cho thực thể Province: list, create, update,...
    - Đồng thời cần bổ sung mối quan hệ liên kết giữa Customer và Province. Vậy nên lớp Customer sẽ thay đổi như sau:
    - Lớp Customer hoàn thiện:
* */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
