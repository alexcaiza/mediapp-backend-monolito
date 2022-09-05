package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.VitalSign;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVitalSignRepo;
import com.mitocode.service.IVitalSignService;

@Service
public class VitalSignServiceImpl extends CRUDImpl<VitalSign, Integer> implements IVitalSignService {

    @Autowired
    private IVitalSignRepo repo;

    @Override
    protected IGenericRepo<VitalSign, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<VitalSign> listPage(Pageable page) {
        return repo.findAll(page);
    }

    /*
    public PatientServiceImpl(IPatientRepo repo) {
        this.repo = repo;
    }*/

    /*
    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public Patient findById(Integer id) {
        Optional<Patient> op = repo.findById(id);
        return op.orElseGet(Patient::new);
        //op.isPresent() ? op.get() : new Patient();
    }

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }*/
}
