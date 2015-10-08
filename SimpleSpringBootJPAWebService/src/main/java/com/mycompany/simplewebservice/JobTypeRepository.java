/**
 * *************************************************************************
 *
 * Filename : JobTypeRepository.java 
 * Language : Java 2 v1.7
 * Purpose : Basic Spring data CRUD repository for JobType. 
 * See http://spring.io/guides/gs/accessing-data-jpa/ for a good example
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 * Author   Date        Changes 
 * sparry   2014-09-17  Initial Implementation
 *
 ****************************************************************************
 */
package com.mycompany.simplewebservice;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sparry
 */
public interface JobTypeRepository extends CrudRepository<JobType, Long> {
  
}
