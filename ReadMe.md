# Data Structure
1. **List**

`Lưu trữ các phần tử có thứ tự, cho phép trùng lặp.`  
- **ArrayList**
  + Dựa trên mảng động.
  + Truy cập nhanh (O(1)) qua chỉ số (index).
  + Nhược điểm: Chậm khi thêm/xóa phần tử ở giữa danh sách (O(n)).

  ➢ <span style="color: red;"> Sử dụng khi cần danh sách thay đổi ít. </span>
- **LinkedList**
  + Dựa trên danh sách liên kết đôi.
  + Thêm/xóa phần tử ở đầu/cuối nhanh (O(1)).
  + Truy cập chậm (O(n)).
  
  ➢ <span style="color: red;">Sử dụng khi cần thao tác nhiều với các phần tử ở giữa hoặc đầu/cuối danh sách. </span>
2. **Array**

`Là một cấu trúc dữ liệu cố định kích thước, lưu trữ các phần tử cùng kiểu`

  + Truy cập nhanh qua chỉ số (O(1)).
  + Không thể thay đổi kích thước sau khi tạo.

➢ <span style="color: red;"> Thích hợp khi làm việc với các bộ dữ liệu nhỏ, cố định. </span>

3. **Map**

`Lưu trữ dữ liệu dưới dạng key-value; Không cho phép hai khóa (key) trùng lặp`

- **HashMap**
  + Dựa trên bảng băm.
  + Truy cập nhanh (O(1)) khi hashcode của key được phân phối tốt.
  + Không đảm bảo thứ tự chèn.
- **LinkedHashMap**
  + Giống HashMap nhưng duy trì thứ tự chèn.
- **TreeMap**
  + Dựa trên cây nhị phân cân bằng.
  + Duy trì các phần tử theo thứ tự tự nhiên hoặc so sánh tuỳ chỉnh.
  + Truy cập chậm hơn HashMap (O(log n)).
    
  ➢ <span style="color: red;">`HashMap`: Khi chỉ cần lưu dữ liệu mà không cần quan tâm đến thứ tự. </span>

  ➢ <span style="color: red;">`TreeMap`: Khi cần dữ liệu được sắp xếp.

  ➢ <span style="color: red;">`LinkedHashMap`: Khi cần duy trì thứ tự chèn. 

4. **Set**

`Lưu trữ các phần tử không trùng lặp.`

- **HasHSet**
- **LinkedHashSet**
- **TreeSet**

5. **Vector**

`Tương tự ArrayList nhưng các phương thức của nó được đồng bộ (synchronized).`

- _Ưu_: Thread-safe, phù hợp trong môi trường đa luồng.
- _Nhược_: Hiệu năng thấp hơn ArrayList vì đồng bộ hóa không cần thiết trong hầu hết các trường hợp.
6. **Queue**

`Là một cấu trúc dữ liệu hoạt động theo nguyên tắc FIFO (First In, First Out).`

- PriorityQueue
  + Lưu trữ các phần tử dựa trên thứ tự ưu tiên (sắp xếp tự nhiên hoặc tuỳ chỉnh).
- LinkedList

```java
Queue<Integer> pq = new PriorityQueue<>();
pq.add(3);
pq.add(1);
pq.add(2);
System.out.println(pq.poll()); // Lấy phần tử nhỏ nhất: 1

Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
System.out.println(queue.poll()); // Lấy phần tử đầu: "A"

Deque<Integer> deque = new LinkedList<>();
deque.addFirst(1);
deque.addLast(2);
System.out.println(deque.pollFirst()); // Lấy phần tử đầu: 1
```
➢ <span style="color: red;"> Hàng đợi tác vụ, lập lịch (job scheduling).

7. **Stack**

`Là một cấu trúc dữ liệu hoạt động theo nguyên tắc LIFO (Last In, First Out).`

- **Stack**
  + _push()_: Thêm phần tử vào đỉnh.
  + _pop()_: Lấy phần tử ở đỉnh và xóa nó.
  + _peek()_: Lấy phần tử ở đỉnh mà không xóa.

```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
System.out.println(stack.pop()); // Lấy phần tử cuối: 2
```
➢ <span style="color: red;">Xử lý dấu ngoặc trong biểu thức toán học, backtracking.

---
Tóm lại
--
**Loại bài toán**| **Cấu trúc dữ liệu nên dùng**          |
| :--- |:---------------------------------------|
|Truy cập ngẫu nhiên| Array, ArrayList                       
|Thêm/xóa nhanh ở đầu/cuối| LinkedList, Stack, Queue               
|Dữ liệu duy nhất| HashSet, TreeSet                       
|Tìm kiếm nhanh (theo key)| HashMap, TreeMap                       
|Tìm kiếm nhanh (theo thứ tự tự nhiên)| TreeMap, TreeSet                       
|Biểu diễn dữ liệu phân cấp| Tree (Binary Tree, Binary Search Tree) 
|Biểu diễn mối quan hệ hoặc mạng lưới| Graph                                  

---
# Some algorithmic techniques

#### 0. Sliding window
#### 1. Two points
#### 2. Dynamic programming
#### 3. Greedy Algorithm
#### 4. Backtracking
#### 5. Binary Search
#### 6. Divide and conquer
#### 7. Union-Find
#### 8. Topological Sort
#### 9. Bit Manipulation
#### 10. Heap
#### 11. Hashing

----------------------------------------------------------------

### 0. Sliding window
 
- 


