package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Cart cart;

	public ItemController(Cart cart) {
		this.cart = cart;
	}

	@FXML
	private Label lb1Cost;

	@FXML
	private Button btnAddToCart;

	@FXML
	private Button btnPlay;

	@FXML
	private Label lb1Title;

	@FXML
	void btnAddToCartClicked(ActionEvent event) {
		// Kiểm tra null để tránh lỗi
		if (cart == null || media == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR,
					"Không thể thêm vào giỏ hàng: Giỏ hàng hoặc media không hợp lệ!");
			alert.showAndWait();
			return;
		}

		try {
			// Thêm media vào giỏ hàng
			cart.addMedia(media);
			// Hiển thị thông báo xác nhận
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Đã thêm " + media.getTitle() + " vào giỏ hàng!");
			alert.showAndWait();
		} catch (Exception e) {
			// Xử lý ngoại lệ nếu có lỗi khi thêm vào giỏ hàng
			Alert alert = new Alert(Alert.AlertType.ERROR, "Lỗi khi thêm vào giỏ hàng: " + e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	void btnPlayClicked(ActionEvent event) {
		if (media instanceof Playable) {
			Playable playable = (Playable) media;
			try {
				playable.play();
			} catch (Exception e) {
				Alert alert = new Alert(Alert.AlertType.ERROR, "Không thể phát nội dung: " + e.getMessage());
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nội dung này không thể phát!");
			alert.showAndWait();
		}
	}

	private Media media;

	public void setData(Media media) {
		this.media = media;
		lb1Title.setText(media.getTitle());
		lb1Cost.setText(media.getCost() + " $");
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
		}
	}
}
