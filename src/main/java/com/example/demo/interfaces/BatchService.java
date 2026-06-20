package com.example.demo.interfaces;


import java.util.List;

import com.example.demo.entity.Batch;

public interface BatchService {

	public void saveBatch(Batch batch);

	public Batch getBatch(int id);

	public List<Batch> getAllBatch();

	public void deleteBatch(int id);
	
	public Batch updateBatch(int id, Batch batch);
}