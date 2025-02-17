package com.git.hitzaki.education.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtil {
    @SafeVarargs
    public static <T> List<T> of(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return Collections.unmodifiableList(list);
    }

}
