/**
 * 
 */
package com.javed.service;

import java.util.List;
import java.util.Optional;

import com.javed.dto.MongoUser;

/**
 * @author Mohd Javed
 *
 */
public interface MongoUserService {

	public MongoUser createMongoUser(MongoUser mongoUser);

	public Optional<MongoUser> readMongoUser(String id);

	public MongoUser updateMongoUser(MongoUser mongoUser);

	public void removeMongoUser(Integer id);

	public List<MongoUser> findAll();
}
