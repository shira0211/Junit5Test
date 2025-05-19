import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.List;

public class LoggerExtension implements BeforeAllCallback, AfterAllCallback, TestWatcher {

    public static List<String> log = new ArrayList<>();

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {

        System.out.println("finish------👌🏼");

    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
      log.clear();//אתחול הLOG
        System.out.println("start--------😊");

    }
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        System.out.println("testFailed------😒");

    }
    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("text successful------🙏🏼");
    }
}
