package com.ccsw.teammanager.personabsence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.teammanager.personabsence.model.PersonAbsenceDto;
import com.ccsw.teammanager.personabsence.model.UpdateAbsences;

@RequestMapping(value = "/absence")
@RestController
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public boolean update(@RequestBody UpdateAbsences updateAbsences) {

        List<PersonAbsenceDto> vacations = updateAbsences.getVacations();
        List<PersonAbsenceDto> vacationsToDelete = updateAbsences.getVacationsToDelete();

        if (!vacations.isEmpty()) {
            this.absenceService.save(vacations);
        }

        if (!vacationsToDelete.isEmpty()) {
            this.absenceService.delete(vacationsToDelete);
        }

        return true;

    }
}
