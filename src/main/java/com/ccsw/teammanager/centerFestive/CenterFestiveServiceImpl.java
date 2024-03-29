package com.ccsw.teammanager.centerFestive;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.teammanager.centerFestive.model.CenterFestiveDto;
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

    @Override
    @Transactional
    public CenterFestiveEntity save(CenterFestiveDto data) {

        CenterFestiveEntity festive = new CenterFestiveEntity();
        festive.setDate(data.getDate());
        festive.setMonth(data.getMonth());
        festive.setYear(data.getYear());
        festive.setCenterId(data.getCenterId());
        return this.centerFestiveRepository.save(festive);
    }

    @Override
    public void delete(Long id) throws Exception {

        if (this.centerFestiveRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not exists");
        }

        this.centerFestiveRepository.deleteById(id);
    }
}
