package util;

import com.google.common.truth.Truth;

import org.junit.Test;

public class TesterTest {


    @Test
    public void test() {
        Truth.assertThat(1 + 2).isEqualTo(3);
    }


}