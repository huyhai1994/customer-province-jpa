package vn.codegym.model;

import javax.persistence.*;

/*
TODO:  - Quản lý tỉnh thành tương tự như quản lý khách hàng. Bao gồm:
     - Entity Province
     - Interface IProvinceRepository
     - ProvinceService
     - ProvinceController
     - Và các view cho thực thể Province: list, create, update,...
* */
@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Province() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}