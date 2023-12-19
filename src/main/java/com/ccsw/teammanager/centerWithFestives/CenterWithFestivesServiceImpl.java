package com.ccsw.teammanager.centerWithFestives;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.centerWithFestives.model.CenterWithFestivesEntity;

@Service
@Transactional
public class CenterWithFestivesServiceImpl implements CenterWithFestivesService {

    @Autowired
    CenterWithFestivesRepository centerWithFestivesRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CenterWithFestivesEntity> findAll() {

        return (List<CenterWithFestivesEntity>) this.centerWithFestivesRepository.findAll();
    }
}
