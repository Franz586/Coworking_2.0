package com.coworking.dao;

import java.util.List;


import com.coworking.domain.Empresa;




public interface EmpresaDao {
public void saveEmpresa ( Empresa empresa );
public List<Empresa> getEmpresa();
}

