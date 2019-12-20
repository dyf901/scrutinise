package com.zty.scrutinise.service;

import com.zty.scrutinise.dao.RegistrationDao;
import com.zty.scrutinise.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RegistartionService implements RegistrationDao {
    @Autowired
    private RegistrationDao registrationDao;

    //员工签到
    public int add_registartion(Registration registration){
        return registrationDao.add_registartion(registration);
    }

    //员工签退
    public int upd_registartion(Registration registration){
        return registrationDao.upd_registartion(registration);
    }

    @Override
    public Registration find_id(int id) {
        return registrationDao.find_id(id);
    }

    @Override
    public List<Registration> find_bystate(Map map) {
        return registrationDao.find_bystate(map);
    }
}
