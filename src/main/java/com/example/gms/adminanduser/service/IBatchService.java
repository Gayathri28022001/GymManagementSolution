package com.example.gms.adminanduser.service;

import java.util.List;

import com.example.gms.model.Batch;

public interface IBatchService {

	public Batch getBatch(long id);

	public List<Batch> getAllBatches();

	public void saveBatch(Batch object);

	public void updateBatch(Batch object);

	public void deleteBatch(long id);

}
