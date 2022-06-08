package vn.fis.training;


import vn.fis.training.domain.Customer;
import vn.fis.training.domain.CustomerStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerManagementApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Fis Java Training Course!" );
    }
    // TODO: Implement method to test all CustomerService
    CustomerStatus cs1 = CustomerStatus.ACTIVE;
    CustomerStatus cs2 = CustomerStatus.INACTIVE;
    Customer c1 = new Customer("01","Hoang", LocalDate.now(),"000",cs1,LocalDateTime.now());
    Customer c2 = new Customer("02","An", LocalDate.now(),"001",cs2,LocalDateTime.now());
    Customer c3 = new Customer("03","Khanh", LocalDate.now(),"002",cs2,LocalDateTime.now());
}
