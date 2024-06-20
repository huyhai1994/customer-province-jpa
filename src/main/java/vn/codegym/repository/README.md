## Cấu trúc các file trong repository

1. Interface ICustomerRepository kế thừa CrudRepository<T, ID>. Trong đó, T là entity đang thực hiện truy vấn, ID là
   kiểu dữ liệu của khóa chính tương ứng trong entity.
2. Thay đổi kiểu trả về ở 1 số phương thức: findAll() từ List<> thành Iterable<>, findById() từ Customer thành
   Optional<Customer>. Chỉnh sửa này nhằm phù hợp với hỗ trợ từ CrudRepository<T, ID>.
3. Thêm annotation @Repository để đánh dấu bean cho các interface trong package repository.
