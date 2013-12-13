package com.coworking.dao;

import java.util.List;




import com.coworking.domain.Solicitud_cita;




public interface Solicitud_citaDao {
public void saveSolicitud_cita ( Solicitud_cita solicitud_cita );
public List<Solicitud_cita> getSolicitud_cita();
public Solicitud_cita getSolicitud_cita(int idSolicitud);
}

