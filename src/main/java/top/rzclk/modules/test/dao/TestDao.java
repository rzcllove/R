package top.rzclk.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.rzclk.modules.test.entity.TestEntity;

@Mapper
public interface TestDao {
	
	List<TestEntity> FindList();

}
