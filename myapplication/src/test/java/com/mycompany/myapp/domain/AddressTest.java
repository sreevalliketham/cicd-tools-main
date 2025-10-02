package com.mycompany.myapp.domain;

import static com.mycompany.myapp.domain.AddressTestSamples.*;
import static com.mycompany.myapp.domain.AddressTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Address.class);
        Address address1 = getAddressSample1();
        Address address2 = new Address();
        assertThat(address1).isNotEqualTo(address2);

        address2.setId(address1.getId());
        assertThat(address1).isEqualTo(address2);

        address2 = getAddressSample2();
        assertThat(address1).isNotEqualTo(address2);
    }

    @Test
    void onetooneTest() throws Exception {
        Address address = getAddressRandomSampleGenerator();
        Address addressBack = getAddressRandomSampleGenerator();

        address.setOnetoone(addressBack);
        assertThat(address.getOnetoone()).isEqualTo(addressBack);

        address.onetoone(null);
        assertThat(address.getOnetoone()).isNull();
    }

    @Test
    void addressTest() throws Exception {
        Address address = getAddressRandomSampleGenerator();
        Address addressBack = getAddressRandomSampleGenerator();

        address.addAddress(addressBack);
        assertThat(address.getAddresses()).containsOnly(addressBack);
        assertThat(addressBack.getOnetoone()).isEqualTo(address);

        address.removeAddress(addressBack);
        assertThat(address.getAddresses()).doesNotContain(addressBack);
        assertThat(addressBack.getOnetoone()).isNull();

        address.addresses(new HashSet<>(Set.of(addressBack)));
        assertThat(address.getAddresses()).containsOnly(addressBack);
        assertThat(addressBack.getOnetoone()).isEqualTo(address);

        address.setAddresses(new HashSet<>());
        assertThat(address.getAddresses()).doesNotContain(addressBack);
        assertThat(addressBack.getOnetoone()).isNull();
    }
}
