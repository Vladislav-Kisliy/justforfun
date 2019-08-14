package vladislav.kisliy.jff.nio.util;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 14.08.19.
 */
public class Util {

    public static int transmografy(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}
