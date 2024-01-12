package com.ccsw.teammanager.centerWithFestives;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.centerWithFestives.model.CenterWithFestivesDto;
import com.ccsw.teammanager.config.mapper.BeanMapper;

@RequestMapping(value = "/v_center_with_festives")
@RestController
@CrossOrigin(origins = "*")
public class CenterWithFestivesController {

    @Autowired
    private CenterWithFestivesService centerWithFestivesService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * Método para recuperar todos los centros y sus festivos
     *
     * @return {@link List} de {@link CenterWithFestivesDto}
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CenterWithFestivesDto> findAll() {

        return this.beanMapper.mapList(this.centerWithFestivesService.findAll(), CenterWithFestivesDto.class);
    }

}
