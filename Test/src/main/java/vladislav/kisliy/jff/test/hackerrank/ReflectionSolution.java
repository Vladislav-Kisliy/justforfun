package vladislav.kisliy.jff.test.hackerrank;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 24.09.19.
 */
public class ReflectionSolution {

    public static void main(String[] args){
        Class student = PersonSolution.class;
        Method[] methods = student.getDeclaredMethods();

        List<String> methodList = new ArrayList<>();
        for(Method method: methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
