package com.csc.admin.data.map;

import java.util.List;

import com.csc.admin.model.FabricFamily;

public interface IFabricFamilyMap {
	public List<FabricFamily> lstFabricFamily();
	public FabricFamily selFabricFamily(FabricFamily params);
	public void updFabricFamily(FabricFamily params);
	public void insFabricFamily(FabricFamily params);
	public void delFabricFamily(FabricFamily params);
}
