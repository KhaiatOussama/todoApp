package com.app.demo.Task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {



    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addNewTask(Task task) {
        Optional<Task> taskOptional = taskRepository
                .findTaskByTitle(task.getTitle());
        if (taskOptional.isPresent()){
            throw  new IllegalStateException("Task taken");
        }
        taskRepository.save(task);
    }

    public List<Task> getTask(){
        return taskRepository.findAll();
    }

    public void deleteTask(long taskId) {
        boolean exist = taskRepository.existsById(taskId);
        if(!exist){
            throw new IllegalStateException(
                    "Task with id" + taskId + " does not exists"
            );
        }
        taskRepository.deleteById(taskId);
    }
    @Transactional
    public void updateTask(Long taskId,
                           String title,
                           String description)
    {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException(
                        "Task with Id " + taskId + " does not exist"
                ));
        if (title!= null && !Objects.equals(task.getTitle(), title)
            && title.length() > 0){

            Optional<Task> taskOptional = taskRepository
                    .findTaskByTitle(title);
            if(taskOptional.isPresent()){
                throw new IllegalStateException("Task token");
            }
            task.setTitle(title);
        }
    }
}
