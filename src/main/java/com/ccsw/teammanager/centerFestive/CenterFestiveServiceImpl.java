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

        System.out.println("Entro al metodo de insercion");
        CenterFestiveEntity festive = new CenterFestiveEntity();
        festive.setDate(data.getDate());
        festive.setMonth(data.getMonth());
        festive.setYear(data.getYear());
        festive.setCenterId(data.getCenterId());
        System.out.println("-----FESTIVO-----");
        System.out.println("Fecha: " + festive.getDate());
        System.out.println("Anyo: " + festive.getYear());
        System.out.println("Mes: " + festive.getMonth());
        System.out.println("Centro: " + festive.getCenterId());
        return this.centerFestiveRepository.save(festive);
    }
}
