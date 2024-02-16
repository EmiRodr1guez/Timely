package Methods.SYSNotifs;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class systemtray {

    public static void systray() {
        try {
            if (SystemTray.isSupported()) {
                systemtray notif = new systemtray();
                notif.enableNotifications();
            } else {
                System.err.println("System tray not supported!");
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void enableNotifications() throws AWTException {
        // Create a tray icon with an image and tooltip
        Image image = Toolkit.getDefaultToolkit().getImage("src/Methods/SYSNotifs/visualDependencies/1255398.png");
        TrayIcon trayIcon = new TrayIcon(image, "My Application");

        // Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);

        // Set tooltip text for the tray icon
        trayIcon.setToolTip("Timely Punches");

        // Add the tray icon to the system tray
        SystemTray.getSystemTray().add(trayIcon);

        // Display a notification message
        trayIcon.displayMessage("Hello, World!", "This is a notification", MessageType.INFO);
    }
}
