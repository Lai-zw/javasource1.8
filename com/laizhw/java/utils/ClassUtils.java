package utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * TODO
 *
 * @author : LaiZhw
 * @version : v1.0
 * @className : ClassUtils
 */
public class ClassUtils {
    public static List<Class<?>> getAllClassesByInterface(Class<?> clazz) {
        // 返回结果
        ArrayList<Class<?>> returnClassList = new ArrayList<>();
        if (clazz.isInterface()) {
            // 获取当前包名
            String packageName = clazz.getPackage().getName();
            try {
                ArrayList<Class<?>> allClasses = getClasses(packageName);
                for (Class<?> allClass : allClasses) {
                    if (clazz.isAssignableFrom(allClass)) {
                        // 判断是不是一个接口
                        if (!clazz.equals(allClass)) {
                            // 本身不加进去
                            returnClassList.add(allClass);
                        }
                    }
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return returnClassList;
    }

    private static ArrayList<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replaceAll("\\.", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;

    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." +
                        file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}