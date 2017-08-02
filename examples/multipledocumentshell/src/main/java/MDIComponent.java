package multipledocumentshell.src.main.java;

import java.io.File;

import examples.sharedui.BindingViewBluePrint;
import examples.sharedui.NotepadViewBluePrint;
import examples.sharedui.WebBrowserViewBluePrint;
import ilusr.iroshell.core.DockPosition;
import ilusr.iroshell.core.LocationProvider;
import ilusr.iroshell.main.IComponent;
import ilusr.iroshell.main.LoadData;
import ilusr.iroshell.menus.MenuService;
import ilusr.iroshell.services.IDialogService;
import ilusr.iroshell.services.INotification;
import ilusr.iroshell.services.INotificationService;
import ilusr.iroshell.services.LayoutService;
import ilusr.iroshell.services.Notification;
import ilusr.iroshell.services.PersistableToolBarService;
import ilusr.iroshell.services.PersistenceService;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MDIComponent implements IComponent{

	private MenuService _menuService;
	private LayoutService _layoutService;
	private IDialogService _dialogService;
	private PersistenceService _persistenceService;
	private PersistableToolBarService _toolBarService;
	private INotificationService _notificationService;

	@Override
	public void load(LoadData data) {
		try {
			Resource resource = new ClassPathResource("registrations.xml", MDIComponent.class);
			data.serviceManager().registerServicesFromResource(resource);
		} catch(Exception e) {
			e.printStackTrace();
		}

		_menuService = data.serviceManager().<MenuService>get("MenuService");
		_layoutService = data.serviceManager().<LayoutService>get("LayoutService");
		_dialogService = data.serviceManager().<IDialogService>get("IDialogService");
		_persistenceService = data.serviceManager().<PersistenceService>get("IPersistenceService");
		_toolBarService = data.serviceManager().<PersistableToolBarService>get("PersistableToolBarService");
		_notificationService = data.serviceManager().<INotificationService>get("INotificationService");

		_toolBarService.registerBluePrint("TestBPrint", new TestToolBarBluePrint());
		_layoutService.registerBluePrint("NotePadBP", new NotepadViewBluePrint());
		_layoutService.registerBluePrint("BindingBP", new BindingViewBluePrint());
		_layoutService.registerBluePrint("WebBP", new WebBrowserViewBluePrint());

		_notificationService.setMaxNotifications(3);

		Menu views = new Menu("Views");
		MenuItem notepadView = new MenuItem("Notepad");
		MenuItem bindingView = new MenuItem("BindingView");
		MenuItem webView = new MenuItem("WebView");
		MenuItem toolBar = new MenuItem("ToolBar");
		MenuItem alert = new MenuItem("Alert");

		notepadView.setOnAction((e) -> {
			_layoutService.addTab("NotePadBP");
			//_layoutService.addTab(data.serviceManager().<NotepadContentTab>get("NotepadContentTab"));
		});

		bindingView.setOnAction((e) -> {
			_layoutService.addTab("BindingBP");
			//_layoutService.addTab(data.serviceManager().<BindingContentTab>get("BindingContentTab"));
		});

		webView.setOnAction((e) -> {
			_layoutService.addTab("WebBP");
			//_layoutService.addTab(data.serviceManager().<WebBrowserContentTab>get("WebBrowserContentTab"));
		});

		toolBar.setOnAction((e) -> {
			_toolBarService.addToolBar("TestBPrint", LocationProvider.first(), DockPosition.Top);
		});

		alert.setOnAction((e) -> {
			GridPane gp = new GridPane();
			gp.setPrefWidth(200);
			gp.setPrefHeight(50);
			gp.add(new Label("Alert"), 0, 0);
			INotification notification = new Notification(gp, "Test", 10 * 1000);
			_notificationService.addNotification(notification);
		});

		views.getItems().add(notepadView);
		views.getItems().add(bindingView);
		views.getItems().add(webView);
		views.getItems().add(toolBar);
		views.getItems().add(alert);

		Menu help = new Menu("Help");
		MenuItem about = new MenuItem("About");
		MenuItem error = new MenuItem("Throw");
		MenuItem overlay = new MenuItem("Embedded overlay");
		MenuItem layout = new MenuItem("Layout String");

		about.setOnAction((e) -> {
			Stage s = new Stage();
			s.titleProperty().set("About Page");
			_dialogService.displayModeless(s);
		});

		error.setOnAction((e) -> {
			Thread t = new Thread(() -> {
				throw new RuntimeException("Rawr");
			});
			t.start();
		});

		overlay.setOnAction((e) -> {
			_dialogService.displayEmbedded(new Label("This is a test"));
		});

		layout.setOnAction((e) -> {
			GridPane gp = new GridPane();
			gp.setPrefWidth(400);
			gp.setPrefHeight(400);
			//gp.getChildren().add(new Label(_persistenceService.getLayoutString()));
			//gp.getChildren().add(new Label(_toolBarService.getLayout()));
			gp.getChildren().add(new TextArea(_layoutService.getLayout()));
			_dialogService.displayModeless(gp);
		});

		help.getItems().add(about);
		help.getItems().add(error);
		help.getItems().add(overlay);
		help.getItems().add(layout);

		_menuService.addMenu(views, LocationProvider.last());
		_menuService.addMenu(help, LocationProvider.last());
	}
}
