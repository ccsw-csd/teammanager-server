package com.ccsw.teammanager.centerWithFestives;

import java.util.List;

import com.ccsw.teammanager.centerWithFestives.model.CenterWithFestivesEntity;

public interface CenterWithFestivesService {

    /**
     * Método para recuperar todos los centros y sus festivos
     *
     * @return {@link List} de {@link CenterWithFestivesEntity}
     */
    List<CenterWithFestivesEntity> findAll();
}
