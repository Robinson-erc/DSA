    import list.ArrayList; import list.List; public class HeapSortDriver { public static void main(String[] args) {
        // Example for Heapify
        List heapifyList = new ArrayList<>(); heapifyList.addAll(List.of(25, 7, 40, 36, 7, 40, 6, 53, 4, 81));
        HeapSort heapSorter = new HeapSort<>();
        System.out.println("Original List for Heapify: " + heapifyList);
         heapSorter.heapify(0);
        System.out.println("Heapified List: " + heapifyList);
        System.out.println();
        Example for percDown List percDownList = new ArrayList<>();
        percDownList.addAll(List.of(48, 40, 60, 20, 20, 55, 52, 10, 20, 15, 17, 44, 45, 42, 41));
        System.out.println("Original List for percDown: " + percDownList);
         heapSorter.percDown(0, percDownList.size() - 1);
        System.out.println("List after percDown: " + percDownList); System.out.println();
        // Example for HeapSort
        List heapSortList = new ArrayList<>();
         heapSortList.addAll(List.of(48, 40, 60, 20, 20, 55, 52, 10, 20, 15, 17, 44, 45, 42, 41));
        System.out.println("Original List for HeapSort: " + heapSortList);
         heapSorter.sort(heapSortList);
        System.out.println("Sorted List: " + heapSortList); } }
    }
