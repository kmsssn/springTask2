package kz.bitlab.springboot.sprinttask2.repositories;

import kz.bitlab.springboot.sprinttask2.entities.ApplicationRequests;
import kz.bitlab.springboot.sprinttask2.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<ApplicationRequests, Long> {

    List<ApplicationRequests> findAll();
    ApplicationRequests findAllById(Long id);
    List<ApplicationRequests> findAllByHandledEquals(boolean handled);

}
