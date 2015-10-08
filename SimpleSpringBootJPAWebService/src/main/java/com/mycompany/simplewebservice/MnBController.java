/**
 * *************************************************************************
 *
 * Filename : MnBController.java 
 * Language : Java 2 v1.7
 * Purpose : Controller class (as in Model View Controller) where HTTP 
 * requests are serviced. This uses a Thymeleaf template, jobtypes.html.
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 * Author   Date        Changes 
 * sparry   2014-09-17  Initial Implementation
 *
 ****************************************************************************
 */
package com.mycompany.simplewebservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//basic Spring controller
@Controller
public class MnBController {

  //created automatically
  @Autowired
  private JobTypeRepository repository;

  //... and a GET root call comes in here
  @RequestMapping("/")
  public String main(Model model) {
    List<JobType> jobTypeList = new ArrayList<JobType>();
    //load all the records from database via the Spring Data repository
    jobTypeList.addAll((Collection<? extends JobType>) repository.findAll());
    //add the job type list to the template a.k.a. the model
    model.addAttribute("allJobTypes", jobTypeList.toArray(new JobType[0]));
    return "jobtypes";
  }

}
