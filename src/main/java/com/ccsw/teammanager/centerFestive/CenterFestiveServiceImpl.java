package com.ccsw.teammanager.centerFestive;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.centerFestive.model.CenterFestiveEntity;

@Service
@Transactional
public class CenterFestiveServiceImpl implements CenterFestiveService {

    @Autowired
    CenterFestiveRepository centerFestiveRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CenterFestiveEntity> findAll() {
        return (List<CenterFestiveEntity>) this.centerFestiveRepository.findAll();
    }

    @Override
    public List<CenterFestiveEntity> findByCenterId(Long centerId) {
        return centerFestiveRepository.findByCenterId(centerId);
    }
}
