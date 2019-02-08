/**
 * 
 */
package com.javed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javed.dto.MongoUser;
import com.javed.repository.MongoUserRepository;

/**
 * @author Mohd Javed
 *
 */
@Service("mongoUserService")
public class MongoUserServiceImpl implements MongoUserService {
	
	@Autowired
	private MongoUserRepository mongoUserRepository; 

	@Override
	public MongoUser createMongoUser(MongoUser mongoUser) {
		return mongoUserRepository.insert(mongoUser);
	}

	@Override
	public Optional<MongoUser> readMongoUser(String id) {
		return mongoUserRepository.findById(Integer.parseInt(id));
	}

	@Override
	public MongoUser updateMongoUser(MongoUser mongoUser) {
		return mongoUserRepository.save(mongoUser);
	}

	@Override
	public void removeMongoUser(Integer id) {
		mongoUserRepository.deleteById(id);
	}

	@Override
	public List<MongoUser> findAll() {
		return mongoUserRepository.findAll();
	}

}
