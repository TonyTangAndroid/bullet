package io.github.android.tang.tony.test.util;

import com.google.common.reflect.TypeToken;
import com.google.common.truth.Truth;
import com.google.gson.Gson;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TestUtilsTest {

    @Test
    public void content() {


        String json = TestUtil.content("gson.json", this);
        Type type = new TypeToken<Map<String, Integer>>() {
        }.getType();
        Map<String, Integer> t = new Gson().fromJson(json, type);
        Truth.assertThat(t).isEqualTo(expected());

    }

    private Object expected() {
        Map<String, Integer> result = new HashMap<>();
        result.put("key", 1);
        return result;
    }
}