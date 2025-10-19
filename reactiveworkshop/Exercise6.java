package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import reactor.core.publisher.Mono;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        // TODO: Write code here
    	
    	String value = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        // TODO: Write code here

    	Mono<List<String>> monoList = ReactiveSources.unresponsiveFlux()
    				   .timeout(Duration.ofSeconds(5))
    				   .collectList();
    	monoList.subscribe();
    	
        System.out.println("Press a key to end");
        System.in.read();
    }

}
