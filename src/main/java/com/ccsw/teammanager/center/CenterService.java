package com.ccsw.teammanager.center;

import java.util.List;

import com.ccsw.teammanager.center.model.CenterEntity;

public interface CenterService {

    /**
     * Método para recuperar todos los centros
     *
     * @return {@link List} de {@link CenterEntity}
     */
    List<CenterEntity> findAll();
}
