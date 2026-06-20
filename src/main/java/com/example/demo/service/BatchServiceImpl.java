package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Batch;
import com.example.demo.exception.BatchServiceException;
import com.example.demo.interfaces.BatchService;
import com.example.demo.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchRepository br;

	@Override
	public void saveBatch(Batch batch) {

		if (br.existsByBatchid(batch.getBatchid())) {
			throw new BatchServiceException("Batch is already present", HttpStatus.BAD_REQUEST);
		} else {
			br.save(batch);
		}
	}

	@Override
	public Batch getBatch(int id) {
		if (br.findById(id).isPresent()) {
			return br.findById(id).get();
		} else {
			throw new BatchServiceException(" Batch not found with id " + id, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public List<Batch> getAllBatch() {

		List<Batch> batchList = br.findAll();

		if (batchList != null && !batchList.isEmpty()) {
			return batchList;
		} else {
			throw new BatchServiceException(" No batch records found", HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteBatch(int id) {
		if (br.findById(id).isPresent()) {
			br.deleteById(id);
		} else {
			throw new BatchServiceException("Batch not found with id " + id, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Batch updateBatch(int id, Batch batch) {
		Batch oldBatch = br.findById(id).orElseThrow(()-> new RuntimeException("Batch not found"));
		      oldBatch.setName(batch.getName());
		      oldBatch.setMode(batch.getMode());
		      oldBatch.setTime(batch.getTime());
		      oldBatch.setStartdate(batch.getStartdate());
		      oldBatch.setEnddate(batch.getEnddate());
		      oldBatch.setTrainer(batch.getTrainer());
		      return  br.save(oldBatch);
		
	}

	}
