package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aims extends Application {
	private Cart cart;
	private Store store;
	private Stage primaryStage;
	private Scene cartScene;
	private Scene storeScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		// Khởi tạo dữ liệu
		initializeData();

		// Tạo các màn hình
		createCartScreen();
		createStoreScreen();

		// Tạo màn hình chính với các nút chuyển đổi
		VBox root = new VBox(10);
		Button btnViewCart = new Button("View Cart");
		Button btnViewStore = new Button("View Store");

		// Xử lý sự kiện cho các nút
		btnViewCart.setOnAction(e -> primaryStage.setScene(cartScene));
		btnViewStore.setOnAction(e -> primaryStage.setScene(storeScene));

		root.getChildren().addAll(btnViewCart, btnViewStore);

		// Thiết lập màn hình chính
		Scene mainScene = new Scene(root, 300, 150);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("AIMS Application");
		primaryStage.show();
	}

	private void initializeData() {
		// Khởi tạo Store và Cart
		store = new Store();
		cart = new Cart();

		// Thêm dữ liệu mẫu vào Store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, -87, "Roger Allers");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker");

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
	}

	private void createCartScreen() throws Exception {
		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
		FXMLLoader loader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		loader.setController(new CartController(store, cart));
		Parent root = loader.load();
		cartScene = new Scene(root, 600, 400);
	}

	private void createStoreScreen() throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		loader.setController(new ViewStoreController(cart, store));
		Parent root = loader.load();
		storeScene = new Scene(root, 600, 400);
	}

	public static void main(String[] args) {
		launch(args);
	}
}