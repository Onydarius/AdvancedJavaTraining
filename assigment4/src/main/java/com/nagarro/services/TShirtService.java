package com.nagarro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.dao.TShirtDao;
import com.nagarro.model.TShirt;
import com.nagarro.model.User;

@Service
public class TShirtService {
	TShirtDao tShirtDao;

	public TShirtService() {
		tShirtDao = new TShirtDao();
	}

	public List<TShirt> search(String colour, String size, String gender, String outputPreference) {

		return tShirtDao.search(colour, size, gender, outputPreference);
	}

	public void addTShirt(TShirt tShirt) {
		tShirtDao.save(tShirt);
	}

	public List<TShirt> getAllTShirt() {
		return tShirtDao.getAll();
	}

	public Optional<TShirt> getTShirtById(String id) {
		return Optional.of(tShirtDao.getById(id));
	}

	public void deleteTShirt(String id) {
		tShirtDao.deleteById(id);
	}
}
