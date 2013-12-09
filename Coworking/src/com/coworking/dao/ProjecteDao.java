package com.coworking.dao;

import java.util.List;




import com.coworking.domain.Projecte;




public interface ProjecteDao {
public void saveProjecte ( Projecte projecte );
public List<Projecte> getProjecte();
}

