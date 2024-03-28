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

//userValid = "John Doe"
//passwordValid = "ThisIsNotAPassword"
//userNotExsist = "XX"
//passwordWrong = "wrongPassword"
WebUI.openBrowser(GlobalVariable.base_url)

WebUI.delay(2)

//login failed 
CustomKeywords.'customKeyword.loginUser'(userNotExsist, userNotExsist)

WebUI.delay(2)

WebUI.verifyTextPresent('Login failed! Please ensure the username and password are valid.', true)

WebUI.delay(2)

// login success
CustomKeywords.'customKeyword.loginUser'(userValid, passwordValid)

WebUI.delay(2)

WebUI.verifyTextPresent('Make Appointment', true)

// close browser
WebUI.closeBrowser()

