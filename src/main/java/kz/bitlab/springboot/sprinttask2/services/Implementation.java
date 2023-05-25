package kz.bitlab.springboot.sprinttask2.services;

import kz.bitlab.springboot.sprinttask2.entities.ApplicationRequests;
import kz.bitlab.springboot.sprinttask2.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Implementation implements  RequestService{

    @Autowired
    public RequestRepository requestRepository;

    @Override
    public List<ApplicationRequests> getAllItems(){
        return requestRepository.findAll();
    }

    @Override
    public ApplicationRequests addReq(ApplicationRequests request){
        return requestRepository.save(request);
    }

    @Override
    public ApplicationRequests getReqById(Long id){
        return requestRepository.findAllById(id);
    }

    @Override
    public ApplicationRequests updateReq(ApplicationRequests request){
        return requestRepository.save(request);
    }

    @Override
    public void deleteReq(ApplicationRequests request){
        requestRepository.delete(request);
    }

    @Override
    public List<ApplicationRequests> getReqByBool(boolean han){
        return requestRepository.findAllByHandledEquals(han);
    }

}
