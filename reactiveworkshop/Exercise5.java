package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
    	
    	ReactiveSources.intNumbersFlux().subscribe(num -> System.out.println(num),
    											   err -> System.out.println(err.getMessage()),
    											   () -> System.out.println("complete event of Flux"));
    	ReactiveSources.userMono().subscribe(user -> System.out.println(user),
				   								   err -> System.out.println(err.getMessage()),
				   								   () -> System.out.println("complete event of Mono"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
    	
    	ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
	
	public void hookOnSubscribe(Subscription subscribtion) {
		System.out.println("subscribe happened");
		request(1);
	}
	
	public void hookOnNext(T value) {
		System.out.println(value + " received");
		request(1);
	}
	
}