/**
 * @author : dx
 * @date : 2019/5/28
 * Description :
 */
public class 排序 {
    //冒泡排序
    public int[] sortArray1(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    //选择排序
    public int[] sortArray2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[temp] < nums[j]) {
                    temp = j;
                }
            }
            swap(nums, i, temp);
        }
        return nums;
    }

    //快速排序
    public int[] sortArray3(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = findPosition(nums, left, right);
        quickSort(nums, left, pos - 1);
        quickSort(nums, pos + 1, right);

    }


    public int findPosition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            if (left < right && nums[right] < temp) {
                nums[left] = nums[right];
            }

            while (left < right && nums[left] <= temp) {
                left++;
            }
            if (left < right && nums[left] > temp) {
                nums[right] = nums[left];
            }
            if (left == right) {
                nums[left] = temp;
            }

        }
        return left;
    }


    //归并排序
    public int[] sortArray4(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[]{nums[l]};

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }
        return newNum;
    }

    //堆排序
    public static int[] sortArray5(int[] nums) {
        buildMaxHeap(nums, nums.length);

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums;
    }


    public static void buildMaxHeap(int nums[], int end) {
        for (int i = parent(end - 1); i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
    }

    public static void adjustHeap(int[] nums, int i, int end) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if (left < end && nums[largest] < nums[left]) {
            largest = left;
        }
        if (right < end && nums[largest] < nums[right]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, largest, i);
            adjustHeap(nums, largest, end);
        }
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    protected static int leftChild(int i) {
        return 2 * i + 1;
    }

    protected static int rightChild(int i) {
        return 2 * i + 2;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 10};
        int[] newNums = sortArray5(nums);
        for (int x : newNums) {
            System.out.println(x);
        }
    }

    //
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


    public void maopao(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public void xuanze(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public void quick(int[] nums, int start, int end) {

    }


}
