package com.app.demo.Task;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {

        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTask(){
                return taskService.getTask();
    }

    @PostMapping
    public void registerNewTask(@RequestBody Task task){
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(
            @PathVariable("taskId") long taskId){
        taskService.deleteTask(taskId);
    }
    @PutMapping(path = "{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description)
    {
        taskService.updateTask(taskId, title, description);
    }
}
