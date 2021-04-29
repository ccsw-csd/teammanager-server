package com.capgemini.coedevon.teammanager.centerFestive;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveEntity;
import com.capgemini.coedevon.teammanager.centerFestive.model.CenterFestiveSaveDto;

/**
 *
 */
@Service
public class CenterFestiveServiceImpl implements CenterFestiveService {

  @Autowired
  CenterFestiveRepository centerFestiveRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<CenterFestiveEntity> find(long centerId, int year) {

    return this.centerFestiveRepository.findAllByCenterIdAndYear(centerId, year);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void save(CenterFestiveSaveDto dto) {

    int year = dto.getYear();
    long centerId = dto.getCenterid();
    List<Date> dates = dto.getDates();

    this.centerFestiveRepository.deleteAllByCenterIdAndYear(centerId, year);

    for (int i = 0; i < dates.size(); i++) {
      CenterFestiveEntity festivo = new CenterFestiveEntity();
      festivo.setCenterId(centerId);
      festivo.setDate(dates.get(i));
      festivo.setYear(year);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(dates.get(i));
      festivo.setMonth(calendar.get(Calendar.MONTH) + 1);
      this.centerFestiveRepository.save(festivo);
    }

  }
}
