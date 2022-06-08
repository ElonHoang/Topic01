package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerStatusException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.*;
import java.util.stream.Collectors;

import static jdk.internal.joptsimple.internal.Strings.isNullOrEmpty;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;
    List<SummaryCustomerByAgeDTO> summaryCustomerByAgeDTOList = new ArrayList<>();
    @Override
    public Customer findById(String id){
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if(id == null) throw new CustomerNotFoundException("Id khong hop le");
        return customerStore.findAll().stream().filter(t->id.equals(t.getId())).findFirst().orElseThrow(()-> new CustomerNotFoundException("Id khong ton tai"));
    }

    @Override
    public Customer createCustomer(Customer customer)  {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        validate(customer);
        if(customerStore.findAll().stream()
                                    .filter(t->t.getMobile().equalsIgnoreCase(customer.getMobile()))
                                    .findFirst().isPresent())
                                    new vn.fis.training.exception.DuplicateCustomerException(customer,"Khach hang da ton tai");

        customerStore.insertOrUpdate(customer);
        return customer;
    }
    private void validate(Customer cus){
        if(isNullOrEmpty(cus.getName())){
            throw new DuplicateCustomerException(cus,"Customer name not valid");
        }
        if(isNullOrEmpty(cus.getMobile())){
            throw new DuplicateCustomerException(cus,"Customer mobile not valid");
        }
        if(isNullOrEmpty(cus.getBirthDay().toString())){
            throw new DuplicateCustomerException(cus,"Customer DOB not valid");
        }
        if(isNullOrEmpty(cus.getStatus().toString())){
            throw new DuplicateCustomerException(cus,"Customer Status not valid");
        }
    }


    @Override
    public Customer updateCustomer(Customer customer){

        //TODO: Implement method tho dung dac ta cua CustomerService interface
       validate(customer);
//        customerStore.findAll().forEach(t->{
//           if(t.getMobile() != customer.getMobile()){
//               throw new vn.fis.training.exception.CustomerNotFoundException("Customer khong ton tai");
//           }
//       });
        findById(customerStore.insertOrUpdate(customer).getId());
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if(isNullOrEmpty(id)) throw new  IllegalArgumentException("Id not valid");
//        customerStore.findAll().forEach(t->{
//            if(!t.getId().equals(id) || !t.getStatus().equals("INACTIVE")){
//                throw new InvalidCustomerStatusException(t,"Id khong ton tai hoac yeu cau phai ACTIVE");
//            }
//        });
        findById(id);
        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        List<Customer> rs = customerStore.findAll().stream()
                                                    .sorted(Comparator.comparing(t->t.getName()))
                                                    .collect(Collectors.toList());
        return rs.size() > 0 ? rs : Collections.emptyList();
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        Comparator<Customer> ordAsc = Comparator.comparing(t->t.getName());
        List<Customer> rs = customerStore.findAll().stream()
                                                    .sorted(ordAsc)
                                                    .limit(limit)
                                                    .collect(Collectors.toList());

        return rs.size() > 0 ? rs : Collections.emptyList();
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        Comparator<Customer> ordAsc = Comparator.comparing(t->t.getName());
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        List<Customer> rs = customerStore.findAll().stream()
                                            .filter(t->t.getName().contains(custName))
                                            .limit(Integer.parseInt(limit))
                                            .sorted(ordAsc)
                                            .collect(Collectors.toList());
        return rs.size() > 0 ? rs : Collections.emptyList();
    }

    @Override
    public List<SummaryCustomerByAgeDTO> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        Comparator<SummaryCustomerByAgeDTO> ord = Comparator.comparingInt(t->t.getAge());
        List<SummaryCustomerByAgeDTO> rs = summaryCustomerByAgeDTOList.stream()
                                                                            .sorted(ord.reversed())
                                                                            .collect(Collectors.toList());
        return rs.size() > 0 ? rs : Collections.emptyList();
    }

}
