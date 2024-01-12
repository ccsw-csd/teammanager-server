package com.ccsw.teammanager.center;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.center.model.CenterEntity;

/**
 * @author ccsw
 *
 */
@Service
@Transactional
public class CenterServiceImpl implements CenterService {

    @Autowired
    CenterRepository centerRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CenterEntity> findAll() {

        return (List<CenterEntity>) this.centerRepository.findAll();
    }

}