package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Customer;
import vn.codegym.model.Province;
import vn.codegym.service.ICustomerService;
import vn.codegym.service.IProvinceService;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    public final int MAX_PAGE_NUMBER = 2;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    /*TODO: - Trong lớp CustomerController bổ sung phần code hỗ trợ lấy danh sách tỉnh trong các request tới controller như sau:
            @ModelAttribute
            Để ở ngoài nhằm dùng cho các
            method khác trong controller
            Tránh trùng lặp code.
            Logic của Spring: tiết kiệm
            mã nhất có thể;
     **/
    @ModelAttribute("provinces")
    public Iterable<Province> listProvinces() {
        return provinceService.findAll();
    }

    /*TODO:
             Bước 3: Cập nhật CustomerController
            Phương thức listCustomer() bổ sung tham số
            Pageable, được mapping tự động từ URL.
        * */
    @GetMapping
    public ModelAndView listCustomer(@PageableDefault(value = MAX_PAGE_NUMBER) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        Page<Customer> customers = customerService.findAll(pageable);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create new customer successfully");
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/update");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Update customer successfully");
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/customers";
    }


    @PostMapping("/search")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, @PageableDefault(value = MAX_PAGE_NUMBER) Pageable pageable) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findAllByFirstNameContaining(pageable, search.get());
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}