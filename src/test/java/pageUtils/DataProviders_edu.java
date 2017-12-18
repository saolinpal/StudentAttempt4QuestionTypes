package pageUtils;

import org.testng.annotations.DataProvider;

/**
 * Created by Ila Pandey on 15-11-2017.
 */
public class DataProviders_edu {

    @DataProvider(name = "Authentication")
    public static Object[][] Authentication() throws Exception {

        return ExcelUtils.getTableArray("./Data/Sample5.xlsx","Sheet1");
    }


}
