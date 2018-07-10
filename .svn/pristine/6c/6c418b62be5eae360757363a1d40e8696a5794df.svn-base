package top.rzclk.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.rzclk.modules.test.dao.TestDao;
import top.rzclk.modules.test.entity.TestEntity;
import top.rzclk.modules.test.service.TestService;

@Service("TestService")
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDao TestDao;

	@Override
	public PageInfo<TestEntity> findList() {
		PageHelper.startPage(1, 3);
		List<TestEntity> findList = TestDao.FindList();
		PageInfo<TestEntity> pageInfo = new PageInfo<TestEntity>(findList);
		return pageInfo;
	}

}
