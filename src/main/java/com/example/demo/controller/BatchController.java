package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Batch;
import com.example.demo.interfaces.BatchService;

@RestController

public class BatchController {

	@Autowired
	BatchService bs;

	@PostMapping("admin/batch")
	ResponseEntity<String> addBatch(@RequestBody Batch batch) {
		bs.saveBatch(batch);
		return new ResponseEntity<String>("batch created", HttpStatus.CREATED);
	}

	@GetMapping("batch/{id}")
	ResponseEntity<Batch> getBatch(@PathVariable int id) {
		bs.getBatch(id);
		return new ResponseEntity<Batch>(HttpStatus.OK);
	}

	@GetMapping("batches")
	ResponseEntity<List<Batch>> getBatches() {
		List<Batch> allBatch = bs.getAllBatch();
		return new ResponseEntity<>(allBatch, HttpStatus.OK);
	}

	@DeleteMapping("admin/batch/{id}")
	ResponseEntity<String> deleteBatch(@PathVariable int id) {
		bs.deleteBatch(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PutMapping("admin/batch/{id}")
	ResponseEntity<String> updateBatch(@PathVariable int id, @RequestBody Batch batch) {
		bs.updateBatch(id, batch);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
