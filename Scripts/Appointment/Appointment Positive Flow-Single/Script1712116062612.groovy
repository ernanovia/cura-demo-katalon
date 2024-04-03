import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.lang.String.CaseInsensitiveComparator
import java.lang.invoke.SwitchPoint

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
import io.cucumber.tagexpressions.TagExpressionParser.True

WebUI.callTestCase(findTestCase('Logins/Login success'), [('userValid') : 'John Doe', ('passwordValid') : 'ThisIsNotAPassword'
        , ('userNotExsist') : 'XX', ('passwordWrong') : 'wrongPassword'], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('appointmentPage/dropdown_facility'), facility, false)

if(hospital_readmission == true) {
	WebUI.check(findTestObject('Object Repository/appointmentPage/checklist_hospital_readmission'))
}

switch (healthcare_program) {
	case 'Medicare':
	// Select the Medicare
	WebUI.click(findTestObject('Object Repository/appointmentPage/radio_medicare'))
	break
	
	case 'Medicaid':
	// Select the Medicaid
	WebUI.click(findTestObject('Object Repository/appointmentPage/radio_medicaid'))
	break
	
	default: 
	// Select the None
	WebUI.click(findTestObject('Object Repository/appointmentPage/radio_none'))
	break
}

WebUI.setText(findTestObject('Object Repository/appointmentPage/input_visit_date'), visit_date)
WebUI.setText(findTestObject('Object Repository/appointmentPage/input_comment'), comment)
WebUI.click(findTestObject('Object Repository/appointmentPage/button_book'))

WebUI.waitForElementPresent(findTestObject('Object Repository/confirmationPage/btn_goto_homepage'), 0)
WebUI.waitForElementPresent(findTestObject('Object Repository/confirmationPage/h2_appointment_confirmation'), 0)
WebUI.waitForElementPresent(findTestObject('Object Repository/confirmationPage/text_please_be_informed'), 0)
WebUI.waitForElementPresent(findTestObject('Object Repository/confirmationPage/textfield_facility'), 0)
if(hospital_readmission == true) {
	WebUI.verifyElementText(findTestObject('Object Repository/confirmationPage/textfield_hospital_readmission'), 'Yes')
} else{
	WebUI.verifyElementText(findTestObject('Object Repository/confirmationPage/textfield_hospital_readmission'), 'No')
}

switch (healthcare_program) {
	case 'Medicare':
	// verifyElement the Medicare
	WebUI.verifyElementText(findTestObject('Object Repository/confirmationPage/textfield_program'), 'Medicare')
	break
	
	case 'Medicaid':
	// verifyElement the Medicaid
	WebUI.verifyElementText(findTestObject('Object Repository/confirmationPage/textfield_program'), 'Medicaid')
	break
	
	default:
	// verifyElement the None
	WebUI.verifyElementText(findTestObject('Object Repository/confirmationPage/textfield_program'), 'None')
	break
}

WebUI.verifyElementText(findTestObject('Object Repository/confirmationPage/textfield_visit_date'), visit_date)
WebUI.verifyElementText(findTestObject('Object Repository/confirmationPage/textfield_comment'), comment)

WebUI.click(findTestObject('Object Repository/confirmationPage/btn_goto_homepage'))
WebUI.verifyElementPresent(findTestObject('Object Repository/loginPage/appoinmentBtn'), 0)

WebUI.closeBrowser()

