package com.example.gms.adminanduser.service;

import java.util.List;

import com.example.gms.adminanduser.dao.BatchDAOImpl;
import com.example.gms.adminanduser.dao.IBatchDAO;
import com.example.gms.model.Batch;

public class BatchServiceImpl implements IBatchService {

	// fields
	private IBatchDAO batchDao;

	// constructors --special method for instantiating an object
	public BatchServiceImpl() {
		batchDao = new BatchDAOImpl();
	}

	@Override
	public Batch getBatch(long id) {
		// TODO Auto-generated method stub
		return batchDao.get(id);
	}

	@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBatch(Batch object) {
		// TODO Auto-generated method stub
		batchDao.save(object);

	}

	@Override
	public void updateBatch(Batch object) {
		// TODO Auto-generated method stub
		batchDao.update(object);

	}

	@Override
	public void deleteBatch(long id) {
		// TODO Auto-generated method stub

	}

}