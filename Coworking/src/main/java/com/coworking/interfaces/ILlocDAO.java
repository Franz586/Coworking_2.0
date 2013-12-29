package com.coworking.interfaces;

import java.util.List;

import com.coworking.domain.Lloc;

public interface ILlocDAO {

	public void saveLloc(Lloc lloc);
	public List<Lloc> getLloc();
}
