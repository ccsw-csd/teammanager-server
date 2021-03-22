package com.capgemini.coedevon.teammanager.grouplist.model;

import org.springframework.data.domain.Pageable;

/**
 * TODO apastorm This type ...
 *
 */
public class GroupListSearchDto {
  private Pageable pageable;

  /**
   * @return pageable
   */
  public Pageable getPageable() {

    return this.pageable;
  }

  /**
   * @param pageable new value of {@link #getpageable}.
   */
  public void setPageable(Pageable pageable) {

    this.pageable = pageable;
  }

}
