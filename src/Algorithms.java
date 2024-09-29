

import java.util.ArrayList;

public class Algorithms {
    public static int whereToPlace(String value, ArrayList<String> list) {
        int index = list.size();
        boolean stop = false;
        for (int i = 0; !stop && i < list.size(); i++) {
            if (value.compareToIgnoreCase(list.get(i)) <= 0) {
                index = i;
                stop = true;
            }
        }
        return index;
    }

    public static int whereToPlaceReverse(String value, ArrayList<String> list) {
        int index = list.size();
        boolean stop = false;
        for (int i = 0; !stop && i < list.size(); i++) {
            if (value.compareToIgnoreCase(list.get(i)) >= 0) {
                index = i;
                stop = true;
            }
        }
        return index;
    }

    public static ArrayList<ArrayList<String>> sortAlphabetically(ArrayList<String> songs, ArrayList<String> albums) {
        ArrayList<String> songList = new ArrayList<String>();
        ArrayList<String> albumList = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            if (i == 0) {
                songList.add(songs.get(i));
                albumList.add(albums.get(i));
            } else {
                songList.add(whereToPlace(songs.get(i), songList), songs.get(i));
                albumList.add(whereToPlace(songs.get(i), songList), albums.get(i));
            }
        }
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        list.add(songList);
        list.add(albumList);
        return list;
    }

    public static ArrayList<ArrayList<String>> sortReverseAlphabetically(ArrayList<String> songs, ArrayList<String> albums) {
        ArrayList<String> songList = new ArrayList<String>();
        ArrayList<String> albumList = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            if (i == 0) {
                songList.add(songs.get(i));
                albumList.add(albums.get(i));
            } else {
                songList.add(whereToPlaceReverse(songs.get(i), songList), songs.get(i));
                albumList.add(whereToPlaceReverse(songs.get(i), songList), albums.get(i));
            }
        }
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        list.add(songList);
        list.add(albumList);
        return list;
    }


    public static int findSong(ArrayList<String> list, String name) {
        int index = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public static ArrayList<String> shuffle(ArrayList<String> old) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < old.size(); i++) {
            temp.add(old.get(i));
        }
        ArrayList<String> result = new ArrayList<String>();
        while (temp.size() > 0) {
            int randIndex = (int) (Math.random() * temp.size());
            result.add(temp.remove(randIndex));
        }
        return result;
    }

    public static ArrayList<String> fullSongList(ArrayList<String> songNames, ArrayList<String> wavFiles) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < songNames.size(); i++) {
            result.add(wavFiles.get(findSongWav(songNames.get(i), wavFiles)));
        }
        return result;
    }

    public static int findSongWav(String text, ArrayList<String> wavFiles) {
        int index = wavFiles.size();
        for (int i = 0; i < wavFiles.size(); i++) {
            if (wavFiles.get(i).substring(0, 3).equals("Thu") || wavFiles.get(i).substring(0, 3).equals("Thr")) {
                if (wavFiles.get(i).substring(0, 3).equals(text.substring(0, 3))) {
                    index = i;
                }
            } else {
                if (wavFiles.get(i).substring(0, 2).equals(text.substring(0, 2))) {
                    index = i;
                }
            }
        }
        return index;
    }


    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void mergeSort2(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    private static void mergeSortHelper(int[] arr, int from, int to, int[] temp) {
        if (from < to) {
            int middle = (from + to) / 2;
            mergeSortHelper(arr, from, middle, temp);
            mergeSortHelper(arr, middle + 1, to, temp);
            merge(arr, from, middle, to, temp);
        }
    }

    private static void merge(int[] arr, int from, int mid, int to, int[] temp) {
        int i = from;
        int j = mid + 1;
        int k = from;

        while (i <= mid && j <= to) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= to) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (k = from; k <= to; k++) {
            arr[k] = temp[k];
        }
    }
    public static int iterativeBinarySearch(int[] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right)
        {
            int middle = (left + right) / 2;
            if (target < arr[middle])
            {
                right = middle - 1;
            }
            else if (target > arr[middle])
            {
                left = middle + 1;
            }
            else return middle;
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] array, int start, int end, int target)
    {
        int middle = (start + end)/2;
        // base case: check middle element
        if (target == array[middle]) return middle;

        // base case: check if we've run out of arr
        if(end < start) return -1; // not found

        // recursive call: search start to middle
        if (target < array[middle])
            return recursiveBinarySearch(array, start, middle - 1, target);

        // recursive call: search middle to end
        if (target > array[middle])
            return recursiveBinarySearch(array, middle + 1, end, target);

        return -1;
    }
}