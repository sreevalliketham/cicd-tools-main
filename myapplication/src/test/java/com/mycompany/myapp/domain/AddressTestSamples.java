package com.mycompany.myapp.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class AddressTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Address getAddressSample1() {
        return new Address().id(1L).aid("aid1").street("street1").citi("citi1");
    }

    public static Address getAddressSample2() {
        return new Address().id(2L).aid("aid2").street("street2").citi("citi2");
    }

    public static Address getAddressRandomSampleGenerator() {
        return new Address()
            .id(longCount.incrementAndGet())
            .aid(UUID.randomUUID().toString())
            .street(UUID.randomUUID().toString())
            .citi(UUID.randomUUID().toString());
    }
}
