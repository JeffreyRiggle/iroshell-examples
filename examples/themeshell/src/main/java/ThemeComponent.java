package themeshell.src.main.java;

import java.io.File;

import examples.sharedui.ThemeItem;
import examples.sharedui.ThemeService;
import examples.sharedui.ThemeView;
import ilusr.iroshell.core.LocationProvider;
import ilusr.iroshell.main.IComponent;
import ilusr.iroshell.main.LoadData;
import ilusr.iroshell.menus.MenuService;
import ilusr.iroshell.services.LayoutService;
import ilusr.iroshell.statusbar.IStatusBarService;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import themeshell.src.main.java.blue.BlueStyleHelper;
import themeshell.src.main.java.dark.DarkStyleHelper;
import themeshell.src.main.java.green.GreenStyleHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ThemeComponent implements IComponent {

	private MenuService _menuService;
	private IStatusBarService _statusBarService;
	private LayoutService _layoutService;
	private ThemeService _themeService;

	@Override
	public void load(LoadData data) {
		try {
			Resource resource = new ClassPathResource("registrations.xml", ThemeComponent.class);
			data.serviceManager().registerServicesFromResource(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		_menuService = data.serviceManager().<MenuService>get("MenuService");
		_layoutService = data.serviceManager().<LayoutService>get("LayoutService");
		_statusBarService = data.serviceManager().<IStatusBarService>get("IStatusBarService");
		_themeService = data.serviceManager().<ThemeService>get("ThemeService");

		registerThemes();

		Menu views = new Menu("Views");
		MenuItem themeView = new MenuItem("Theme View");
		themeView.setOnAction((e) -> {
			_layoutService.addTab(new ThemeContentTab(new ThemeView()));
		});

		views.getItems().add(themeView);

		Menu themes = new Menu("Themes");
		MenuItem dark = new MenuItem("Dark");
		dark.setOnAction((e) -> {
			_themeService.changeStyle("dark");
		});

		MenuItem green = new MenuItem("Green");
		green.setOnAction((e) -> {
			_themeService.changeStyle("green");
		});

		MenuItem blue = new MenuItem("Blue");
		blue.setOnAction((e) -> {
			_themeService.changeStyle("blue");
		});

		themes.getItems().add(dark);
		themes.getItems().add(green);
		themes.getItems().add(blue);

		_menuService.addMenu(views, LocationProvider.last());
		_menuService.addMenu(themes, LocationProvider.last());

		_statusBarService.addStatusBar(new ThemeItem(), LocationProvider.first());
	}

	private void registerThemes() {
		try {
			_themeService.addStyle("dark", DarkStyleHelper.generateMap());
			_themeService.addStyle("blue", BlueStyleHelper.generateMap());
			_themeService.addStyle("green", GreenStyleHelper.generateMap());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
