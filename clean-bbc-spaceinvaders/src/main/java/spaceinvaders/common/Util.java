package spaceinvaders.common;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static <F extends T, T> List<F> getAllObjectsFromType(Class<F> classToFind, List<T> list) {
        List<F> resultList = new ArrayList<F>();
        for (T o : list) {

            // Uggly workaround cause of Springcontainer
            String classnameToFind = classToFind.getName();
            String currentClassname = o.getClass().getName();
            if (currentClassname.contains(classnameToFind) || classnameToFind.contains(currentClassname)  )
                resultList.add((F) o);

            /*if (classnameToFind.equals(currentClassname))
                resultList.add((F) o);*/
        }
        return resultList;
    }
}
