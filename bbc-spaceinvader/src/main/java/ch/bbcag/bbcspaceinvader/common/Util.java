package ch.bbcag.bbcspaceinvader.common;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static <T, R> List<T> getAllObjectsFromType(Class<T> classToFinde, List<R> list){
		
		List<T> resultList = new ArrayList<T>();
		for (Object obj : list) {
			if (classToFinde == obj.getClass())
				resultList.add((T)obj);
		}

		return resultList;
	}

	public static double convertFromNanoSecondToSecond(long nanoSecond) {
		return nanoSecond / 1e9;
	}
}
