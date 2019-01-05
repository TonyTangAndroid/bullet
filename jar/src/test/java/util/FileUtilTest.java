package util;

import com.google.common.truth.Truth;

import org.junit.Test;

import io.github.android.tang.tony.test.util.TestUtil;

public class FileUtilTest {

    @Test
    public void content() {

        Truth.assertThat(TestUtil.content("2.txt", this)).isEqualTo("{\"key\": 1}");

    }
}