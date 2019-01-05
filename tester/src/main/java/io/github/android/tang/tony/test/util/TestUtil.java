package io.github.android.tang.tony.test.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestUtil {

    public static File file(String fileName, Object obj) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        assert classLoader != null;
        URL resource = classLoader.getResource(fileName);
        assert resource != null;
        return new File(resource.getPath());
    }

    public static String content(String filePath, Object obj) {
        return content(filePath, "UTF-8", obj);
    }

    public static String content(String filePath, String encoding, Object obj) {
        try {
            return FileUtils.readFileToString(file(filePath, obj), encoding);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
