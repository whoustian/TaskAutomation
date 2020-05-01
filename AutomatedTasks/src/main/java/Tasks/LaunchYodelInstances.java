package Tasks;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaunchYodelInstances {

	public static void launchYodelInstances() {
		try {
			Desktop desktop = Desktop.getDesktop();
			List<File> yodelers = getYodelLaunchers();

			for (File f : yodelers) {
				desktop.open(new File(f.getPath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<File> getYodelLaunchers() {
		List<File> yodelLaunchers = new ArrayList<File>();
		yodelLaunchers.add(new File("C:\\Yodel\\Yodel-Instances\\Apu\\Debug\\YodelConsole.exe"));
		yodelLaunchers.add(new File("C:\\Yodel\\Yodel-Instances\\Lisa\\Debug\\YodelConsole.exe"));
		yodelLaunchers.add(new File("C:\\Yodel\\Yodel-Instances\\Homer\\Debug\\YodelConsole.exe"));
		yodelLaunchers.add(new File("C:\\Yodel\\Yodel-Instances\\Marge\\Debug\\YodelConsole.exe"));
		yodelLaunchers.add(new File("C:\\Yodel\\Yodel-Instances\\Bart\\Debug\\YodelConsole.exe"));
		return yodelLaunchers;

	}

}
