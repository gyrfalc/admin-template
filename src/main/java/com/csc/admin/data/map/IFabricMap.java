package com.csc.admin.data.map;

import java.util.List;

import com.csc.admin.model.Fabric;

public interface IFabricMap {
	public List<Fabric> lstFabric();
	public Fabric selFabric(Fabric params);
	public void updFabric(Fabric params);
	public void insFabric(Fabric params);
	public void delFabric(Fabric params);
}