package com.capgemini.coedevon.teammanager.releasenote;

import java.util.List;

import com.capgemini.coedevon.teammanager.releasenote.model.ReleaseNoteEntity;

public interface ReleaseNoteService {

  List<ReleaseNoteEntity> findNewReleases();

}
