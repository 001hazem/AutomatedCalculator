import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserOptions {
     ChromeOptions options;

    public ChromeOptions getOptions(boolean isHeadless) {
        options = new ChromeOptions();
//        options.addArguments("--incognito");
//        // Pass Mic Permissions
//        options.addArguments("--disable-user-media-security=true");
//        options.addArguments("--use-fake-ui-for-media-stream");
        // Headless
        if (isHeadless) {
            options.addArguments("--disable-features=VizDisplayCompositor");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--aggressive-cache-discard");
            options.addArguments("--disable-cache");
            options.addArguments("--disable-application-cache");
            options.addArguments("--disable-offline-load-stale-cache");
            options.addArguments("--disk-cache-size=0");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--no-proxy-server");
            options.addArguments("--log-level=3");
            options.addArguments("--silent");
            options.addArguments("--disable-browser-side-navigation");
            options.setProxy(null);
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        }
        return options;
    }
}