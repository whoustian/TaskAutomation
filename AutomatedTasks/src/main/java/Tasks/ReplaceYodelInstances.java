package Tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReplaceYodelInstances {

	private static final String CONFIG_FILENAME = "YodelConsole.exe.config";

	public static void replaceYodelInstances() {
		try {
			String yodelProjectPath = "C:\\Projects\\Yodel\\YodelSolution\\YodelConsole\\bin\\Debug";
			File sourceDir = new File(yodelProjectPath);
			File[] files = sourceDir.listFiles();
			List<File> instances = getInstanceDestinations();
			File tempDir = null;

			new File("C:\\Yodel\\Temp").mkdir();
			tempDir = new File("C:\\Yodel\\Temp\\");

			for (File instance : instances) {
				File[] instanceFiles = instance.listFiles();
				for (File f : instanceFiles) {
					if (!f.getName().equalsIgnoreCase(CONFIG_FILENAME)) {
						f.delete();
					} else {
						Files.copy(f.toPath(), new File(tempDir.getPath() + "\\" + CONFIG_FILENAME).toPath());
						f.delete();
					}
				}

				Files.copy(new File(tempDir.getPath() + "\\" + CONFIG_FILENAME).toPath(),
						new File(instance.getPath() + "\\" + CONFIG_FILENAME).toPath());
				new File(tempDir.getPath() + "\\" + CONFIG_FILENAME).delete();

				for (File f : files) {
					if (!f.getName().equalsIgnoreCase(CONFIG_FILENAME)) {
						File path = new File(f.getPath());
						Files.copy(path.toPath(), new File(instance.getPath() + "\\" + f.getName()).toPath());
					}
				}
			}

			tempDir.delete();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<File> getInstanceDestinations() {
		List<File> instanceDestinations = new ArrayList<File>();
		instanceDestinations.add(new File("C:\\Yodel\\Yodel-Instances\\Apu\\Debug"));
		instanceDestinations.add(new File("C:\\Yodel\\Yodel-Instances\\Lisa\\Debug"));
		instanceDestinations.add(new File("C:\\Yodel\\Yodel-Instances\\Marge\\Debug"));
		instanceDestinations.add(new File("C:\\Yodel\\Yodel-Instances\\Bart\\Debug"));
		instanceDestinations.add(new File("C:\\Yodel\\Yodel-Instances\\Homer\\Debug"));
		return instanceDestinations;
	}
}
