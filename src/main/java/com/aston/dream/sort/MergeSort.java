package com.aston.dream.sort;

import com.aston.dream.models.Auto;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public List<Auto> sort(List<Auto> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;

        List<Auto> left = new ArrayList<>(list.subList(0, mid));
        List<Auto> right = new ArrayList<>(list.subList(mid, list.size()));

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private List<Auto> merge(List<Auto> left, List<Auto> right) {
        List<Auto> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getYear() % 2 == 0) {
                if (right.get(j).getYear() < left.get(i).getYear()) {
                    result.add(right.get(j));
                    j++;
                } else {
                    result.add(left.get(i));
                    i++;
                }
            } else {
                result.add(left.get(i));
                i++;
            }
        }

        while (i < left.size()) {
            if (left.get(i).getYear() % 2 == 0) {
                result.add(left.get(i));
            }
            i++;
        }
        while (j < right.size()) {
            if (right.get(j).getYear() % 2 == 0) {
                result.add(right.get(j));
            }
            j++;
        }
        return result;
    }
}
