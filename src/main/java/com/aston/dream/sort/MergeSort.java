package com.aston.dream.sort;

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
            if (left.get(i).compareTo(right.get(j)) < 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }
}
