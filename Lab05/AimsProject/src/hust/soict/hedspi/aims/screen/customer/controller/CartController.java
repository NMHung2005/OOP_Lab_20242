package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;

	public CartController(Cart cart) {
		this.cart = cart;
	}

	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}

	@FXML
	private Button btnPlaceOrder;

	@FXML
	private TableColumn<Media, Integer> colMediaId;

	@FXML
	private Label costLabel;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private TextField tfFilter;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	private ObservableList<Media> mediaList = FXCollections.observableArrayList();
	private FilteredList<Media> filteredMediaList;

	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		if (cart == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR, "Giỏ hàng không hợp lệ!");
			alert.showAndWait();
			return;
		}

		// Xóa toàn bộ giỏ hàng
		cart.getItemsOrdered().clear();
		// Cập nhật giao diện
		mediaList.setAll(cart.getItemsOrdered());
		filteredMediaList.setPredicate(p -> true);
		updateCostLabel(); // Cập nhật tổng chi phí
		// Hiển thị thông báo thành công
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Đặt hàng thành công!");
		alert.showAndWait();
	}

	@FXML
	void btnPlayPressed(ActionEvent event) {
		Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
		if (selectedMedia == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "Vui lòng chọn một mục để phát!");
			alert.showAndWait();
			return;
		}

		if (selectedMedia instanceof Playable) {
			Playable playable = (Playable) selectedMedia;
			try {
				playable.play(); // Hiển thị tên và độ dài trên màn hình qua Alert
			} catch (Exception e) {
				Alert alert = new Alert(Alert.AlertType.ERROR, "Lỗi khi phát nội dung: " + e.getMessage());
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nội dung này không thể phát!");
			alert.showAndWait();
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING, "Vui lòng chọn một mục để xóa!");
			alert.showAndWait();
			return;
		}
		cart.removeMedia(media);
		mediaList.setAll(cart.getItemsOrdered());
		filteredMediaList.setPredicate(p -> true);
		updateCostLabel(); // Cập nhật tổng chi phí sau khi xóa
	}

	@FXML
	void btnViewStorePressed(ActionEvent event) {
		try {
			System.out.println("Đang cố gắng tải Store.fxml");
			final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
			if (fxmlLoader.getLocation() == null) {
				System.err.println("Không tìm thấy tệp FXML: " + CART_FXML_FILE_PATH);
				return;
			}
			fxmlLoader.setController(new ViewStoreController(cart, store));
			Parent root = fxmlLoader.load();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setTitle("Store");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR, "Không thể tải màn hình Store: " + e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void initialize() {
		colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		if (cart.getItemsOrdered() != null) {
			mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
			filteredMediaList = new FilteredList<>(mediaList, p -> true);
			tblMedia.setItems(filteredMediaList);
		}
		tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
			showFilteredMedia(newValue);
		});
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		btnPlaceOrder.setVisible(true);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}
		});
		updateCostLabel(); // Cập nhật costLabel khi khởi tạo
	}

	void updateButtonBar(Media media) {
		if (media == null) {
			btnPlay.setVisible(false);
			btnRemove.setVisible(false);
		} else {
			btnRemove.setVisible(true);
			if (media instanceof Playable) {
				btnPlay.setVisible(true);
			} else {
				btnPlay.setVisible(false);
			}
		}
	}

	void showFilteredMedia(String filterText) {
		filteredMediaList.setPredicate(media -> {
			if (filterText == null || filterText.isEmpty()) {
				return true;
			}

			String lowerCaseFilter = filterText.toLowerCase();

			if (radioBtnFilterId.isSelected()) {
				String idStr = String.valueOf(media.getId());
				return idStr.contains(lowerCaseFilter);
			} else {
				return media.getTitle().toLowerCase().contains(lowerCaseFilter);
			}
		});
	}

	public void setCart(Cart cart) {
		this.cart = cart;
		if (cart != null) {
			mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
			filteredMediaList = new FilteredList<>(mediaList, p -> true);
			tblMedia.setItems(filteredMediaList);
			updateCostLabel(); // Cập nhật costLabel khi gán giỏ hàng mới
		}
	}

	public void setStore(Store store) {
		this.store = store;
	}

	private void updateCostLabel() {
		if (cart != null) {
			costLabel.setText(String.format("%.2f $", cart.totalCost()));
		} else {
			costLabel.setText("0.00 $");
		}
	}
}