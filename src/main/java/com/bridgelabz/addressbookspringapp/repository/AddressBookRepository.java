package com.bridgelabz.addressbookspringapp.repository;

import com.bridgelabz.addressbookspringapp.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<ContactData,Integer> {
    @Query(value = "select * from contact_data order by city ",nativeQuery = true)
    List<ContactData> sortByCity();
    @Query(value = "select * from contact_data order by state",nativeQuery = true)
    List<ContactData> sortByState();
}
