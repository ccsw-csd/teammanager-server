package com.ccsw.teammanager.centerFestive;

import java.util.List;

import com.ccsw.teammanager.centerFestive.model.CenterFestiveDto;
import com.ccsw.teammanager.centerFestive.model.CenterFestiveEntity;

public interface CenterFestiveService {

    /**
     * Método para recuperar todos los festivos
     *
     * @return {@link List} de {@link CenterFestiveEntity}
     */
    List<CenterFestiveEntity> findAll();

    /**
     * Método para recuperar todos los festivos de un centro mediante su ID
     *
     * @return {@link List} de {@link CenterFestiveEntity}
     */
    List<CenterFestiveEntity> findByCenterId(Long centerId);

    /**
     * Método para almacenar un nuevo festivo
     * 
     * @param data
     * @return
     */
    CenterFestiveEntity save(CenterFestiveDto data);

    /**
     * Método para eliminar un festivo
     * 
     * @param data
     * @return
     */
    void delete(Long id) throws Exception;
}
