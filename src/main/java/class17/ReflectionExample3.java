package class17;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Custom annotation for marking methods as tasks
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String name() default "";
}

class TaskManager {
    // Custom method-level annotation
    @TaskInfo(name = "Task 1")
    public void performTask1() {
        System.out.println("Task 1 executed.");
    }

    // Custom method-level annotation
    @TaskInfo(name = "Task 2")
    public void performTask2() {
        System.out.println("Task 2 executed.");
    }

    // A method without the annotation
    public void nonTaskMethod() {
        System.out.println("This method is not a task.");
    }
}

public class ReflectionExample3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        // Create an instance of the TaskManager class
        TaskManager taskManager = new TaskManager();

        // Use reflection to discover and execute annotated tasks
        Class<?> taskManagerClass = taskManager.getClass();
        for (Method method : taskManagerClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                String taskName = taskInfo.name();
                System.out.println("Executing task: " + taskName);
                method.invoke(taskManager);
            }
        }
    }
}
