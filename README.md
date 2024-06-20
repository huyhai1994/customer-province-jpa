# [Thực hành] Ứng dụng Quản lý khách hàng: Quản lý tỉnh (v.2023)

## Mục tiêu

      - Luyện tập sử dụng Spring Data Repository.

## Điều kiện

      - Có hiểu biết căn bản và sử dụng được ORM, JPA

## Mô tả

      - Trong phần này, chúng ta sẽ triển khai tầng repository bằng cách sử dụng Spring Data Repository.
      - Đồng thời bổ sung một số tính năng như:
      - Quản lý tỉnh thành của khách hàng
      - Hiển thị khách hàng theo từng tỉnh thành

# Bước thực hiện:

## Bước 1: Tạo dự án và đặt tên customer-province-management

## Bước 2: Bổ sung thư viện và một số lưu ý ở tầng repository

      -Các thư viện sử dụng như ở các phần repository trước.
      -Trong file AppConfiguration, bổ sung annotation @EnableJpaRepositories("com.codegym.repository"), nhằm đánh dấu các file trong package repository là các bean thay vì khai báo từng bean lần lượt.
      - Cấu trúc các file trong repository:
          Interface ICustomerRepository kế thừa CrudRepository<T, ID>. Trong đó, T là entity đang thực hiện truy vấn, ID là kiểu dữ liệu của khóa chính tương ứng trong entity.
      Thay đổi kiểu trả về ở 1 số phương thức: findAll() từ List<> thành Iterable<>, findById() từ Customer thành Optional<Customer>. Chỉnh sửa này nhằm phù hợp với hỗ trợ từ CrudRepository<T, ID- Quản lý tỉnh thành tương tự như quản lý khách hàng. Bao gồm:
    - Entity Province
    - Interface IProvinceRepository
    - ProvinceService
    - ProvinceController
    - Và các view cho thực thể Province: list, create, update,...>.
    Thêm annotation @Repository để đánh dấu bean cho các interface trong package repository.

## Bước 3: Tạo các file để quản lý tỉnh thành

     - Quản lý tỉnh thành tương tự như quản lý khách hàng. Bao gồm:
     - Entity Province
     - Interface IProvinceRepository
     - ProvinceService
     - ProvinceController
     - Và các view cho thực thể Province: list, create, update,...

## Bước 4: Xây dựng fommater cho Province

    - Để hỗ trợ DataBinding từ view, cần xây dựng lớp ProvinceFormatter để chuyển từ id của province thành đối tượng Province và ngược lại.

## Bước 5: Hoàn thiện các controller

## Bước 6: Hoàn thiện các view của dự án

