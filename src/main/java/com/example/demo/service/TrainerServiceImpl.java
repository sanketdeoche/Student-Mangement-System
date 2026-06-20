package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Batch;
import com.example.demo.entity.Trainer;
import com.example.demo.exception.TrainerServiceException;
import com.example.demo.interfaces.TrainerService;
import com.example.demo.repository.BatchRepository;
import com.example.demo.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	TrainerRepository tr;

	@Autowired
	BatchRepository br;

	@Override
	public void addTrainer(Trainer trainer) {

		if (tr.existsByTrainerid(trainer.getTrainerid())) {

			throw new TrainerServiceException("Trainer is already present", HttpStatus.CONFLICT);
		}
		tr.save(trainer);
	}

	@Override
	public Trainer getTrainer(int id) {
		if (tr.findById(id).isEmpty()) {
			throw new TrainerServiceException("invalid id", HttpStatus.NOT_FOUND);
		}
		return tr.findById(id).get();
	}

	@Override
	public List<Trainer> getAllTrainer() {
		List<Trainer> all = tr.findAll();
		if (all.isEmpty()) {
			throw new TrainerServiceException("invalid id", HttpStatus.NOT_FOUND);
		}
		return tr.findAll();
	}

	@Override
	public void deleteTrainer(int id) {
		if (tr.findById(id).isEmpty()) {
			throw new TrainerServiceException("Enter the valid id", HttpStatus.NOT_FOUND);

		}
		tr.deleteById(id);
	}

	@Override
	public void assignTrainer(int trainerid, int batchid) {

		// owner

		Trainer trainer2 = tr.findById(trainerid).get();

		Batch batch = br.findById(batchid).get();

		List<Batch> lb = new ArrayList();
		lb.add(batch);

		trainer2.setBatches(lb);

		List<Trainer> lt = new ArrayList();

		batch.setTrainer(lt);

		tr.save(trainer2);
		br.save(batch);

	}

	@Override
	public void updateTrainer(int id, Trainer trainer) {
		if (tr.findById(id).isEmpty()) {
			throw new TrainerServiceException("Enter the valid id", HttpStatus.NOT_FOUND);
		}
		Trainer t = tr.findById(id).get();
		t.setAddress(trainer.getAddress());
		t.setEmail(trainer.getEmail());
		t.setName(trainer.getName());
		t.setExp(trainer.getExp());
		t.setSubject(trainer.getSubject());
		tr.save(t);

	}

}
