package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.Trainer;

public interface TrainerService {

	public void addTrainer(Trainer trainer);

	public Trainer getTrainer(int id);

	public List<Trainer> getAllTrainer();

	public void deleteTrainer(int id);
	
	public void updateTrainer(int id, Trainer trainer);
	
	public void assignTrainer(int trainerid, int batchid);
}
