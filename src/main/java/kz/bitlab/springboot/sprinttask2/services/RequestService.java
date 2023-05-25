package kz.bitlab.springboot.sprinttask2.services;

import kz.bitlab.springboot.sprinttask2.entities.ApplicationRequests;

import java.util.List;

public interface RequestService {

    List<ApplicationRequests> getAllItems();
    ApplicationRequests addReq(ApplicationRequests request);
    ApplicationRequests getReqById(Long id);
    ApplicationRequests updateReq(ApplicationRequests request);
    void deleteReq(ApplicationRequests request);
    List<ApplicationRequests> getReqByBool(boolean han);
}
