package vttp.batchb.ssf.day13project;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;

public class Task {

    @NotNull(message = "Task cannot be empty")
    @NotEmpty(message = "Task cannot be empty")
    @Size(min = 2, message = "Task must be more than 2 characters")
    private String name;

    private String priority;
    @NotNull(message = "Date cannot be empty!!!")
    @Future(message = "Please pick a future date")
    private LocalDateTime time;
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPriority() {return priority;}
    public void setPriority(String priority) {this.priority = priority;}
    public LocalDateTime getTime() {return time;}
    public void setTime(LocalDateTime time) {this.time = time;}
    @Override
    public String toString() {
        return "Task [name=" + name + ", priority=" + priority + ", time=" + time + "]";
    }



    
}
