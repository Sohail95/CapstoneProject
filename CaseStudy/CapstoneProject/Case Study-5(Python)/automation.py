import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture(scope="module")
def browser():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()

def test_automation_panda(browser):
    browser.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/")

    # Verify the Title
    expectedTitle = "Want to practice test automation? Try these demo sites! | Automation Panda"
    actualTitle = browser.title
    if (expectedTitle == actualTitle):
        print("Actual Title of the page is same as Expected Title")
    else:
        print("Actual Title of the page is not same as Expected Title")

    # Click on Speking and verify the Title
    browser.find_element(By.XPATH, "//a[normalize-space()='Speaking']").click()
    expectedtitle = "Speaking | Automation Panda"
    actualtitle = browser.title
    if (expectedtitle == actualtitle):
        print("Actual Title of the Speaking page is same as Expected Title")
    else:
        print("Actual Title of the Speaking page is not same as Expected Title")

    # Verify Keynote Addresses
    keynote = browser.find_element(By.XPATH, "//h2[normalize-space()='Keynote Addresses']")
    if (keynote.is_displayed()):
        print("Keynote Addresses is present")
        keynote_text = keynote.text
        if (keynote_text):
            print("Keynote Addresses text is verified Sucessfully")
    else:
        print("Keynote Addresses is not present")

    # Verify Conference Talks
    conferenceTalk = browser.find_element(By.ID, "conferences")
    if (conferenceTalk.is_displayed()):
        print("Conference Talks is present")
        conferenceTalk_text = conferenceTalk.text
        if (conferenceTalk_text):
            print("Conference Talks text is verified Sucessfully")
    else:
        print("Conference Talks is not present")

