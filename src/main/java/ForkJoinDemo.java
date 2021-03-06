package main.java;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
 
public class ForkJoinDemo
{
   public static void main(String[] args)
   {
      ForkJoinPool pool = new ForkJoinPool();
//      /home/aagam/IdeaProjects/TestThread/src/main/java/FolderProcessor.java
      FolderProcessor system = new FolderProcessor("/home/aagam", "log");
//      FolderProcessor apps = new FolderProcessor("C/home/aagam/IdeaProjects", "log");
//      FolderProcessor documents = new FolderProcessor("home/aagam", "log");
      pool.execute(system);
//      pool.execute(apps);
//      pool.execute(documents);
      do
      {
         System.out.printf("******************************************\n");
         System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
         System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
         System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
         System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
         System.out.printf("******************************************\n");
         try
         {
            TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      } while ((!system.isDone()));
      pool.shutdown();
      List<String> results;
      results = system.join();
      System.out.printf("System: %d files found.\n", results.size());
   }
}