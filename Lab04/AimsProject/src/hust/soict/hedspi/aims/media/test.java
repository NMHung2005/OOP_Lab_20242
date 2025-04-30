package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

	public static void main(String[] args) {
		List<Media> mediaList = new ArrayList<Media>();

		// Khởi tạo các đối tượng Media

		mediaList.add(new Book(0, "Zebra", "Author A", 10.0f));
		mediaList.add(new Book(1, "Alpha", "Author B", 12.0f));
		mediaList.add(new Book(2, "Alpha", "Author C", 8.0f));
		// Thêm vào danh sách

		// Duyệt danh sách và in thông tin bằng toString()
		Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);

		System.out.println("Sorted by TITLE then COST:");
		for (Media m : mediaList) {
			System.out.println(m.toString());
		}

		// Sắp xếp theo cost rồi title
		Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);

		System.out.println("\nSorted by COST then TITLE:");
		for (Media m : mediaList) {
			System.out.println(m.toString());
		}
	}
}
