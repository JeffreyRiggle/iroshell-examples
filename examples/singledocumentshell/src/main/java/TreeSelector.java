package singledocumentshell.src.main.java;

import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import ilusr.iroshell.documentinterfaces.sdi.SelectorNode;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class TreeSelector extends SelectorNode implements Initializable{

	@FXML
	public TreeView<String> tree;
	
	public TreeSelector(Map<String, Node> views) {
		super();
		super.getModel().viewPool().putAll(views);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TreeSelector.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		AnchorPane.setBottomAnchor(this, 0.0);
		AnchorPane.setTopAnchor(this, 0.0);
		AnchorPane.setLeftAnchor(this, 0.0);
		AnchorPane.setRightAnchor(this, 0.0);
		
		addTreeItems();
		
		tree.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
			TreeItem<String> item = (TreeItem<String>)newVal;
			super.getModel().changeView((String)item.getValue());
		});
		
		super.getModel().currentView().addListener((observable, oldVal, newVal) -> {
			String selectedTreeItem = new String();
			if (tree.getSelectionModel().selectedItemProperty().get() != null) {
				selectedTreeItem = tree.getSelectionModel().selectedItemProperty().get().getValue();
			}
			
			String selectedViewId = super.getModel().selectedViewId();
			if (selectedTreeItem.equals(selectedViewId)) {
				return;
			}
			
			if (!tree.rootProperty().get().isExpanded()) {
				tree.rootProperty().get().expandedProperty().set(true);
			}
			
			tree.getSelectionModel().clearAndSelect(findItemIndex(selectedViewId));
		});
	}
	
	private int findItemIndex(String itemName) {
		int retVal = 1;
		for (TreeItem<String> treeItem : tree.rootProperty().get().getChildren()) {
			if (treeItem.getValue().equals(itemName)) {
				return retVal;
			}
			retVal++;
		}
		
		return 0;
	}
	
	private void addTreeItems() {
		TreeItem<String> root = new TreeItem<String>("Views");
		
		for(Entry<String, Node> entry : super.getModel().viewPool().entrySet()) {
			root.getChildren().add(new TreeItem<String>(entry.getKey()));
		}
		
		tree.rootProperty().set(root);
	}
}
