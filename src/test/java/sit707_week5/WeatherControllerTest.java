package sit707_week5;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

    private WeatherController wController;

    @Before
    public void setUp() {
        wController = WeatherController.getInstance();
    }

    @After
    public void tearDown() {
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s223123562";
        Assert.assertNotNull("Student ID is s223123562", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Zainab";
        Assert.assertNotNull("Student name is Zainab", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        int nHours = wController.getTotalHours();
        double minTemperature = Double.MAX_VALUE;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }

        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.0);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        int nHours = wController.getTotalHours();
        double maxTemperature = Double.MIN_VALUE;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }

        Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0.0);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        int nHours = wController.getTotalHours();
        double sumTemp = 0;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            sumTemp += temperatureVal;
        }
        double averageTemp = sumTemp / nHours;

        Assert.assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0.0);
    }
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}