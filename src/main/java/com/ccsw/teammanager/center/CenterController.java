package com.ccsw.teammanager.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.center.model.CenterDto;
import com.ccsw.teammanager.config.mapper.BeanMapper;

@RequestMapping(value = "/center")
@RestController
@CrossOrigin(origins = "*")
public class CenterController {

    @Autowired
    private CenterService centerService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * Método para recuperar todos los centros
     *
     * @return {@link List} de {@link CenterDto}
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CenterDto> findAll() {

        return this.beanMapper.mapList(this.centerService.findAll(), CenterDto.class);
    }

}
