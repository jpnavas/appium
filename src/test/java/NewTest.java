import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class NewTest {
	 ArrayList<String> nombres= new ArrayList<String>();
	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion

	@BeforeMethod
	public void setUpAppium() throws MalformedURLException, InterruptedException {
		String packagename = "com.facebook.lite"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityname = "com.facebook.lite.MainActivity"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		capabilities.setCapability("deviceName", "Moto G (5) Plus"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "6XT4C17902002574"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		capabilities.setCapability("noReset", true);
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@AfterTest
	public void CleanUpAppium() {
		driver.quit();
	}
	@Test
	public void mytest() throws InterruptedException {
		
		try {
			String archivo = "facebook.xlsx";
			String ruta = "C:\\Users\\juan.pablo.navas\\Documents\\" + archivo;
			ArrayList<String> resultados = new ArrayList<String>();
			FileInputStream file = new FileInputStream(new File(ruta));

			// Lee el archivo
			XSSFWorkbook workbook = new XSSFWorkbook(file); // libro
			// obtener la hoja
			XSSFSheet sheet = workbook.getSheetAt(0); // hoja
			// Obtener toas ls filas de la hoja
			Iterator<Row> rowIterator = sheet.iterator();

			Row row = null;

			String nombre = null;
			// recorrido de cada fila hasta el final
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// obtiene celdas fila por fila
				Iterator<Cell> cellIterator = row.cellIterator();

				Cell cell;
				// se recorre cada celda
				while (cellIterator.hasNext()) {
					// se obtiene la celda en especifico y se imprime
					cell = cellIterator.next();
					nombre = String.valueOf(cell.getStringCellValue());
					// Dependiendo del formato
					nombres.add(nombre);
					//System.out.println("Persona....."+numero);
					
				}
				
			}
			
		
			Thread.sleep(4000);
			MobileElement search = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and @bounds='[720,72][900,216]']"));
			search.click();
			Thread.sleep(8000);
			
			
			  System.out.println("entrará");
				MobileElement buscar = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and @bounds='[63,243][903,351]']")); // SELECCION EL BSCADOR 
				System.out.println("malo"); 

			for (String name: nombres) {
				buscar.sendKeys(name + " \n");  // ESCRBE EL NOMBRE 
				

				List<MobileElement> listMobile = driver.findElements(By.xpath("//*[@index='1']"));// SELECCIONA EL PRIMER NOMBRE  Y ABRE EL PERFIL
							  
				listMobile.get(2).click(); 
				Thread.sleep(8000);
			
			
//			MobileElement person = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and @bounds='[63,243][903,351]']"));
//			person.sendKeys(nombres);
//			Thread.sleep(9000);
			
					
			MobileElement search_nico = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and @bounds='[942,243][1056,351]']"));
			search_nico.click();
			Thread.sleep(8000);
//			
//			MobileElement profile = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and @bounds='[0,1019][1080,1199]']"));
//			profile.click();
//			Thread.sleep(8000);
			
			
			}
			 }
		
		
			
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
		
//		MobileElement correo = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and @bounds='[14,255][1066,356]']"));
//		correo.sendKeys("jpablo-na993@hotmail.com");
//		Thread.sleep(9000); 
//		
//		MobileElement password = driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and @bounds='[14,464][1066,565]']"));
//		password.sendKeys("");
//		Thread.sleep(9000);
	}

}
