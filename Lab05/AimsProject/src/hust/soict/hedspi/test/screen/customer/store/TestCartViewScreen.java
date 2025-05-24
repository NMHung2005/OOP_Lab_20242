package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartViewScreen extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";

		// Tạo Cart và thêm dữ liệu
		Cart cart = new Cart();
		cart.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers"));
		cart.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas"));
		cart.addMedia(new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "John Musker"));

		// Tải FXML và gán controller
		FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		loader.setController(new CartController(cart)); // Gán controller với Cart
		Parent root = loader.load();

		// Hiển thị giao diện
		primaryStage.setTitle("Cart Test");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}