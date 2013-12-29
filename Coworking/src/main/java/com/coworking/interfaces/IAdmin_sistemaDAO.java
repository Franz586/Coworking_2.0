package com.coworking.interfaces;
import java.util.List;

import com.coworking.domain.Admin_sistema;


public interface IAdmin_sistemaDAO{
	public void saveAdmin_sistema(Admin_sistema admin_sistema);
	public void addAdmin_sistema(Admin_sistema Admin_sistema);

	public List<Admin_sistema> getAdmin_sistema();
}

