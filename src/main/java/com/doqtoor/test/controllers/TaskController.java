package com.doqtoor.test.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doqtoor.test.exception.RecordNotFoundException;
import com.doqtoor.test.models.Task;
import com.doqtoor.test.repository.TacheRepository;
import com.doqtoor.test.services.TaskService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class TaskController {
    private final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;
    
    @Autowired
     TacheRepository tacheRepository;

    @GetMapping("task")
    public List<Task> getAllEmployees()
    {
       return tacheRepository.findAll();
    }

    @PostMapping("task")
    public void createAndUpdateTask(@RequestBody  Task task)
            throws RecordNotFoundException {
   	
    
        tacheRepository.save(task);
    }


    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable("id") long id)   throws RecordNotFoundException {
    	tacheRepository.deleteById(id);
    }



}
