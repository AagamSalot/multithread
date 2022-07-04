package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeoutException;

public class ForkJoinDemo123 {

static int counter=0;
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ABcTest aBcTest = new ABcTest();

            ForkJoinPool pool = new ForkJoinPool();

//        System.out.println("iugtyyt"+pool.invoke(aBcTest));


           pool.execute(aBcTest);
//        pool.shutdown();
//       aBcTest.get();
//        Thread.sleep(4000);
//        if(aBcTest.isDone()) {
//        pool.shutdown();
            System.out.println("return result===" + aBcTest.get());
//        }
    }


}

class ABcTest extends RecursiveTask<List<String>> {




    static int counter = 0;

    static List<String> resultList = new ArrayList<String>();
    @Override
    protected List<String> compute() {
        ABcTest aBcTest = new ABcTest();

        List<ABcTest> subtasks = new ArrayList<ABcTest>();
        if(counter<4) {


            System.out.println("Calling compute method..."+Thread.currentThread().getName());
            subtasks.add(aBcTest);
            System.out.println("subtask size..."+subtasks.size());
            aBcTest.fork();
            counter++;
//            storeResultInList(subtasks, resultList);
            resultList.addAll(Arrays.asList("sdfsf"+counter,"asdsf"+counter));
            return Arrays.asList("sdfsf"+counter,"asdsf"+counter);
        }
        else {
//            storeResultInList(subtasks, resultList);
            resultList.add("else part");
            System.out.println("return size===" + resultList.size());
        }
        storeResultInList(subtasks, resultList);
        System.out.println("final return===="+resultList.size());
        return resultList;
    }

    private void storeResultInList(List<ABcTest> subtasks, List<String> resultList) {
       System.out.println("Calling storeResultInList....");
        System.out.println("Calling storeRe size...."+subtasks.size());
        for(ABcTest aBcTest : subtasks){
//            System.out.println("Joinining==="+aBcTest.join());
            resultList.addAll(aBcTest.join());
        }
    }
}

