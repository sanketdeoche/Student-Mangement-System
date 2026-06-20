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

import com.example.demo.entity.Trainer;
import com.example.demo.interfaces.TrainerService;

@RestController

public class TrainerController {

	@Autowired
	TrainerService ts;

	@PostMapping("admin/trainer")
	public ResponseEntity<String> saveTrainer(@RequestBody Trainer trainer) {

		ts.addTrainer(trainer);

		return new ResponseEntity<>("Trainer Added Successfully", HttpStatus.CREATED);
	}

	// Get Trainer by ID
	@GetMapping("{id}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable int id) {

		Trainer trainer = ts.getTrainer(id);

		return new ResponseEntity<>(trainer, HttpStatus.OK);
	}

	// Get All Trainers
	@GetMapping("all")
	public ResponseEntity<List<Trainer>> getAllTrainer() {

		List<Trainer> trainers = ts.getAllTrainer();

		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	// Delete Trainer
	@DeleteMapping("admin/{id}")
	public ResponseEntity<String> deleteTrainer(@PathVariable int id) {

		ts.deleteTrainer(id);

		return new ResponseEntity<>("Trainer deleted successfully", HttpStatus.OK);
	}

	// Update Trainer
	@PutMapping("admin/{id}")
	public ResponseEntity<String> updateTrainer(@PathVariable int id, @RequestBody Trainer trainer) {

		ts.updateTrainer(id, trainer);

		return new ResponseEntity<String>("Trainer updatad", HttpStatus.OK);

	}

@PostMapping("assignTriners/{trainerid}/{batchid}")
ResponseEntity assignTrinerBatch(  @PathVariable  int trainerid,  @PathVariable int batchid) {
	
	ts.assignTrainer(trainerid, batchid);
	
	return new ResponseEntity("triner is assign ",HttpStatus.OK);
	
}

}




