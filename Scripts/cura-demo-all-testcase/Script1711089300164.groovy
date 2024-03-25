import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

userValid = "John Doe"
passwordValid = "ThisIsNotAPassword"
userNotExsist = "XX"
passwordWrong = "wrongPassword"

WebUI.openBrowser(GlobalVariable.base_url)
WebUI.delay(2)

// login failed 
WebUI.click(findTestObject('Object Repository/loginPage/appoinmentBtn'))
WebUI.setText(findTestObject('Object Repository/loginPage/usernameField'), userNotExsist)
WebUI.setText(findTestObject('Object Repository/loginPage/passwordField'), passwordWrong)
WebUI.click(findTestObject('Object Repository/loginPage/loginBtn'))
WebUI.verifyTextPresent("Make Appointment", true)

// login success
WebUI.click(findTestObject('Object Repository/loginPage/appoinmentBtn'))
WebUI.setText(findTestObject('Object Repository/loginPage/usernameField'), userValid)
WebUI.setText(findTestObject('Object Repository/loginPage/passwordField'), passwordValid)
WebUI.click(findTestObject('Object Repository/loginPage/loginBtn'))
WebUI.verifyTextPresent("Login failed! Please ensure the username and password are valid.", true)

