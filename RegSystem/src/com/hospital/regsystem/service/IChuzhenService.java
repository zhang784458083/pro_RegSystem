/**
 * @author         zchangyu
 * @Date           2018年5月4日 下午6:00:14
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.service;

import java.util.List;

import com.hospital.regsystem.pojo.Chuzhen;

public interface IChuzhenService {
	public List<Chuzhen> select();
	public Chuzhen selectByVid(int vid);
	public void updateByVid(int vid,String starttime,String endtime,int canregis,int maxregis);
	public void addChuzhen(int did,int oid,String starttime,String endtime,int maxregis);
	public List<Chuzhen> findChuzhen(String startime, String endtime, String dname, Integer oid);
	public List<Chuzhen> selectBy(String oname, String dname);
	public List<Chuzhen> selectByOD(String starttime, String endtime, String oname, String dname);
}
