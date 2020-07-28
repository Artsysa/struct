package util;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/6/17 17:52
 * @Month:06
 */
public class TaskTime {
    Task task;
    String name;
   public TaskTime(Task task,String name){
        this.task=task;
        this.name=name;
        Task();
    }

    public final void Task()  {
        long start = System.currentTimeMillis();
        task.Task();
        long end = System.currentTimeMillis();
        System.out.println("<"+name+">"+"["+(end-start)/1000f+"s("+(end-start)+"ms)]");
    }

}

