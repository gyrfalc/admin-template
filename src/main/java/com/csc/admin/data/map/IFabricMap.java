package com.csc.admin.data.map;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.csc.admin.model.Fabric;

public interface IFabricMap {
	public List<Fabric> lstFabric(@Param("langCd") String langCd);
	public Fabric selFabric(Fabric params);
	public void updFabric(Fabric params);
	public void insFabric(Fabric params);
	public void delFabric(Fabric params);
}