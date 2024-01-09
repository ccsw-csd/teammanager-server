package com.ccsw.teammanager.centerFestive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.centerFestive.model.CenterFestiveDto;
import com.ccsw.teammanager.centerFestive.model.CenterFestiveEntity;
import com.ccsw.teammanager.config.mapper.BeanMapper;

@RequestMapping(value = "/festive")
@RestController
@CrossOrigin(origins = "*")
public class CenterFestiveController {

    @Autowired
    private CenterFestiveService centerFestiveService;

    @Autowired
    private BeanMapper beanMapper;

    /**
     * Método para recuperar todos los festivos
     *
     * @return {@link List} de {@link CenterFestiveDto}
     */

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CenterFestiveDto> findAll(@RequestParam(name = "center_id", required = false) Long centerId) {

        List<CenterFestiveEntity> festiveList;

        if (centerId != null) {
            festiveList = centerFestiveService.findByCenterId(centerId);
        } else {
            festiveList = centerFestiveService.findAll();
        }

        return this.beanMapper.mapList(festiveList, CenterFestiveDto.class);
        // return this.beanMapper.mapList(this.centerFestiveService.findAll(),
        // CenterFestiveDto.class);
    }

    /**
     * @param data
     * @return
     */
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public CenterFestiveDto save(@RequestBody CenterFestiveDto data) {

        return this.beanMapper.map(this.centerFestiveService.save(data), CenterFestiveDto.class);
    }

    /**
     * Método para borrar un {@link CenterFestiveEntity}
     *
     * @param id PK del festivo
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {

        this.centerFestiveService.delete(id);
    }

}
