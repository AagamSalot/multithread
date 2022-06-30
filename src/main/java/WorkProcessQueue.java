package main.java;

import reactor.core.publisher.Flux;
import reactor.core.publisher.WorkQueueProcessor;

import java.util.function.Function;

public class WorkProcessQueue {

    public static void main(String[] args) {
        System.out.println("Started.....");
        new WorkProcessQueue().testIt();
    }

    public  void testIt(){
        WorkQueueProcessor workQueueProcessor = WorkQueueProcessor.create();
        Flux flux1 = workQueueProcessor.map(e ->e);
        Flux flux2 = workQueueProcessor.map(e1 -> e1);
        Flux flux3 = workQueueProcessor.map(new Function() {
            @Override
            public Object apply(Object o) {
                return o;
            }
        });

        flux1.subscribe(e -> {
            System.out.println("flux1 subscriber called..: "+e);

//            System.out.println("flux1 subscriber completed..: "+e);
        });
        flux2.subscribe(e1 -> {
            System.out.println("flux2 subscriber called...: "+ e1);
        });
//        flux3.subscribe(e -> {
//            System.out.println("flux3 subscriber called...: "+ e);
//        });

        System.out.println("hello.....");
//        IntStream.range(1,20)
//                .forEach(e -> {
//                    workQueueProcessor.onNext(e);
//                });


        for(int i =0;i<200;i++){
            System.out.println("workQueueProcessor publisher called...: Message "+i);
//            workQueueProcessor.publish();
                workQueueProcessor.onNext("message "+i);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("workQueueProcessor publisher called completed...: Message "+i);
        }
        System.out.println("Count===="+workQueueProcessor.downstreamCount());
        System.out.println("Count===="+workQueueProcessor.downstreamCount());
             workQueueProcessor.onComplete();
//            workQueueProcessor.blockLast();
    }

}
