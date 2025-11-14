package Test;

import BaseTest.UserForAllTest;
import Driver.DriverManagerTL3;
import Pages.Loginpage;
import Utils.PropertyReader3;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

//3rd Framework
public class Logintest extends UserForAllTest {


        ExtentTest test;
        private static final Logger logger = LogManager.getLogger(Logintest.class);


        @Severity(SeverityLevel.CRITICAL)
        @Description("Verify the Valid Credentials are working fine")
//    @Test(groups = {"P0", "negative", }, priority = 1)
        @Test(groups = {"QA"})
        public void invalid_loginVWO(Method method) throws Exception {
            // Navigate, Login to VWO and Assert
            // Abstraction
            test = createTest(method.getName());
            DriverManagerTL3.getDriver().get(PropertyReader3.readKey("url"));
            String expectResult = new Loginpage().loginToVWO(false).error_message_text();
            logger.info("Failed");

            if (expectResult.equalsIgnoreCase(expectResult)) {
                logger.info("Failed");
                test.fail("Failed Testcases");
                test.addScreenCaptureFromBase64String(captureScreenshot(DriverManagerTL3.getDriver()));
                takeScreenShot(method.getName(),DriverManagerTL3.getDriver());
            }

            Assertions.assertThat(expectResult)
                    .isNotBlank().isNotNull().contains(PropertyReader3.readKey("expected_error"));

        }

}
