/**
 * 
 */
package com.javed.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javed.dto.MongoUser;

/**
 * @author Mohd Javed
 *
 */
@Repository
public interface MongoUserRepository extends MongoRepository<MongoUser, Integer> {
	
}
